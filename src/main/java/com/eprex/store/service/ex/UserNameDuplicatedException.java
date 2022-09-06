package com.eprex.store.service.ex;

/**
 * @ClassName UsernameDuplicatedException
 * @Description TODO
 * @Author mi
 * @Date 29/8/2022 下午2:58
 * @Version 1.0
 **/

//用户名被占用时的异常
public class UserNameDuplicatedException extends ServiceException{
    public UserNameDuplicatedException() {
        super();
    }

    public UserNameDuplicatedException(String message) {
        super(message);
    }

    public UserNameDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameDuplicatedException(Throwable cause) {
        super(cause);
    }

    public UserNameDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
