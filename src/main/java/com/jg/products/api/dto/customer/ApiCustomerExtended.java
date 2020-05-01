package com.jg.products.api.dto.customer;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ApiCustomerExtended extends ApiCustomer {

    private final Long id;

    public ApiCustomerExtended(final Long id, final String firstName, final String lastName) {
        super(firstName, lastName);
        this.id = id;
    }
}
