package com.wxm.mybatis.example.pojo.bo;

import com.wxm.base.annotation.ColumnSql;
import com.wxm.mybatis.example.pojo.entity.ExSimplePkChar;

/**
 * <b>Title:</b> 简单示例-单个主键-定长字符串[业务对象] <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月4日 上午9:42:39 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 */
public class ExSimplePkCharBO extends ExSimplePkChar {

    @ColumnSql("SELECT COUNT(1) FROM #TABLE#")
    private String totalCount;

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
}
