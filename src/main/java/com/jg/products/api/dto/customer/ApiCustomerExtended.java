package com.jg.products.api.dto.customer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@ApiModel("An object representing a Customer's fields.")
public class ApiCustomerExtended extends ApiCustomer {

    @ApiModelProperty(value = "The Customer's ID.")
    private final Long id;

    public ApiCustomerExtended(final Long id, final String firstName, final String lastName) {
        super(firstName, lastName);
        this.id = id;
    }
}
