package com.wxm.base.exception;

/**
 * 
 * <b>Title:</b> 数据持久层异常<br>
 * <b>Description:</b> <br>
 * <b>Date:</b> 2017年10月31日 上午11:20:41<br>
 * @author wuxm
 * @version 1.0.0
 */
public class DaoException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -5431369120342075394L;

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(String message) {
        super(message);
    }

}
