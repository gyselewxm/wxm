package com.wxm.mybatis.mapper.common.base;

import tk.mybatis.mapper.common.base.select.ExistsWithPrimaryKeyMapper;

import com.wxm.mybatis.mapper.common.base.select.SelectAllMapper;
import com.wxm.mybatis.mapper.common.base.select.SelectByPrimaryKeyMapper;
import com.wxm.mybatis.mapper.common.base.select.SelectCountMapper;
import com.wxm.mybatis.mapper.common.base.select.SelectMapper;
import com.wxm.mybatis.mapper.common.base.select.SelectOneMapper;

/**
 * 
 * <b>Title:</b> 查询基类<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年11月7日 上午9:40:24<br>
 * @author wuxm
 * @version 1.0.0
 * @param <T>
 * @param <D>
 * @param <Q>
 */
public interface BaseSelectMapper<T, D, Q> extends
        ExistsWithPrimaryKeyMapper<T>,
        SelectAllMapper<D>,
        SelectByPrimaryKeyMapper<D>,
        SelectCountMapper<Q>,
        SelectMapper<D, Q>,
        SelectOneMapper<D, Q> {

}
