package com.wxm.mybatis.mapper.common.base.update;

import org.apache.ibatis.annotations.UpdateProvider;

import com.wxm.mybatis.mapper.provider.base.BaseUpdateProvider;

/**
 * <b>Title:</b> 根据表对应查询条件实体更新属性不为null的值 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月10日 下午3:36:35 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 */
public interface UpdateSelectiveMapper {

    /**
     * 
     * <b>Title:</b> 根据表对应查询条件实体更新属性不为null的值 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午3:42:02 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param object
     * @return
     */
    @UpdateProvider(type = BaseUpdateProvider.class, method = "dynamicSQL")
    int updateSelective(Object object);
}
