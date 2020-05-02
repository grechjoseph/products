package com.jg.products.api.dto.customer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@ApiModel(value = "An object representing a Customer's basic fields.")
public class ApiCustomer {

    @ApiModelProperty(value = "The Customer's first name.")
    private final String firstName;

    @ApiModelProperty(value = "The Customer's last name.")
    private final String lastName;

}
