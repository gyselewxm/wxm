package com.wxm.mybatis.datasource.lookup;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 
 * <b>Title:</b> 动态数据源切换
 * <br><b>Description:</b> 
 * <br><b>Date:</b> 2017年12月10日 下午6:12:51
 * <br><b>Author:</b> Gysele
 * <br><b>Version:</b> 1.0.0
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicRoutingContextHolder.getRouteStrategy().getKey();
    }
}
