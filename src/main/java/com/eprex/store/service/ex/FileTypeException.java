package com.eprex.store.service.ex;

/**
 * @ClassName FileEmptyException
 * @Description TODO
 * @Author mi
 * @Date 1/9/2022 下午4:50
 * @Version 1.0
 **/
public class FileTypeException extends FileUploadException{
    public FileTypeException() {
    }

    public FileTypeException(String message) {
        super(message);
    }

    public FileTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTypeException(Throwable cause) {
        super(cause);
    }

    public FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
