package com.eprex.store.service.ex;

/**
 * @ClassName InsertException
 * @Description TODO
 * @Author mi
 * @Date 29/8/2022 下午3:00
 * @Version 1.0
 **/
// 数据在更新时的异常
public class UpdateException extends ServiceException{
    public UpdateException() {
        super();
    }

    public UpdateException(String message) {
        super(message);
    }

    public UpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateException(Throwable cause) {
        super(cause);
    }

    public UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
