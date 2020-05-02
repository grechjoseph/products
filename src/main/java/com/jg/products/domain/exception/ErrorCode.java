package com.jg.products.domain.exception;

/**
 * Error code to be added to {@link BaseException} when thrown.
 */
public enum ErrorCode {

    CUSTOMER_NOT_FOUND,
    PRODUCT_NOT_FOUND,
    CUSTOMER_PRODUCT_ASSIGNMENT_NOT_FOUND,
    CUSTOMER_PRODUCT_ASSIGNMENT_ALREADY_EXISTS

}
