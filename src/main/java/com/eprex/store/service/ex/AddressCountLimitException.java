package com.eprex.store.service.ex;

/**
 * @ClassName AddressCountLimitException
 * @Description 收货地址超出20条
 * @Author mi
 * @Date 30/8/2022 下午2:50
 * @Version 1.0
 **/
public class AddressCountLimitException extends ServiceException{
    public AddressCountLimitException() {
    }

    public AddressCountLimitException(String message) {
        super(message);
    }

    public AddressCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressCountLimitException(Throwable cause) {
        super(cause);
    }

    public AddressCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
