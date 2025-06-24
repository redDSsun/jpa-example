package org.example.jpaexample.facade.web.advice;

import lombok.extern.slf4j.Slf4j;
import org.example.jpaexample.common.annotations.ExceptionLog;
import org.example.jpaexample.common.exceptions.BaseException;
import org.example.jpaexample.common.exceptions.ErrorCodeEnum;
import org.example.jpaexample.common.exceptions.ResultDTO;
import org.springframework.boot.logging.LogLevel;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_MSG = "Internal Error";

    @ExceptionHandler(Exception.class)
    public ResultDTO exception(Exception exception) {
        if (exception instanceof BaseException) {
            return handleBaseException((BaseException) exception);
        } else {
            return handleOtherException(exception);
        }
    }

    private ResultDTO handleBaseException(BaseException baseException) {
        log(baseException);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setErrorCode(baseException.getErrorCode().getCode());
        resultDTO.setErrorMsg(baseException.getErrorMsg());
        return resultDTO;
    }

    private void log(BaseException baseException) {
        ExceptionLog exceptionLog = BaseException.class.getAnnotation(ExceptionLog.class);
        if (exceptionLog == null) {
            return;
        }
        LogLevel logLevel = exceptionLog.logLevel();
        if (logLevel == LogLevel.OFF) {
            return;
        }

        int errorCode = baseException.getErrorCode().getCode();
        String errorMsg = baseException.getErrorMsg();
        switch (logLevel) {
            case TRACE:
                log.trace("异常跟踪[{}]: {}", errorCode, errorMsg, baseException);
                break;
            case DEBUG:
                log.debug("异常调试[{}]: {}", errorCode, errorMsg, baseException);
                break;
            case INFO:
                log.info("异常信息[{}]: {}", errorCode, errorMsg, baseException);
                break;
            case WARN:
                log.warn("异常警告[{}]: {}", errorCode, errorMsg, baseException);
                break;
            case ERROR:
            default:
                log.error("异常错误[{}]: {}", errorCode, errorMsg, baseException);
                break;
        }
    }

    private ResultDTO handleOtherException(Exception exception) {
        log.error(exception.getMessage(), exception);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setErrorCode(ErrorCodeEnum.DEFAULT_ERROR.getCode());
        resultDTO.setErrorMsg(DEFAULT_ERROR_MSG);

        return resultDTO;
    }

}
