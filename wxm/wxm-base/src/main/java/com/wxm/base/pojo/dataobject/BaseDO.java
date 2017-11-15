package com.wxm.base.pojo.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.OrderBy;

/**
 * 
 * <b>Title:</b> 数据源基类<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年10月30日 上午11:40:24<br>
 * 
 * @author wuxm
 * @version 1.0.0
 */
public class BaseDO extends BaseLogicDO {
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
    /**
     * 更新时间
     */
    @OrderBy("DESC")
    @Column(insertable = false, updatable = false)
    private Date modifiedTime;
    /**
     * 更新人ID
     */
    private String modifiedBy;

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

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
