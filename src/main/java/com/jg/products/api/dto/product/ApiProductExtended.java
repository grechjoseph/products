package com.jg.products.api.dto.product;

import lombok.Getter;

@Getter
public class ApiProductExtended extends ApiProduct {

    private final Long id;

    public ApiProductExtended(final Long id, final String name) {
        this.setName(name);
        this.id = id;
    }
}
