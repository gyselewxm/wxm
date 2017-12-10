/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.wxm.mybatis.mapper.mapperhelper;

import org.apache.ibatis.mapping.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.xmltags.DynamicSqlSource;
import org.apache.ibatis.scripting.xmltags.SqlNode;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;

import com.wxm.mybatis.mapper.MapperException;
import com.wxm.mybatis.mapper.entity.EntityColumn;
import com.wxm.mybatis.mapper.entity.EntityTable;
import com.wxm.mybatis.mapper.util.StringUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static com.wxm.mybatis.mapper.util.MsUtil.getMapperClass;
import static com.wxm.mybatis.mapper.util.MsUtil.getMethodName;

/**
 * 通用Mapper模板类，扩展通用Mapper时需要继承该类
 *
 * @author liuzh
 */
public abstract class MapperTemplate {
    private static final XMLLanguageDriver languageDriver = new XMLLanguageDriver();
    protected Map<String, Method> methodMap = new ConcurrentHashMap<String, Method>();
    protected Map<String, Class<?>> entityClassMap = new ConcurrentHashMap<String, Class<?>>();
    protected Class<?> mapperClass;
    protected MapperHelper mapperHelper;

    public MapperTemplate(Class<?> mapperClass, MapperHelper mapperHelper) {
        this.mapperClass = mapperClass;
        this.mapperHelper = mapperHelper;
    }

    /**
     * 该方法仅仅用来初始化ProviderSqlSource
     *
     * @param record
     * @return
     */
    public String dynamicSQL(Object record) {
        return "dynamicSQL";
    }

    /**
     * 添加映射方法
     *
     * @param methodName
     * @param method
     */
    public void addMethodMap(String methodName, Method method) {
        methodMap.put(methodName, method);
    }

    public String getUUID() {
        return mapperHelper.getConfig().getUUID();
    }

    public String getIDENTITY() {
        return mapperHelper.getConfig().getIDENTITY();
    }

    /**
     * 获取IDENTITY值的表达式
     *
     * @param column
     * @return
     */
    public String getIDENTITY(EntityColumn column) {
        return MessageFormat.format(mapperHelper.getConfig().getIDENTITY(), column.getSequenceName(), column.getColumn(), column.getProperty(), column.getTable().getName());
    }

    public boolean isBEFORE() {
        return mapperHelper.getConfig().isBEFORE();
    }

    public boolean isNotEmpty() {
        return mapperHelper.getConfig().isNotEmpty();
    }

    public boolean isCheckExampleEntityClass() {
        return mapperHelper.getConfig().isCheckExampleEntityClass();
    }

    /**
     * 是否支持该通用方法
     *
     * @param msId
     * @return
     */
    public boolean supportMethod(String msId) {
        Class<?> mapperClass = getMapperClass(msId);
        if (mapperClass != null && this.mapperClass.isAssignableFrom(mapperClass)) {
            String methodName = getMethodName(msId);
            return methodMap.get(methodName) != null;
        }
        return false;
    }

    /**
     * 
     * <b>Title:</b> 设置表对应实体返回值类型 <br>
     * <b>Description:</b> 为了让typeHandler在select时有效，改为设置resultMap <br>
     * <b>Date:</b> 2017年12月3日 下午2:43:20 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @param entityClass
     *            表对应实体类
     */
    protected void setResultType(MappedStatement ms, Class<?> entityClass) {
        EntityTable entityTable = EntityHelper.getEntityTable(entityClass);
        List<ResultMap> resultMaps = new ArrayList<ResultMap>();
        resultMaps.add(entityTable.getResultMap(ms.getConfiguration()));
        MetaObject metaObject = SystemMetaObject.forObject(ms);
        metaObject.setValue("resultMaps", Collections.unmodifiableList(resultMaps));
    }

    /**
     * 
     * <b>Title:</b> 设置表对应业务逻辑实体返回值类型 <br>
     * <b>Description:</b> 为了让typeHandler在select时有效，改为设置resultMap<br>
     * <b>Date:</b> 2017年12月3日 下午2:42:16 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @param entityClass
     *            表对应实体类
     */
    protected void setBOResultType(MappedStatement ms, Class<?> entityClass) {
        EntityTable entityTable = EntityHelper.getEntityTable(entityClass);
        List<ResultMap> resultMaps = new ArrayList<ResultMap>();
        resultMaps.add(entityTable.getBOResultMap(ms.getConfiguration()));
        MetaObject metaObject = SystemMetaObject.forObject(ms);
        metaObject.setValue("resultMaps", Collections.unmodifiableList(resultMaps));
    }

    /**
     * 重新设置SqlSource
     *
     * @param ms
     * @param sqlSource
     */
    protected void setSqlSource(MappedStatement ms, SqlSource sqlSource) {
        MetaObject msObject = SystemMetaObject.forObject(ms);
        msObject.setValue("sqlSource", sqlSource);
    }

