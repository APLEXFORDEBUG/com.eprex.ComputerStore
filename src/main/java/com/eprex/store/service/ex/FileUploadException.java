package com.eprex.store.service.ex;

/**
 * @ClassName FileUploadException
 * @Description TODO
 * @Author mi
 * @Date 1/9/2022 下午4:49
 * @Version 1.0
 **/
public class FileUploadException extends RuntimeException{
    public FileUploadException() {
    }

    public FileUploadException(String message) {
        super(message);
    }

    public FileUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadException(Throwable cause) {
        super(cause);
    }

    public FileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
