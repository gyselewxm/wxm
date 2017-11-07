package com.wxm.mybatis.datasource.lookup;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <b>标题: </b> 动态数据源 <br/>
 * <b>描述: </b> <br/>
 * <b>作者: </b>吴晓敏 15109870670@139.com <br/>
 * <b>时间: </b>2017年6月23日 下午11:24:59 <br/>
 * <b>版本: </b>1.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    // 线程本地环境
    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }

    public static String getDataSourcekey() {
        return dataSourceKey.get();
    }

    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }

    /**
     * 
     * <b>标题: </b> 清除数据源 <br/>
     * <b>描述: </b> <br/>
     * <b>作者: </b>吴晓敏 15109870670@139.com <br/>
     * <b>时间: </b>2017年9月18日 下午2:58:45 <br/>
     * <b>版本: </b>1.0
     * 
     */
    public static void clearDataSource() {
        dataSourceKey.remove();
    }
}
