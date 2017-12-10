package com.wxm.mybatis.mapper;

/**
 * @author liuzh
 */
public class MapperException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = -5268272735503759090L;

    public MapperException() {
        super();
    }

    public MapperException(String message) {
        super(message);
    }

    public MapperException(String message, Throwable cause) {
        super(message, cause);
    }

    public MapperException(Throwable cause) {
        super(cause);
    }

}
