package com.wxm.mybatis.example.pojo.bo;

import com.wxm.base.annotation.ColumnSql;
import com.wxm.mybatis.example.pojo.entity.ExIsnullDefault;

/**
 * 
 * <b>Title:</b> 示例-是否为空-默认[业务对象] <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月3日 下午3:53:06 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 */
public class ExIsnullDefaultBO extends ExIsnullDefault {

    @ColumnSql("SELECT COUNT(1) FROM #TABLE#")
    private String totalCount;

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

}
