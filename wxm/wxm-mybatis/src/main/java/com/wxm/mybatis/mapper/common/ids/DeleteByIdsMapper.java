package com.wxm.mybatis.mapper.common.ids;

import org.apache.ibatis.annotations.DeleteProvider;

import com.wxm.mybatis.mapper.provider.IdsProvider;

/**
 * 
 * <b>Title:</b> 通用批量删除接口 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月10日 下午4:35:21 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 */
public interface DeleteByIdsMapper {

    /**
     * 
     * <b>Title:</b> 根据主键字符串进行删除，类中只有存在一个带有@Id注解的字段 <br>
     * <b>Description:</b> ids 如 "1,2,3,4" <br>
     * <b>Date:</b> 2017年12月10日 下午4:35:29 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ids
     * @return
     */
    @DeleteProvider(type = IdsProvider.class, method = "dynamicSQL")
    int deleteByIds(String ids);

}
