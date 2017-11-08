/**
 * 
 */
package com.wxm.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * <b>Title:</b> 字段默认值 <br>
 * <b>Description:</b> 暂时无用<br>
 * <b>Date:</b> 2017年11月7日 下午11:06:15
 * 
 * @author wuxm
 * @version 1.0.0
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ColumnDefault {

    ColumnDefaultEnum value();

    public enum ColumnDefaultEnum {
        CURRENT_DATE, // yyyy-MM-dd
        CURRENT_DATETIME // yyyy-MM-dd hh:mm:ss
    }
}
