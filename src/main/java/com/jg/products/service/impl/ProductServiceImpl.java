package com.jg.products.service.impl;

import com.jg.products.domain.entity.Product;
import com.jg.products.domain.exception.BaseException;
import com.jg.products.domain.repository.ProductRepository;
import com.jg.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jg.products.domain.exception.ErrorCode.PRODUCT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public Product createProduct(final String name) {
        return productRepository.save(Product.builder().name(name).build());
    }

    @Override
    public Product getProductById(final Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new BaseException(PRODUCT_NOT_FOUND));
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(final Long productId, final String name) {
        final Product product = getProductById(productId);
        product.setName(name);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(final Long productId) {
        productRepository.delete(getProductById(productId));
    }
}
