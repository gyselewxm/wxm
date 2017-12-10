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

package com.wxm.mybatis.mapper.common.base.insert;

import org.apache.ibatis.annotations.InsertProvider;

import com.wxm.mybatis.mapper.provider.base.BaseInsertProvider;

/**
 * 
 * <b>Title:</b> 通用保存接口 <br>
 * <b>Description:</b> null的属性也会保存，不会使用数据库默认值 <br>
 * <b>Date:</b> 2017年12月3日 下午10:34:59 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 * 
 * @param <T>
 *            表对应实体
 */
public interface InsertMapper<T> {

    /**
     * 
     * <b>Title:</b> 保存一个实体，null的属性也会保存，不会使用数据库默认值 <br>
     * <b>Description:</b> 仅支持一个主键自动生成 <br>
     * <b>Date:</b> 2017年12月3日 下午10:35:24 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param bean
     *            表对应实体对象
     * @return 操作数
     */
    @InsertProvider(type = BaseInsertProvider.class, method = "dynamicSQL")
    int insert(T bean);

}