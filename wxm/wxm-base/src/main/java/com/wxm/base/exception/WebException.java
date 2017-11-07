package com.wxm.base.exception;

/**
 * 
 * <b>Title:</b> 请求处理层异常<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年10月31日 上午11:29:08<br>
 * 
 * @author wuxm
 * @version 1.0.0
 */
public class WebException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 5344908443818205999L;

    public WebException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebException(String message) {
        super(message);
    }

}
