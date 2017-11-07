package com.wxm.mybatis.mapper.common.base.select;

import org.apache.ibatis.annotations.SelectProvider;

import com.wxm.mybatis.mapper.provider.base.BaseSelectProvider;

/**
 * 
 * <b>Title:</b> 根据查询条件查询一条信息<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年11月7日 上午9:23:48<br>
 * 
 * @author wuxm
 * @version 1.0.0
 * @param <D>
 *            DTO实体
 * @param <Q>
 *            Query查询条件
 */
public interface SelectOneMapper<D, Q> {

    /**
     * 
     * <b>Title:</b> 根据查询条件进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号<br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年11月7日 上午9:24:41<br>
     * 
     * @author wuxm
     * @param query
     * @return
     */
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    D queryById(String id);
}
