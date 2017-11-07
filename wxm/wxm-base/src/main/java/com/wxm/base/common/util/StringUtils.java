package com.wxm.base.common.util;

public class StringUtils extends org.springframework.util.StringUtils {
    /**
     * 
     * <b>Title:</b> 非空 <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年11月7日 下午4:25:33 <br>
     * 
     * @author wuxm
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
