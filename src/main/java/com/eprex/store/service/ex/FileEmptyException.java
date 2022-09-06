package com.eprex.store.service.ex;

/**
 * @ClassName FileEmptyException
 * @Description TODO
 * @Author mi
 * @Date 1/9/2022 下午4:50
 * @Version 1.0
 **/
public class FileEmptyException extends FileUploadException{
    public FileEmptyException() {
    }

    public FileEmptyException(String message) {
        super(message);
    }

    public FileEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileEmptyException(Throwable cause) {
        super(cause);
    }

    public FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
