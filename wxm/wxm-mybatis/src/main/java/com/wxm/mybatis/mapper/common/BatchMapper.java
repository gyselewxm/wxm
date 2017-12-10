package com.wxm.mybatis.mapper.common;

import com.wxm.mybatis.mapper.common.batch.BatchInsertMapper;

/**
 * 
 * <b>Title:</b> 通用批量Mapper接口 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月3日 下午3:36:11 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 * 
 * @param <T>
 *            表对应实体
 */
public interface BatchMapper<T> extends
        BatchInsertMapper<T> {

}
