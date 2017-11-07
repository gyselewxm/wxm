package com.wxm.mybatis.mapper.common.base.select;

import org.apache.ibatis.annotations.SelectProvider;

import com.wxm.mybatis.mapper.provider.base.BaseSelectProvider;

/**
 * 
 * <b>Title:</b> 根据条件查询信息个数<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年11月7日 上午9:13:51<br>
 * @author wuxm
 * @version 1.0.0
 * @param <Q> Query实体
 */
public interface SelectCountMapper<Q> {

    /**
     * 
     * <b>Title:</b> 根据查询条件属性查询总数，查询条件使用等号<br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年11月7日 上午9:18:10<br>
     * @author wuxm
     * @param query
     * @return
     */
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    int selectCount(Q query);
}
