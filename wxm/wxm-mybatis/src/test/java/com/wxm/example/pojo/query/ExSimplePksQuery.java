package com.wxm.example.pojo.query;

import com.wxm.example.pojo.entity.ExSimplePks;

/**
 * 
 * <b>Title:</b> 简单示例-多个主键[查询条件] <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月3日 下午8:10:26 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 */
public class ExSimplePksQuery extends ExSimplePks {
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

    public ExSimplePksQuery() {
        super();
    }

    public ExSimplePksQuery(String like_remark, String likeL_remark, String likeR_remark) {
        super();
        this.like_remark = like_remark;
        this.likeL_remark = likeL_remark;
        this.likeR_remark = likeR_remark;
    }

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
