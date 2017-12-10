package com.wxm.mybatis.mapper.common.ids;

import org.apache.ibatis.annotations.SelectProvider;

import com.wxm.mybatis.mapper.provider.IdsProvider;

import java.util.List;

/**
 * 
 * <b>Title:</b> 通用批量查询接口，根据主键字段查询 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月10日 下午4:37:11 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 * 
 * @param <T>
 *            表对应实体
 */
public interface SelectByIdsMapper<T> {

    /**
     * 
     * <b>Title:</b> 根据主键字符串进行查询，类中只有存在一个带有@Id注解的字段 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午4:38:22 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param ids
     *            如 "1,2,3,4"
     * @return
     */
    @SelectProvider(type = IdsProvider.class, method = "dynamicSQL")
    List<T> selectByIds(String ids);

}
