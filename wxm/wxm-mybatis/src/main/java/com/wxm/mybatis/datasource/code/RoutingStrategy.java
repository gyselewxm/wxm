package com.wxm.mybatis.datasource.code;

/**
 * 
 * <b>Title:</b> 路由策略
 * <br><b>Description:</b> 
 * <br><b>Date:</b> 2017年12月10日 下午6:11:59
 * <br><b>Author:</b> Gysele
 * <br><b>Version:</b> 1.0.0
 */
public enum RoutingStrategy {
    MASTER("master"), SLAVE("slave");

    private String value;

    RoutingStrategy(String value) {
        this.value = value;
    }

    public String getKey() {
        return value;
    }
}
