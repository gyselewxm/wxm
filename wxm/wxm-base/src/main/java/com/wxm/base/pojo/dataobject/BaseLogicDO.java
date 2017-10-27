package com.wxm.base.pojo.dataobject;

import javax.persistence.Column;

/**
 * 逻辑删除属性基类
 * 
 * @author wuxm
 * @date 2017年10月27日 上午11:53:47
 * @see 1.0.0
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
