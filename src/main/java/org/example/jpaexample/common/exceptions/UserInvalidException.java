package org.example.jpaexample.common.exceptions;

import org.example.jpaexample.common.annotations.ExceptionLog;

@ExceptionLog
public class UserInvalidException extends ParamInvalidException {

    public static final String ERROR_MSG_TEMPLATE = "user: %s is invalid";

    private long userId;

    private static String format(long userId) {
        return String.format(ERROR_MSG_TEMPLATE, userId);
    }

    public UserInvalidException(long userId) {
        super(format(userId), ErrorCodeEnum.INVALID_USER);
    }

    public UserInvalidException(String message, long userId) {
        super(message, format(userId), ErrorCodeEnum.INVALID_USER);
    }

    public UserInvalidException(String message, Throwable cause, long userId) {
        super(message, cause, format(userId), ErrorCodeEnum.INVALID_USER);
    }

    public UserInvalidException(Throwable cause, long userId) {
        super(cause, format(userId), ErrorCodeEnum.INVALID_USER);
    }

    public UserInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
            long userId) {
        super(message, cause, enableSuppression, writableStackTrace, format(userId), ErrorCodeEnum.INVALID_USER);
    }
}
