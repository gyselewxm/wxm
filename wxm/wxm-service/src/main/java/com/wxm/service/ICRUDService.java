package com.wxm.service;

/**
 * <b>标题: </b> SERVICE层增删改查接口 <br/>
 * <b>描述: </b> <br/>
 * <b>作者: </b>吴晓敏 15109870670@139.com <br/>
 * <b>时间: </b>2017年6月25日 下午10:48:00 <br/>
 * <b>版本: </b>1.0
 */
public interface ICRUDService<T, D> extends ICreateService<T>, IRetrieveService<T, D>, IUpdateService<T>, IDeleteService, IPagerService<D> {

}
