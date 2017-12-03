package com.wxm.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * <b>Title:</b> 字段SQL <br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年12月3日 下午1:42:52
 * 
 * @author wuxm
 * @version 1.0.0
 */
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ColumnSql {
    /**
     * 获取字段的SQL
     */
    String value();
}
