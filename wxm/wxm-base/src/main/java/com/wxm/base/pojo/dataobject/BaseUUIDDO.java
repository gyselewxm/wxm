package com.wxm.base.pojo.dataobject;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * <b>Title:</b> UUID基类<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年10月30日 上午11:40:59<br>
 * 
 * @author wuxm
 * @version 1.0.0
 */
public class BaseUUIDDO {
    /**
     * UUID主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "UUID")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
