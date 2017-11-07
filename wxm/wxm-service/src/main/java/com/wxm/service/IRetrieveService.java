package com.wxm.service;

import java.util.List;
import java.util.Map;

/**
 * 
 * <b>Title:</b> 查询相关SERVICE接口<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年11月7日 上午10:12:12<br>
 * 
 * @author wuxm
 * @version 1.0.0
 * @param <T>
 * @param <V>
 */
public interface IRetrieveService<T, D> {

    /**
     * 
     * <b>Title:</b> 根据ID查询实体信息<br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年11月7日 上午10:12:25<br>
     * 
     * @author wuxm
     * @param id
     *            实体ID
     * @return 实体信息
     */
    public D queryOne(String id);

    /**
     * 
     * <b>Title:</b> 根据ID查询视图信息<br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年11月7日 上午10:12:57<br>
     * 
     * @author wuxm
     * @param id
     *            实体ID
     * @return 视图信息
     */
    // public V queryVOne(String id);

    /**
     * 
     * <b>Title:</b> 根据查询条件获取实体信息列表<br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年11月7日 上午10:13:21<br>
     * 
     * @author wuxm
     * @param params
     *            查询条件
     * @return 视图信息列表
     */
    public List<T> queryList(Map<String, Object> params);

    /**
     * 
     * <b>Title:</b> 根据查询条件获取视图信息列表<br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年11月7日 上午10:13:46<br>
     * 
     * @author wuxm
     * @param params
     *            查询条件
     * @return 视图信息列表
     */
    // public List<V> queryVList(Map<String, Object> params);

    /**
     * 
     * <b>Title:</b> 根据查询条件获取实体信息个数<br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年11月7日 上午10:14:18<br>
     * 
     * @author wuxm
     * @param params
     *            查询条件
     * @return 实体信息个数
     */
    public int count(Map<String, Object> params);

}
