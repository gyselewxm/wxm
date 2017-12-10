package com.wxm.mybatis.example.pojo.entity;

import javax.persistence.Column;

import com.wxm.base.pojo.dataobject.BaseUUIDDO;

/**
 * 
 * <b>Title:</b> 示例-是否为空-默认 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年11月28日 下午2:48:26 <br>
 * <b>Author:</b> Gysele
 * 
 * @version 1.0.0
 */
public class ExIsnullDefault extends BaseUUIDDO {
    /**
     * 变长字符串_非空
     */
    private String varcharNotnull;
    /**
     * 变长字符串_非空_默认
     */
    private String varcharNotnullDefault;
    /**
     * 变长字符串_可空
     */
    private String varcharCannull;
    /**
     * 变长字符串_可空_默认
     */
    private String varcharCannullDefault;
    /**
     * 定长字符串_非空
     */
    private String charNotnull;
    /**
     * 定长字符串_非空_默认
     */
    private String charNotnullDefault;
    /**
     * 定长字符串_可空
     */
    private String charCannull;
    /**
     * 定长字符串_可空_默认
     */
    private String charCannullDefault;
    /**
     * 变长字符串_非插入_可空
     */
    @Column(insertable = false)
    private String varcharNotinsertCannull;
    /**
     * 变长字符串_非插入_可空_默认
     */
    @Column(insertable = false)
    private String varcharNotinsertCannullDefault;
    /**
     * 变长字符串_非插入_非空
     */
    // @Column(insertable = false)
    private String varcharNotinsertNotnull;
    /**
     * 变长字符串_非插入_可空_默认
     */
    @Column(insertable = false)
    private String varcharNotinsertNotnullDefault;

    public String getVarcharNotnull() {
        return varcharNotnull;
    }

    public void setVarcharNotnull(String varcharNotnull) {
        this.varcharNotnull = varcharNotnull;
    }

    public String getVarcharNotnullDefault() {
        return varcharNotnullDefault;
    }

    public void setVarcharNotnullDefault(String varcharNotnullDefault) {
        this.varcharNotnullDefault = varcharNotnullDefault;
    }

    public String getVarcharCannull() {
        return varcharCannull;
    }

    public void setVarcharCannull(String varcharCannull) {
        this.varcharCannull = varcharCannull;
    }

    public String getVarcharCannullDefault() {
        return varcharCannullDefault;
    }

    public void setVarcharCannullDefault(String varcharCannullDefault) {
        this.varcharCannullDefault = varcharCannullDefault;
    }

    public String getCharNotnull() {
        return charNotnull;
    }

    public void setCharNotnull(String charNotnull) {
        this.charNotnull = charNotnull;
    }

    public String getCharNotnullDefault() {
        return charNotnullDefault;
    }

    public void setCharNotnullDefault(String charNotnullDefault) {
        this.charNotnullDefault = charNotnullDefault;
    }

    public String getCharCannull() {
        return charCannull;
    }

    public void setCharCannull(String charCannull) {
        this.charCannull = charCannull;
    }

    public String getCharCannullDefault() {
        return charCannullDefault;
    }

    public void setCharCannullDefault(String charCannullDefault) {
        this.charCannullDefault = charCannullDefault;
    }

    public String getVarcharNotinsertCannull() {
        return varcharNotinsertCannull;
    }

    public void setVarcharNotinsertCannull(String varcharNotinsertCannull) {
        this.varcharNotinsertCannull = varcharNotinsertCannull;
    }

    public String getVarcharNotinsertCannullDefault() {
        return varcharNotinsertCannullDefault;
    }

    public void setVarcharNotinsertCannullDefault(String varcharNotinsertCannullDefault) {
        this.varcharNotinsertCannullDefault = varcharNotinsertCannullDefault;
    }

    public String getVarcharNotinsertNotnull() {
        return varcharNotinsertNotnull;
    }

    public void setVarcharNotinsertNotnull(String varcharNotinsertNotnull) {
        this.varcharNotinsertNotnull = varcharNotinsertNotnull;
    }

    public String getVarcharNotinsertNotnullDefault() {
        return varcharNotinsertNotnullDefault;
    }

    public void setVarcharNotinsertNotnullDefault(String varcharNotinsertNotnullDefault) {
        this.varcharNotinsertNotnullDefault = varcharNotinsertNotnullDefault;
    }
}