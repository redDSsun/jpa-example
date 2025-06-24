package org.example.jpaexample.common.exceptions;

import org.example.jpaexample.common.annotations.ExceptionLog;
import org.springframework.http.HttpStatus;

@ExceptionLog
public class ParamInvalidException extends BaseException {

    public static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

    public ParamInvalidException(String errorMsg, ErrorCodeEnum errorCode) {
        super(STATUS, errorMsg, errorCode);
    }

    public ParamInvalidException(String message, String errorMsg, ErrorCodeEnum errorCode) {
        super(message, STATUS, errorMsg, errorCode);
    }

    public ParamInvalidException(String message, Throwable cause, String errorMsg,
            ErrorCodeEnum errorCode) {
        super(message, cause, STATUS, errorMsg, errorCode);
    }

    public ParamInvalidException(Throwable cause, String errorMsg, ErrorCodeEnum errorCode) {
        super(cause, STATUS, errorMsg, errorCode);
    }

    public ParamInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
            String errorMsg, ErrorCodeEnum errorCode) {
        super(message, cause, enableSuppression, writableStackTrace, STATUS, errorMsg, errorCode);
    }

}
