package com.wxm.mybatis.mapper.common.base.select;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.wxm.mybatis.mapper.provider.base.BaseSelectProvider;

/**
 * 
 * <b>Title:</b> 查询全部结果<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年11月7日 上午9:08:34<br>
 * 
 * @author wuxm
 * @version 1.0.0
 * @param <D>
 *            DTO实体
 */
public interface SelectAllMapper<D> {
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    List<D> selectAll();
}
