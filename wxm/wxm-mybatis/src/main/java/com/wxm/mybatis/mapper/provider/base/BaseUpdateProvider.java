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

package com.wxm.mybatis.mapper.provider.base;

import org.apache.ibatis.mapping.MappedStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wxm.mybatis.mapper.mapperhelper.MapperHelper;
import com.wxm.mybatis.mapper.mapperhelper.MapperTemplate;
import com.wxm.mybatis.mapper.mapperhelper.SqlHelper;

/**
 * 
 * <b>Title:</b> 通用基础更新接口实现类 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月4日 下午7:16:26 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 */
public class BaseUpdateProvider extends MapperTemplate {
    private static Logger logger = LoggerFactory.getLogger(BaseUpdateProvider.class);

    public BaseUpdateProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    /**
     * 
     * <b>Title:</b> 根据主键更新实体全部字段，null值会被更新 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月4日 下午7:16:07 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public String updateByPrimaryKey(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.updateSetColumns(entityClass, null, false, false));
        sql.append(SqlHelper.wherePKColumns(entityClass));
        return sql.toString();
    }

    /**
     * 
     * <b>Title:</b> 根据主键更新属性不为null的值 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月4日 下午7:21:27 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public String updateByPrimaryKeySelective(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.updateSetColumns(entityClass, null, true, isNotEmpty()));
        sql.append(SqlHelper.wherePKColumns(entityClass));
        return sql.toString();
    }

    /**
     * 
     * <b>Title:</b> 根据表对应查询条件实体更新信息，null值会被更新 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 上午11:17:56 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public String update(MappedStatement ms) {
        StringBuilder sql = new StringBuilder();
        Class<?> queryClass = null;
        try {
            queryClass = getQueryClass(ms);
        } catch (Exception e) {
            logger.warn("构建[根据表对应查询条件实体更新信息，null值会被更新]SQL语句异常");
        }
        Class<?> entityClass = getEntityClass(ms);
        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.updateSetColumns(entityClass, null, false, false));
        sql.append(SqlHelper.whereAllUpdateIfColumns(entityClass, queryClass, isNotEmpty()));
        return sql.toString();
    }

    /**
     * 
     * <b>Title:</b> 根据表对应查询条件实体更新属性不为null的值 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午12:57:41 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public String updateSelective(MappedStatement ms) {
        StringBuilder sql = new StringBuilder();
        Class<?> queryClass = null;
        try {
            queryClass = getQueryClass(ms);
        } catch (Exception e) {
            logger.warn("构建[根据表对应查询条件实体更新属性不为null的值]SQL语句异常");
        }
        Class<?> entityClass = getEntityClass(ms);
        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.updateSetColumns(entityClass, null, true, isNotEmpty()));
        sql.append(SqlHelper.whereAllUpdateIfColumns(entityClass, queryClass, isNotEmpty()));
        return sql.toString();
    }
}
