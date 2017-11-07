package com.wxm.mybatis.mapper;

import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseInsertMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;

import com.wxm.mybatis.mapper.common.base.BaseSelectMapper;

/**
 * 
 * <b>Title:</b> 基础Mapper<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年11月6日 下午4:28:18<br>
 * 
 * @author wuxm
 * @version 1.0.0
 * @param <T>
 * @param <D>
 * @param <Q>
 */
public interface BaseMapper<T, V, D, Q> extends
        BaseInsertMapper<T>,
        BaseSelectMapper<T, D, Q>,
        BaseUpdateMapper<T>,
        BaseDeleteMapper<T> {

}
