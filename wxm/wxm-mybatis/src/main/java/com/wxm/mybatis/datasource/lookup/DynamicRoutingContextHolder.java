package com.wxm.mybatis.datasource.lookup;

import org.springframework.util.Assert;

import com.wxm.mybatis.datasource.code.RoutingStrategy;

/**
 * 
 * <b>Title:</b> 动态数据源设置
 * <br><b>Description:</b> 
 * <br><b>Date:</b> 2017年12月10日 下午6:12:38
 * <br><b>Author:</b> Gysele
 * <br><b>Version:</b> 1.0.0
 */
public class DynamicRoutingContextHolder {
    private static final ThreadLocal<RoutingStrategy> contextHolder = new ThreadLocal<>();

    public static void setRouteStrategy(RoutingStrategy routingStrategy) {
        Assert.notNull(routingStrategy, "routingStrategy cannot be null");
        contextHolder.set(routingStrategy);
    }

    public static RoutingStrategy getRouteStrategy() {
        return (RoutingStrategy) contextHolder.get();
    }

    public static void clearRouteStrategy() {
        contextHolder.remove();
    }
}
