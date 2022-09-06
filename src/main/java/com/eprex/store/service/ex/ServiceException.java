package com.eprex.store.service.ex;

/**
 * @ClassName ServiceException
 * @Description TODO
 * @Author eprex
 * @Date 29/8/2022 下午2:51
 * @Version 1.0
 **/
//业务层异常的基类  throws new ServiceException("业务层产生未知的异常")
public class ServiceException extends RuntimeException{
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
