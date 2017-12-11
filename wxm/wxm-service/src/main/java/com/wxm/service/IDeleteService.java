package com.wxm.service;

/**
 * 
 * <b>Title:</b> 通用删除业务接口 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月10日 下午11:19:36 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 */
public interface IDeleteService {

    /**
     * 
     * <b>Title:</b> 根据主键字段进行删除 <br>
     * <b>Description:</b> 方法参数必须包含完整的主键属性 <br>
     * <b>Date:</b> 2017年12月10日 下午11:18:38 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param object
     * @return
     */
    int deleteByPrimaryKey(Object object);

    /**
     * 
     * <b>Title:</b> 根据表对应查询条件实体删除信息 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月10日 下午11:18:54 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param query
     *            表对应查询条件实体
     * @return
     */
    int delete(Object query);
}
