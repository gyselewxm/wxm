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

package com.wxm.mybatis.mapper.common.base.update;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.UpdateProvider;

import com.wxm.mybatis.mapper.provider.base.BaseUpdateProvider;

/**
 * 
 * <b>Title:</b> 根据主键更新实体全部字段，null值会被更新 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月4日 下午7:15:07 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 * 
 * @param <T>
 *            表对应实体
 */
public interface UpdateByPrimaryKeyMapper<T> {

    /**
     * 
     * <b>Title:</b> 根据主键更新实体全部字段，null值会被更新 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月4日 下午7:14:48 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param bean
     *            表对应实体
     * @return
     */
    @UpdateProvider(type = BaseUpdateProvider.class, method = "dynamicSQL")
    @Options(useCache = false, useGeneratedKeys = false)
    int updateByPrimaryKey(T bean);

}