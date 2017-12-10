package com.wxm.mybatis.datasource.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.wxm.mybatis.datasource.code.RoutingStrategy;

/**
 * 
 * <b>Title:</b> 数据库源 <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月10日 下午6:11:39 <br>
 * <b>Author:</b> Gysele <br>
 * <b>Version:</b> 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataSource {
    public RoutingStrategy value() default RoutingStrategy.SLAVE;
}
