package com.wxm.base.pojo.dataobject;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * UUID基类
 * 
 * @author wuxm
 * @date 2017年10月27日 上午11:50:27
 * @see 1.0.0
 */
public class BaseUUIDDO {
    /**
     * UUID主键
     */
    @Id
    @Column
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
