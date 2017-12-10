package com.wxm.service;

/**
 * 
 * <b>Title:</b> 通用更新业务接口 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月10日 下午11:00:54 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 * 
 * @param <T>
 *            表对应实体
 */
public interface IUpdateService<T> {
    /**
     * 
     * <b>Title:</b> 根据主键更新实体全部字段，null值会被更新 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午10:43:38 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param bean
     *            表对应实体
     * @return
     */
    int updateByPrimaryKey(T bean);

    /**
     * 
     * <b>Title:</b> 根据主键更新属性不为null的值 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午10:44:35 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param bean
     *            表对应实体
     * @return
     */
    int updateByPrimaryKeySelective(T bean);

    /**
     * 
     * <b>Title:</b> 根据表对应查询条件实体更新信息，null值会被更新 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午10:51:35 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param query
     *            表对应查询条件实体
     * @return
     */
    int update(Object query);

    /**
     * 
     * <b>Title:</b> 根据表对应查询条件实体更新属性不为null的值 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午10:52:21 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param query
     *            表对应查询条件实体
     * @return
     */
    int updateSelective(Object query);
}
