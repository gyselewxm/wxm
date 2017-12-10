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

package com.wxm.mybatis.mapper.common.base.select;

import org.apache.ibatis.annotations.SelectProvider;

import com.wxm.mybatis.mapper.provider.base.BaseSelectProvider;

import java.util.List;

/**
 * 
 * <b>Title:</b> 根据查询条件获取信息<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月4日 下午12:13:34 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 * 
 * @param <T>
 *            表对应实体
 * @param <B>
 *            表对应业务逻辑实体
 * @param <Q>
 *            表对应查询条件实体
 */
public interface SelectMapper<T, B, Q> {

    /**
     * 
     * <b>Title:</b> 根据查询条件获取表对应实体信息 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月4日 下午12:14:35 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param query
     *            表对应查询条件实体
     * @return 表对应实体信息列表
     */
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    List<T> select(Q query);

    /**
     * 
     * <b>Title:</b> 根据查询条件获表对应业务逻辑实体信息 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月4日 下午12:15:25 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param query
     *            表对应查询条件实体
     * @return 表对应业务逻辑实体信息列表
     */
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    List<B> selectBO(Q query);

}