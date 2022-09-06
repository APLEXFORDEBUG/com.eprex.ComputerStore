package com.eprex.store.service.ex;

/**
 * @ClassName PasswordNotMatchException
 * @Description TODO
 * @Author mi
 * @Date 30/8/2022 下午2:47
 * @Version 1.0
 **/
public class PasswordNotMatchException extends ServiceException{
    public PasswordNotMatchException() {
    }

    public PasswordNotMatchException(String message) {
        super(message);
    }

    public PasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotMatchException(Throwable cause) {
        super(cause);
    }

    public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
