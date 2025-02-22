package com.tools.toolbox.common.response;

import com.tools.toolbox.common.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CommonControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ErrorResponse onException(Exception e) {
        return ErrorResponse.response(ErrorCode.COMMON_SYSTEM_ERROR.getErrorMsg());
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
        return ErrorResponse.response(ErrorCode.COMMON_INVALID_PARAMETER.getErrorMsg());
    }

}
