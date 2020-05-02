package com.jg.products.domain.exception;

import lombok.Getter;

/**
 * Custom Exception extending {@link RuntimeException}, that also take in a {@link ErrorCode} of the error that occurs.
 */
public class BaseException extends RuntimeException {

    @Getter
    private final ErrorCode errorCode;

    public BaseException(final ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
