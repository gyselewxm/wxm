package com.wxm.service;

import java.util.List;

/**
 * 
 * <b>Title:</b> 通用查询业务接口 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月10日 下午11:02:29 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 * 
 * @param <T>
 *            表对应实体
 * @param <B>
 *            表对应业务逻辑实体
 */
public interface IRetrieveService<T, B> {

    /**
     * 
     * <b>Title:</b> 获取全部表对应实体信息 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午11:05:07 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @return
     */
    List<T> selectAll();

    /**
     * 
     * <b>Title:</b> 获取全部表对应业务逻辑实体信息 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午11:05:28 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @return
     */
    List<B> selectAllBO();

    /**
     * 
     * <b>Title:</b> 根据主键获取一条表对应实体信息 <br>
     * <b>Description:</b> 方法参数必须包含完整的主键属性，查询条件使用等号 <br>
     * <b>Date:</b> 2017年12月10日 下午11:05:35 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param key
     *            表对应所有主键
     * @return 表对应实体
     */
    T selectByPrimaryKey(Object key);

    /**
     * 
     * <b>Title:</b> 根据主键获取一条表对应业务逻辑实体信息 <br>
     * <b>Description:</b> 方法参数必须包含完整的主键属性，查询条件使用等号 <br>
     * <b>Date:</b> 2017年12月10日 下午11:11:44 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param key
     *            表对应所有主键
     * @return 表对应业务逻辑实体信息
     */
    B selectBOByPrimaryKey(Object key);

    /**
     * 
     * <b>Title:</b> 根据查询条件获取信息总数 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午11:12:01 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param query
     *            表对应查询条件实体
     * @return
     */
    int selectCount(Object query);

    /**
     * 
     * <b>Title:</b> 根据查询条件获取表对应实体信息 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午11:12:24 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param query
     *            表对应查询条件实体
     * @return 表对应实体信息列表
     */
    List<T> select(Object query);

    /**
     * 
     * <b>Title:</b> 根据查询条件获表对应业务逻辑实体信息 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午11:12:37 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param query
     *            表对应查询条件实体
     * @return 表对应业务逻辑实体信息列表
     */
    List<B> selectBO(Object query);

    /**
     * 
     * <b>Title:</b> 根据查询条件获取一条表对应实体信息 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午11:12:50 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param query
     *            表对应查询条件实体
     * @return 表对应实体信息
     */
    T selectOne(Object query);

    /**
     * 
     * <b>Title:</b> 根据查询条件获取一条表对应业务逻辑实体信息 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午11:13:11 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param query
     *            表对应查询条件实体
     * @return 表对应业务逻辑实体信息
     */
    B selectBOOne(Object query);
}
