package com.wxm.mybatis.mapper.common.base.select;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.wxm.mybatis.mapper.provider.base.BaseSelectProvider;

/**
 * 
 * <b>Title:</b> 根据查询条件查询信息<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年11月7日 上午9:21:44<br>
 * 
 * @author wuxm
 * @version 1.0.0
 * @param <D>
 *            DTO实体
 * @param <Q>
 *            Query查询条件
 */
public interface SelectMapper<D, Q> {

    /**
     * 
     * <b>Title:</b> 根据实体中的属性值进行查询，查询条件使用等号<br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年11月7日 上午9:22:47<br>
     * 
     * @author wuxm
     * @param query
     * @return
     */
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    List<D> select(Q query);
}
