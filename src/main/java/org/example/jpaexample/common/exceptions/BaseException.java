package org.example.jpaexample.common.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.jpaexample.common.annotations.ExceptionLog;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = false)
@Data
@ExceptionLog
public class BaseException extends RuntimeException {

    private HttpStatus status;
    private ErrorCodeEnum errorCode;
    private String errorMsg;

    public BaseException(HttpStatus status, String errorMsg, ErrorCodeEnum errorCode) {
        this.status = status;
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public BaseException(String message, HttpStatus status, String errorMsg, ErrorCodeEnum errorCode) {
        super(message);
        this.status = status;
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public BaseException(String message, Throwable cause, HttpStatus status, String errorMsg, ErrorCodeEnum errorCode) {
        super(message, cause);
        this.status = status;
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public BaseException(Throwable cause, HttpStatus status, String errorMsg, ErrorCodeEnum errorCode) {
        super(cause);
        this.status = status;
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
            HttpStatus status, String errorMsg, ErrorCodeEnum errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = status;
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }
}
