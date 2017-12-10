package com.wxm.service.abs;

import org.springframework.beans.factory.annotation.Autowired;

import com.wxm.mybatis.mapper.common.Mapper;

/**
 * 
 * <b>Title:</b> 基础SERVICE接口<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年11月7日 上午9:04:25<br>
 * 
 * @author wuxm
 * @version 1.0.0
 * @param <T>
 * @param <V>
 */
public abstract class ABaseService<T, B, Q> {
    @Autowired
    protected Mapper<T, B, Q> mapper;
}
