package com.jg.products.service;

import com.jg.products.domain.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(final String name);

    Product getProductById(final Long productId);

    List<Product> getProducts();

    Product updateProduct(final Long productId, final String name);

    void deleteProduct(final Long productId);

}
