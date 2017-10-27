package com.wxm.base.pojo.dataobject;

import java.util.Date;

import javax.persistence.Column;

/**
 * 数据源基类
 * 
 * @author wuxm
 * @date 2017年10月27日 下午1:22:40
 * @see 1.0.0
 */
public class BaseDO extends BaseLogicDO {
    /**
     * 创建时间
     */
    @Column
    private Date createdTime;
    /**
     * 创建人ID
     */
    @Column
    private String createdBy;
    /**
     * 更新时间
     */
    @Column
    private Date modifiedTime;
    /**
     * 更新人ID
     */
    @Column
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