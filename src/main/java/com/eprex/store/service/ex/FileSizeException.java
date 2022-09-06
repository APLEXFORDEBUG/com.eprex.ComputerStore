package com.eprex.store.service.ex;

/**
 * @ClassName FileEmptyException
 * @Description TODO
 * @Author mi
 * @Date 1/9/2022 下午4:50
 * @Version 1.0
 **/
public class FileSizeException extends FileUploadException{
    public FileSizeException() {
    }

    public FileSizeException(String message) {
        super(message);
    }

    public FileSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSizeException(Throwable cause) {
        super(cause);
    }

    public FileSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
