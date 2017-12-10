package com.wxm.service.abs;

import com.wxm.service.ICRUDService;

/**
 * <b>标题: </b> 增删改查相关SERVICE抽象类 <br/>
 * <b>描述: </b> <br/>
 * <b>作者: </b>吴晓敏 15109870670@139.com <br/>
 * <b>时间: </b>2017年6月25日 下午10:49:30 <br/>
 * <b>版本: </b>1.0
 */
public abstract class ACRUDService<T, B, Q> extends ABaseService<T, B, Q> implements
        ICRUDService<T, B> {
}
