package com.jg.products.api.dto.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "An object representing a Product's basic fields.")
public class ApiProduct {

    @ApiModelProperty(value = "The Product's name.")
    private String name;

}
