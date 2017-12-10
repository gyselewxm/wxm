package com.wxm.service;

import com.wxm.mybatis.datasource.annotation.DataSource;
import com.wxm.mybatis.datasource.code.RoutingStrategy;

/**
 * 
 * <b>Title:</b> 新增相关SERVICE接口<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年11月7日 上午9:04:01<br>
 * 
 * @author wuxm
 * @version 1.0.0
 * @param <T>
 */
public interface ICreateService<T> {
    /**
     * 
     * <b>Title:</b> 添加记录<br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年11月7日 上午10:00:59<br>
     * 
     * @author wuxm
     * @param t
     *            实体
     * @return 返回操作的记录数
     */
    @DataSource(RoutingStrategy.MASTER)
    public int insert(T t);

    /**
     * 
     * <b>Title:</b> 批量添加记录<br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年11月7日 上午10:01:15<br>
     * 
     * @author wuxm
     * @param t
     *            实体列表
     * @return 返回操作的记录数
     */
    @DataSource(RoutingStrategy.MASTER)
    public int insertSelective(T t);
}
