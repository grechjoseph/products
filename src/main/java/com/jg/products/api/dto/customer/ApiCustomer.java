package com.jg.products.api.dto.customer;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ApiCustomer {

    private final String firstName;
    private final String lastName;

}
