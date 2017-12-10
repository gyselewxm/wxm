package com.wxm.mybatis.mapper.util;

import java.util.UUID;

/**
 * 
 * <b>Title:</b> UUID工具类<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年11月15日 下午2:09:46<br>
 * 
 * @author wuxm
 * @version 1.0.0
 */
public class UUIDUtil {
    /**
     * 
     * <b>Title:</b> 获取UUID <br>
     * <b>Description:</b> <br>
     * <b>Date:</b> 2017年11月15日 下午2:10:27 <br>
     * 
     * @author wuxm
     * 
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
