package com.tools.toolbox.common.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }
}