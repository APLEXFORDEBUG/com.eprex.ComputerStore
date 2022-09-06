package com.eprex.store.service.ex;

/**
 * @ClassName InsertException
 * @Description TODO
 * @Author mi
 * @Date 29/8/2022 下午3:00
 * @Version 1.0
 **/
// 数据正在执行插入的时候的异常 比如服务器宕机 啥的
public class InsertException extends ServiceException{
    public InsertException() {
        super();
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    public InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
