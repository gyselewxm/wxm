package com.wxm.example.pojo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.wxm.base.pojo.dataobject.BaseUUIDDO;

/**
 * 
 * <b>Title:</b> 简单示例-多个主键<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年11月15日 下午3:28:00<br>
 * 
 * @author wuxm
 * @version 1.0.0
 */
public class ExSimplePks extends BaseUUIDDO {
    /**
     * 变长字符串主键
     */
    @Id
    @GeneratedValue(generator = "UUID")
    private String varcharId;
    /**
     * 整型主键
     */
    @Id
    private Integer integerId;
    /**
     * 备注
     */
    private String remark;

    public String getVarcharId() {
        return varcharId;
    }

    public void setVarcharId(String varcharId) {
        this.varcharId = varcharId;
    }

    public Integer getIntegerId() {
        return integerId;
    }

    public void setIntegerId(Integer integerId) {
        this.integerId = integerId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
