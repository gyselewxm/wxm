package com.wxm.base.pojo.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.OrderBy;

/**
 * 
 * <b>Title:</b> 数据源更新基类 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2018年2月1日 下午12:00:30 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 */
public class BaseModifyDO extends BaseUUIDDO {
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
