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

import com.wxm.mybatis.mapper.mapperhelper.MapperHelper;
import com.wxm.mybatis.mapper.mapperhelper.MapperTemplate;
import com.wxm.mybatis.mapper.mapperhelper.SqlHelper;

/**
 * 
 * <b>Title:</b> 通用基础删除接口实现类 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月10日 下午4:01:26 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 */
public class BaseDeleteProvider extends MapperTemplate {

    public BaseDeleteProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    /**
     * 
     * <b>Title:</b> 根据表对应查询条件实体删除信息 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午4:02:21 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public String delete(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        Class<?> queryClass = getQueryClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.deleteFromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.whereAllQueryIfColumns(entityClass, queryClass, isNotEmpty()));
        return sql.toString();
    }

    /**
     * 
     * <b>Title:</b> 根据主键字段进行删除 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午4:14:03 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ms
     * @return
     */
    public String deleteByPrimaryKey(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.deleteFromTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.wherePKColumns(entityClass));
        return sql.toString();
    }
}
