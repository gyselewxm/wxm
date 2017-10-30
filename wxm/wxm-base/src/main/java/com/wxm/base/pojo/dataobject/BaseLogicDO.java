package com.wxm.base.pojo.dataobject;

import javax.persistence.Column;

/**
 * 
 * <b>Title:</b> 逻辑删除属性基类<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年10月30日 上午11:40:48<br>
 * @author wuxm
 * @version 1.0.0
 */
public class BaseLogicDO extends BaseUUIDDO {
    /**
     * 是否删除
     */
    @Column(name = "is_deleted")
    private boolean deleted;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
