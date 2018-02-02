package com.wxm.service.base;

/**
 * 
 * <b>Title:</b> 通用增删改查业务接口 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月11日 下午1:37:58 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 * 
 * @param <T>
 *            表对应实体
 * @param <B>
 *            表对应业务逻辑实体
 */
public interface ICRUDService<T, B> extends
        ICreateService<T>,
        IRetrieveService<T, B>,
        IUpdateService<T>,
        IDeleteService,
        IPagerService<B> {

}
