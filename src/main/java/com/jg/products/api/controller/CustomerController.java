package com.jg.products.api.controller;

import com.jg.products.api.dto.customer.ApiCustomer;
import com.jg.products.api.dto.customer.ApiCustomerExtended;
import com.jg.products.api.dto.product.ApiProductExtended;
import com.jg.products.mapper.ModelMapper;
import com.jg.products.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ApiCustomerExtended createCustomer(@RequestBody final ApiCustomer customer) {
        return modelMapper.map(
                customerService.createCustomer(customer.getFirstName(), customer.getLastName()),
                ApiCustomerExtended.class);
    }

    @GetMapping
    public List<ApiCustomerExtended> getAllCustomers() {
        return modelMapper.mapAsList(customerService.getCustomers(), ApiCustomerExtended.class);
    }

    @GetMapping("/{customerId}")
    public ApiCustomer getCustomerById(@PathVariable final Long customerId) {
        return modelMapper.map(customerService.getCustomerById(customerId), ApiCustomer.class);
    }

    @PutMapping("/{customerId}")
    public ApiCustomer updateCustomer(@PathVariable final Long customerId, @RequestBody final ApiCustomer customer) {
        return modelMapper.map(
                customerService.updateCustomer(customerId, customer.getFirstName(), customer.getLastName()),
                ApiCustomer.class);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable final Long customerId) {
        customerService.deleteCustomer(customerId);
    }


    @GetMapping("/{customerId}/products")
    public List<ApiProductExtended> getCustomerAssignedProducts(@PathVariable final Long customerId) {
        return modelMapper.mapAsList(customerService.getAssignedProducts(customerId), ApiProductExtended.class);
    }

    @PutMapping("/{customerId}/products/{productId}")
    public List<ApiProductExtended> assignedProductToCustomer(@PathVariable final Long customerId,
                                                              @PathVariable final Long productId) {
        return modelMapper.mapAsList(customerService.createCustomerProductAssignment(customerId, productId), ApiProductExtended.class);
    }

    @DeleteMapping("/{customerId}/products/{productId}")
    public List<ApiProductExtended> unassignProductFromCustomer(@PathVariable final Long customerId,
                                                                @PathVariable final Long productId) {
        return modelMapper.mapAsList(customerService.deleteCustomerProductAssignment(customerId, productId), ApiProductExtended.class);
    }
}
