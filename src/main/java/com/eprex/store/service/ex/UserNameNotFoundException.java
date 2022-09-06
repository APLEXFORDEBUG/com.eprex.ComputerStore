package com.eprex.store.service.ex;

/**
 * @ClassName UserNameNotFoundException
 * @Description TODO
 * @Author mi
 * @Date 30/8/2022 下午2:50
 * @Version 1.0
 **/
public class UserNameNotFoundException extends ServiceException{
    public UserNameNotFoundException() {
    }

    public UserNameNotFoundException(String message) {
        super(message);
    }

    public UserNameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNameNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
