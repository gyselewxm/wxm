package com.wxm.mybatis.mapper.common.base.update;

import org.apache.ibatis.annotations.UpdateProvider;

import com.wxm.mybatis.mapper.provider.base.BaseUpdateProvider;

/**
 * 
 * <b>Title:</b> 根据表对应查询条件实体更新信息，null值会被更新 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月10日 上午11:05:21 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 */
public interface UpdateMapper {

    /**
     * 
     * <b>Title:</b> 根据表对应查询条件实体更新信息，null值会被更新 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 上午11:04:46 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @return
     */
    @UpdateProvider(type = BaseUpdateProvider.class, method = "dynamicSQL")
    int update(Object object);

}
