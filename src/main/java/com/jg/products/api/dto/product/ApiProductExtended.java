package com.jg.products.api.dto.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@ApiModel(value = "An object representing a Product's fields.")
public class ApiProductExtended extends ApiProduct {

    @ApiModelProperty(value = "The Product's ID.")
    private final Long id;

    public ApiProductExtended(final Long id, final String name) {
        this.setName(name);
        this.id = id;
    }
}
