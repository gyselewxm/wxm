package com.wxm.base.exception;
/**
 * 
 * <b>Title:</b> 通用处理层异常<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年10月31日 上午11:24:41<br>
 * @author wuxm
 * @version 1.0.0
 */
public class ManagerException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -2249159859602714829L;

    public ManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManagerException(String message) {
        super(message);
    }

}
