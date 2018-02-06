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
 * <b>Title:</b> 通用基础查询接口实现类 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月3日 下午10:47:26 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 */
public class BaseSelectProvider extends MapperTemplate {
    private static Logger logger = LoggerFactory.getLogger(BaseSelectProvider.class);

    public BaseSelectProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    /**
     * 
     * <b>Title:</b> 根据主键获取一条表对应实体信息 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月3日 下午4:07:21 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public String selectByPrimaryKey(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        // 将返回值修改为表对应实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.selectAllColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.wherePKColumns(entityClass));
        return sql.toString();
    }

    /**
     * 
     * <b>Title:</b> 根据主键获取一条表对应业务逻辑实体信息 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月3日 下午4:18:31 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public String selectBOByPrimaryKey(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        // 将返回值修改为表对应业务逻辑实体类型
        setBOResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.selectAllBOColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.wherePKColumns(entityClass));
        return sql.toString();
    }

    /**
     * 
     * <b>Title:</b> 根据查询条件获取一条表对应实体信息 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月3日 下午10:48:08 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public String selectOne(MappedStatement ms) {
        StringBuilder sql = new StringBuilder();
        Class<?> queryClass = null;
        try {
            queryClass = getQueryClass(ms);
        } catch (Exception e) {
            logger.warn("构建[根据查询条件获取一条表对应实体信息]SQL语句异常");
        }
        Class<?> entityClass = getEntityClass(ms);
        // 修改返回值类型为表对应实体类型
        setResultType(ms, entityClass);
        sql.append(SqlHelper.selectAllColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.whereAllQueryIfColumns(entityClass, queryClass, isNotEmpty()));
        return sql.toString();
    }

    /**
     * 
     * <b>Title:</b> 根据查询条件获取一条表对应业务逻辑实体信息 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月3日 下午10:48:23 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public String selectBOOne(MappedStatement ms) {
        StringBuilder sql = new StringBuilder();
        Class<?> queryClass = null;
        try {
            queryClass = getQueryClass(ms);
        } catch (Exception e) {
            logger.warn("构建[根据查询条件获取一条表对应业务逻辑实体信息]SQL语句异常");
        }
        Class<?> entityClass = getEntityClass(ms);
        // 修改返回值类型为表对应业务逻辑实体类型
        setBOResultType(ms, entityClass);
        sql.append(SqlHelper.selectAllBOColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.whereAllQueryIfColumns(entityClass, queryClass, isNotEmpty()));
        return sql.toString();
    }

    /**
     * 
     * <b>Title:</b> 根据查询条件获取表对应实体信息 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月4日 下午12:23:08 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public String select(MappedStatement ms) {
        StringBuilder sql = new StringBuilder();
        Class<?> queryClass = null;
        try {
            queryClass = getQueryClass(ms);
        } catch (Exception e) {
            logger.warn("构建[根据查询条件获取表对应实体信息]SQL语句异常");
        }
        Class<?> entityClass = getEntityClass(ms);
        // 修改返回值类型为表对应实体类型
        setResultType(ms, entityClass);
        sql.append(SqlHelper.selectAllColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.whereAllQueryIfColumns(entityClass, queryClass, isNotEmpty()));
        sql.append(SqlHelper.orderByDefault(entityClass));
        return sql.toString();
    }

    /**
     * 
     * <b>Title:</b> 根据查询条件获表对应业务逻辑实体信息 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月4日 下午12:23:08 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public String selectBO(MappedStatement ms) {
        StringBuilder sql = new StringBuilder();
        Class<?> queryClass = null;
        try {
            queryClass = getQueryClass(ms);
        } catch (Exception e) {
            logger.warn("构建[根据查询条件获表对应业务逻辑实体信息]SQL语句异常");
        }
        Class<?> entityClass = getEntityClass(ms);
        // 修改返回值类型为表对应实体类型
        setBOResultType(ms, entityClass);
        sql.append(SqlHelper.selectAllBOColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.whereAllQueryIfColumns(entityClass, queryClass, isNotEmpty()));
        sql.append(SqlHelper.orderByDefault(entityClass));
        return sql.toString();
    }

    /**
     * 
     * <b>Title:</b> 根据查询条件获取信息总数 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月3日 下午4:09:13 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public String selectCount(MappedStatement ms) {
        StringBuilder sql = new StringBuilder();
        Class<?> queryClass = null;
        try {
            queryClass = getQueryClass(ms);
        } catch (Exception e) {
            logger.warn("构建[根据查询条件获取信息总数]SQL语句异常");
        }
        Class<?> entityClass = getEntityClass(ms);
        sql.append(SqlHelper.selectCount(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.whereAllQueryIfColumns(entityClass, queryClass, isNotEmpty()));
        return sql.toString();
    }

    /**
     * 
     * <b>Title:</b> 获取全部表对应实体信息 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月4日 上午9:29:26 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public String selectAll(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        // 修改返回值类型为表对应实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.selectAllColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.orderByDefault(entityClass));
        return sql.toString();
    }

    /**
     * 
     * <b>Title:</b> 获取全部表对应业务逻辑实体信息 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月4日 上午9:29:59 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public String selectAllBO(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        // 修改返回值类型为表对应实体类型
        setBOResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.selectAllBOColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.orderByDefault(entityClass));
        return sql.toString();
    }
}
