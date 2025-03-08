package com.tools.toolbox.common.response;

import com.tools.toolbox.common.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@ControllerAdvice
public class CommonControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ErrorResponse onException(Exception e) {
        return ErrorResponse.response(MessageCode.COMMON_SYSTEM_ERROR.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = BaseException.class)
    public ErrorResponse onBaseException(BaseException e) {
        return ErrorResponse.response(e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ErrorResponse methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ErrorResponse.response(MessageCode.COMMON_INVALID_PARAMETER.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {HandlerMethodValidationException.class})
    public ErrorResponse handleValidationException(HandlerMethodValidationException e) {
        return ErrorResponse.response(MessageCode.COMMON_INVALID_PARAMETER.getMessage());
    }

}
