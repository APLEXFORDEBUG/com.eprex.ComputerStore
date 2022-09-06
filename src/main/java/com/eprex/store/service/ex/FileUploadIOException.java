package com.eprex.store.service.ex;

/**
 * @ClassName FileEmptyException
 * @Description TODO
 * @Author mi
 * @Date 1/9/2022 下午4:50
 * @Version 1.0
 **/
public class FileUploadIOException extends FileUploadException{
    public FileUploadIOException() {
    }

    public FileUploadIOException(String message) {
        super(message);
    }

    public FileUploadIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadIOException(Throwable cause) {
        super(cause);
    }

    public FileUploadIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
