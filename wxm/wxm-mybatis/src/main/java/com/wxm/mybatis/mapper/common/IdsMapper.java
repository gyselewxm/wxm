package com.wxm.mybatis.mapper.common;

import com.wxm.mybatis.mapper.common.ids.DeleteByIdsMapper;
import com.wxm.mybatis.mapper.common.ids.SelectByIdsMapper;

/**
 * 
 * <b>Title:</b> 通用主键批量操作接口 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月10日 下午4:39:15 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 * 
 * @param <T>
 *            表对应实体
 */
public interface IdsMapper<T> extends
        SelectByIdsMapper<T>,
        DeleteByIdsMapper {

}
