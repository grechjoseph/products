package com.jg.products.api.controller;

import com.jg.products.api.dto.product.ApiProduct;
import com.jg.products.api.dto.product.ApiProductExtended;
import com.jg.products.mapper.ModelMapper;
import com.jg.products.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@Api(value = "Products Endpoints.")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Create a new Product.")
    public ApiProductExtended createProduct(@RequestBody final ApiProduct product) {
        return modelMapper.map(productService.createProduct(product.getName()), ApiProductExtended.class);
    }

    @GetMapping
    @ApiOperation(value = "Get Products.")
    public List<ApiProductExtended> getProducts() {
        return modelMapper.mapAsList(productService.getProducts(), ApiProductExtended.class);
    }

    @GetMapping("/{productId}")
    @ApiOperation(value = "Get a Product by ID.")
    public ApiProduct getProductById(@PathVariable final Long productId) {
        return modelMapper.map(productService.getProductById(productId), ApiProduct.class);
    }

    @PutMapping("/{productId}")
    @ApiOperation(value = "Update a Product.")
    public ApiProduct updateProduct(@PathVariable final Long productId, @RequestBody final ApiProduct product) {
        return modelMapper.map(productService.updateProduct(productId, product.getName()), ApiProduct.class);
    }

    @DeleteMapping("/{productId}")
    @ApiOperation(value = "Delete a Product.")
    public void deleteProduct(@PathVariable final Long productId) {
        productService.deleteProduct(productId);
    }
}
