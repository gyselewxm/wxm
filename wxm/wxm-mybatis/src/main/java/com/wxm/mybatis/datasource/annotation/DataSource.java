package com.wxm.mybatis.datasource.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <b>标题: </b> 数据库源 <br/>
 * <b>描述: </b> <br/>
 * <b>作者: </b>吴晓敏 15109870670@139.com <br/>
 * <b>时间: </b>2017年6月23日 下午11:18:18 <br/>
 * <b>版本: </b>1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataSource {
    public DataSourceType value() default DataSourceType.slave;

    public enum DataSourceType {
        master, slave;
    }
}