    /**
     * 重新设置SqlSource
     *
     * @param ms
     * @throws java.lang.reflect.InvocationTargetException
     * @throws IllegalAccessException
     */
    public void setSqlSource(MappedStatement ms) throws Exception {
        if (this.mapperClass == getMapperClass(ms.getId())) {
            throw new MapperException("请不要配置或扫描通用Mapper接口类：" + this.mapperClass);
        }
        Method method = methodMap.get(getMethodName(ms));
        try {
            // 第一种，直接操作ms，不需要返回值
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(this, ms);
            }
            // 第二种，返回SqlNode
            else if (SqlNode.class.isAssignableFrom(method.getReturnType())) {
                SqlNode sqlNode = (SqlNode) method.invoke(this, ms);
                DynamicSqlSource dynamicSqlSource = new DynamicSqlSource(ms.getConfiguration(), sqlNode);
                setSqlSource(ms, dynamicSqlSource);
            }
            // 第三种，返回xml形式的sql字符串
            else if (String.class.equals(method.getReturnType())) {
                String xmlSql = (String) method.invoke(this, ms);
                SqlSource sqlSource = createSqlSource(ms, xmlSql);
                // 替换原有的SqlSource
                setSqlSource(ms, sqlSource);
            } else {
                throw new MapperException("自定义Mapper方法返回类型错误,可选的返回类型为void,SqlNode,String三种!");
            }
        } catch (IllegalAccessException e) {
            throw new MapperException(e);
        } catch (InvocationTargetException e) {
            throw new MapperException(e.getTargetException() != null ? e.getTargetException() : e);
        }
    }

    /**
     * 通过xmlSql创建sqlSource
     *
     * @param ms
     * @param xmlSql
     * @return
     */
    public SqlSource createSqlSource(MappedStatement ms, String xmlSql) {
        return languageDriver.createSqlSource(ms.getConfiguration(), "<script>\n\t" + xmlSql + "</script>", null);
    }

    /**
     * 
     * <b>Title:</b> 获取表对应实体类型 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月3日 下午1:54:59 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public Class<?> getEntityClass(MappedStatement ms) {
        String msId = ms.getId();
        if (!entityClassMap.containsKey(msId)) {
            setClassMap(msId);
        }
        return entityClassMap.get(msId);
    }

    /**
     * 
     * <b>Title:</b> 获取表对应业务逻辑实体类型 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月3日 下午1:54:38 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    @Deprecated
    public Class<?> getBOClass(MappedStatement ms) {
        String msId = ms.getId();
        String boMsId = String.format("%s_BO", msId);
        if (!entityClassMap.containsKey(boMsId)) {
            setClassMap(msId);
        }
        return entityClassMap.get(boMsId);
    }

    /**
     * 
     * <b>Title:</b> 获取表对应查询条件实体类型 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月3日 下午1:55:11 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public Class<?> getQueryClass(MappedStatement ms) {
        String msId = ms.getId();
        String queryMsId = String.format("%s_QUERY", msId);
        if (!entityClassMap.containsKey(queryMsId)) {
            setClassMap(msId);
        }
        return entityClassMap.get(queryMsId);
    }

    /**
     * 
     * <b>Title:</b>设置实体Map <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月1日 下午2:09:30 <br>
     * <b>Author:</b> Gysele
     * 
     * @param msId
     */
    private void setClassMap(String msId) {
        Class<?> mapperClass = getMapperClass(msId);
        Type[] types = mapperClass.getGenericInterfaces();
        for (Type type : types) {
            if (type instanceof ParameterizedType) {
                ParameterizedType t = (ParameterizedType) type;
                if (t.getRawType() == this.mapperClass || this.mapperClass.isAssignableFrom((Class<?>) t.getRawType())) {
                    Type[] classTypes = t.getActualTypeArguments();
                    if (null == classTypes || 0 == classTypes.length) {
                        continue;
                    }
                    /**
                     * 表对应实体
                     */
                    Class<?> entityType = (Class<?>) classTypes[0];
                    // 获取该类型后，第一次对该类型进行初始化
                    EntityHelper.initEntityNameMap(entityType, mapperHelper.getConfig());
                    entityClassMap.put(msId, entityType);

                    /**
                     * 表对应业务逻辑实体
                     */
                    if (1 < classTypes.length) {
                        Class<?> queryType = (Class<?>) classTypes[2];
                        entityClassMap.put(String.format("%s_BO", msId), queryType);
                    }

                    /**
                     * 表对应查询条件实体
                     */
                    if (2 < classTypes.length) {
                        Class<?> queryType = (Class<?>) classTypes[2];
                        entityClassMap.put(String.format("%s_QUERY", msId), queryType);
                    }
                    return;
                }
            }
        }
        throw new MapperException("无法获取 " + msId + " 方法的泛型信息!");
    }

    /**
     * 获取序列下个值的表达式
     *
     * @param column
     * @return
     */
    protected String getSeqNextVal(EntityColumn column) {
        return MessageFormat.format(mapperHelper.getConfig().getSeqFormat(), column.getSequenceName(), column.getColumn(), column.getProperty(), column.getTable().getName());
    }

    /**
     * 获取实体类的表名
     *
     * @param entityClass
     * @return
     */
    protected String tableName(Class<?> entityClass) {
        EntityTable entityTable = EntityHelper.getEntityTable(entityClass);
        String prefix = entityTable.getPrefix();
        if (StringUtil.isEmpty(prefix)) {
            // 使用全局配置
            prefix = mapperHelper.getConfig().getPrefix();
        }
        if (StringUtil.isNotEmpty(prefix)) {
            return prefix + "." + entityTable.getName();
        }
        return entityTable.getName();
    }

}
