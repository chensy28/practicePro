package com.csy.util;

/**
 * Created by csypc on 2015/10/17.
 */
public class BizException extends Exception {

    public BizException(String message){
        super(message);
    }

    public BizException(String message, Throwable cause){
        super(message,cause);
    }
}
