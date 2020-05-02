package com.jg.products.domain.exception;

import lombok.Getter;

public class BaseException extends RuntimeException {

    @Getter
    private final ErrorCode errorCode;

    public BaseException(final ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
