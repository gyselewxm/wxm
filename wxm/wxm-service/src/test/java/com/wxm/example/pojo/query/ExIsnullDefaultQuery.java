package com.wxm.example.pojo.query;

import com.wxm.example.pojo.entity.ExIsnullDefault;

/**
 * 
 * <b>Title:</b> 示例-是否为空-默认[查询条件]<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年11月27日 下午5:21:17<br>
 * 
 * @author wuxm
 * @version 1.0.0
 */
public class ExIsnullDefaultQuery extends ExIsnullDefault {

    /**
     * ID
     */
    private String id;
    /**
     * 变长字符串_非空_默认
     */
    private String varcharNotnullDefault;
    /**
     * 变长字符串_非空_默认（全模糊）
     */
    private String like_varcharNotnullDefault;
    /**
     * 变长字符串_非空_默认（左模糊）
     */
    private String likeL_varcharNotnullDefault;
    /**
     * 变长字符串_非空_默认（右模糊）
     */
    private String likeR_varcharNotnullDefault;
    /**
     * 变长字符串_非空_默认（更新条件）
     */
    private String update_varcharNotnullDefault;

    public ExIsnullDefaultQuery() {
        super();
    }

    public ExIsnullDefaultQuery(String id) {
        super();
        this.id = id;
    }

    public ExIsnullDefaultQuery(String id, String varcharNotnullDefault) {
        super();
        this.id = id;
        this.varcharNotnullDefault = varcharNotnullDefault;
    }

    public ExIsnullDefaultQuery(String id, String varcharNotnullDefault, String like_varcharNotnullDefault) {
        super();
        this.id = id;
        this.varcharNotnullDefault = varcharNotnullDefault;
        this.like_varcharNotnullDefault = like_varcharNotnullDefault;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVarcharNotnullDefault() {
        return varcharNotnullDefault;
    }

    public void setVarcharNotnullDefault(String varcharNotnullDefault) {
        this.varcharNotnullDefault = varcharNotnullDefault;
    }

    public String getLike_varcharNotnullDefault() {
        return like_varcharNotnullDefault;
    }

    public void setLike_varcharNotnullDefault(String like_varcharNotnullDefault) {
        this.like_varcharNotnullDefault = like_varcharNotnullDefault;
    }

    public String getLikeL_varcharNotnullDefault() {
        return likeL_varcharNotnullDefault;
    }

    public void setLikeL_varcharNotnullDefault(String likeL_varcharNotnullDefault) {
        this.likeL_varcharNotnullDefault = likeL_varcharNotnullDefault;
    }

    public String getLikeR_varcharNotnullDefault() {
        return likeR_varcharNotnullDefault;
    }

    public void setLikeR_varcharNotnullDefault(String likeR_varcharNotnullDefault) {
        this.likeR_varcharNotnullDefault = likeR_varcharNotnullDefault;
    }

    public String getUpdate_varcharNotnullDefault() {
        return update_varcharNotnullDefault;
    }

    public void setUpdate_varcharNotnullDefault(String update_varcharNotnullDefault) {
        this.update_varcharNotnullDefault = update_varcharNotnullDefault;
    }
}
