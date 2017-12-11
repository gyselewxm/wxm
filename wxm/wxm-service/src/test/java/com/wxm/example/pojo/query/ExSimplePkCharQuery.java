package com.wxm.example.pojo.query;

import com.wxm.example.pojo.entity.ExSimplePkChar;

/**
 * <b>Title:</b> 简单示例-单个主键-定长字符串[查询条件] <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月4日 上午9:43:30 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 */
public class ExSimplePkCharQuery extends ExSimplePkChar {

    /**
     * 备注-全模糊
     */
    private String like_remark;
    /**
     * 备注-左模糊
     */
    private String likeL_remark;
    /**
     * 备注-右模糊
     */
    private String likeR_remark;

    public String getLike_remark() {
        return like_remark;
    }

    public void setLike_remark(String like_remark) {
        this.like_remark = like_remark;
    }

    public String getLikeL_remark() {
        return likeL_remark;
    }

    public void setLikeL_remark(String likeL_remark) {
        this.likeL_remark = likeL_remark;
    }

    public String getLikeR_remark() {
        return likeR_remark;
    }

    public void setLikeR_remark(String likeR_remark) {
        this.likeR_remark = likeR_remark;
    }
}
