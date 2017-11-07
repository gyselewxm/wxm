package com.wxm.base.exception;

/**
 * 
 * <b>Title:</b> 接口开放层异常<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年10月31日 上午11:23:29<br>
 * 
 * @author wuxm
 * @version 1.0.0
 */
public class InterfaceException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -2416190734515025310L;

    public InterfaceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InterfaceException(String message) {
        super(message);
    }

}
