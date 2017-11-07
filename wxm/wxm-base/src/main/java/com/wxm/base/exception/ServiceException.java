package com.wxm.base.exception;

/**
 * 
 * <b>Title:</b> 业务逻辑层异常<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年10月31日 上午11:25:54<br>
 * 
 * @author wuxm
 * @version 1.0.0
 */
public class ServiceException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 5237132785389070088L;

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }

}
