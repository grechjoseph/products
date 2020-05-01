package com.jg.products.api.controller;

import com.jg.products.api.dto.product.ApiProduct;
import com.jg.products.api.dto.product.ApiProductExtended;
import com.jg.products.mapper.ModelMapper;
import com.jg.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ApiProductExtended createProduct(@RequestBody final ApiProduct product) {
        return modelMapper.map(productService.createProduct(product.getName()), ApiProductExtended.class);
    }

    @GetMapping
    public List<ApiProductExtended> getProducts() {
        return modelMapper.mapAsList(productService.getProducts(), ApiProductExtended.class);
    }

    @GetMapping("/{productId}")
    public ApiProduct getProductById(@PathVariable final Long productId) {
        return modelMapper.map(productService.getProductById(productId), ApiProduct.class);
    }

    @PutMapping("/{productId}")
    public ApiProduct updateProduct(@PathVariable final Long productId, @RequestBody final ApiProduct product) {
        return modelMapper.map(productService.updateProduct(productId, product.getName()), ApiProduct.class);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable final Long productId) {
        productService.deleteProduct(productId);
    }
}
