package com.wxm.service;

import java.util.List;

/**
 * 
 * <b>Title:</b> 通用删除业务接口 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月11日 下午1:37:14 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 * 
 * @param <T>
 *            表对应实体
 */
public interface ICreateService<T> {
    /**
     * 
     * <b>Title:</b> 保存一个实体，null的属性也会保存，不会使用数据库默认值 <br>
     * <b>Description:</b> 仅支持一个主键自动生成 <br>
     * <b>Date:</b> 2017年12月11日 下午12:28:10 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param bean
     *            表对应实体对象
     * @return 操作数
     */
    int insert(T bean);

    /**
     * 
     * <b>Title:</b> 保存一个实体，null的属性不会保存，会使用数据库默认值 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年12月11日 下午12:28:29 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param bean
     *            表对应实体对象
     * @return 操作数
     */
    int insertSelective(T bean);

    /**
     * 
     * <b>Title:</b> 批量保存 <br>
     * <b>Description:</b> null的属性也会保存，不会使用数据库默认值，另外该接口不提供主键策略，限制实体的主键属性值不能为空 <br>
     * <b>Date:</b> 2017年12月11日 下午12:28:45 <br>
     * <b>Author:</b> Gysele <br>
     * <b>Version:</b> 1.0.0
     * 
     * @param list
     *            表对应实体列表
     * @return
     */
    int insertList(List<T> list);
}
