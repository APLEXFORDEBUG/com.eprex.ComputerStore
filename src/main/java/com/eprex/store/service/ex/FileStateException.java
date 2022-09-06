package com.eprex.store.service.ex;

/**
 * @ClassName FileStateException
 * @Description 文件状态异常 比如已经打开了  先关闭再上传
 * @Author mi
 * @Date 1/9/2022 下午4:50
 * @Version 1.0
 **/
public class FileStateException extends FileUploadException{
    public FileStateException() {
    }

    public FileStateException(String message) {
        super(message);
    }

    public FileStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileStateException(Throwable cause) {
        super(cause);
    }

    public FileStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
