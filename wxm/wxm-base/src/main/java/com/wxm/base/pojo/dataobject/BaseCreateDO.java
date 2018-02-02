package com.wxm.base.pojo.dataobject;

import java.util.Date;

import javax.persistence.Column;

/**
 * 
 * <b>Title:</b> 数据源创建基类 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2018年2月1日 上午11:59:34 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 */
public class BaseCreateDO extends BaseUUIDDO {
    /**
     * 创建时间
     */
    @Column(insertable = false, updatable = false)
    private Date createdTime;
    /**
     * 创建人ID
     */
    @Column(updatable = false)
    private String createdBy;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
