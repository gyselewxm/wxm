package com.wxm.mybatis.mapper.weekend.reflection;

public class ReflectionOperationException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 7379432129381221853L;

    public ReflectionOperationException() {
    }

    public ReflectionOperationException(String message) {
        super(message);
    }

    public ReflectionOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReflectionOperationException(Throwable cause) {
        super(cause);
    }

    public ReflectionOperationException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}