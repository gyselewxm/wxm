package com.wxm.mybatis.mapper.common.base.select;

import org.apache.ibatis.annotations.SelectProvider;

import com.wxm.mybatis.mapper.provider.base.BaseSelectProvider;

/**
 * 
 * <b>Title:</b> 根据主键查询信息<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年11月7日 上午9:11:43<br>
 * 
 * @author wuxm
 * @version 1.0.0
 * @param <D>
 *            DTO实体
 */
public interface SelectByPrimaryKeyMapper<D> {

    /**
     * 
     * <b>Title:</b> 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号<br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年11月7日 上午9:12:00<br>
     * 
     * @author wuxm
     * @param key
     * @return
     */
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    D selectByPrimaryKey(Object key);
}
