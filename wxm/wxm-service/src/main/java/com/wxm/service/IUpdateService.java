package com.wxm.service;

import java.util.List;

import com.wxm.mybatis.datasource.annotation.DataSource;
import com.wxm.mybatis.datasource.code.RoutingStrategy;

/**
 * 
 * <b>Title:</b> 更新相关SERVICE接口<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年11月7日 上午10:02:17<br>
 * 
 * @author wuxm
 * @version 1.0.0
 * @param <T>
 */
public interface IUpdateService<T> {
    /**
     * 
     * <b>Title:</b> 根据主键更新实体全部字段，null值会被更新<br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年11月7日 上午10:02:30<br>
     * 
     * @author wuxm
     * @param t
     * @return
     */
    @DataSource(RoutingStrategy.MASTER)
    public int updateByPrimaryKey(T t);

    /**
     * 
     * <b>Title:</b> 根据主键更新属性不为null的值<br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年11月6日 下午6:01:47<br>
     * 
     * @author wuxm
     * @param t
     * @return
     */
    @DataSource(RoutingStrategy.MASTER)
    public int updateByPrimaryKeySelective(T t);

    /**
     * 
     * <b>Title:</b> 批量更新记录 <br>
     * <b>Description:</b> 根据主键更新属性不为null的值<br>
     * <b>Date:</b> 2017年11月7日 上午10:02:41<br>
     * 
     * @author wuxm
     * @param ts
     * @return
     */
    @DataSource(RoutingStrategy.MASTER)
    public int batchUpdate(List<T> ts);
}
