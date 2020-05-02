package com.jg.products.api.controller;

import com.jg.products.api.dto.customer.ApiCustomer;
import com.jg.products.api.dto.customer.ApiCustomerExtended;
import com.jg.products.api.dto.product.ApiProductExtended;
import com.jg.products.mapper.ModelMapper;
import com.jg.products.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to manage {@link com.jg.products.domain.entity.Customer} objects and
 * their {@link com.jg.products.domain.entity.Product} assignments.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
@Api(value = "Customers endpoints.")
public class CustomerController {

    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Create a new Customer.")
    public ApiCustomerExtended createCustomer(@RequestBody final ApiCustomer customer) {
        return modelMapper.map(
                customerService.createCustomer(customer.getFirstName(), customer.getLastName()),
                ApiCustomerExtended.class);
    }

    @GetMapping
    @ApiOperation(value = "Get Customers.")
    public List<ApiCustomerExtended> getAllCustomers() {
        return modelMapper.mapAsList(customerService.getCustomers(), ApiCustomerExtended.class);
    }

    @GetMapping("/{customerId}")
    @ApiOperation(value = "Get a Customer by ID.")
    public ApiCustomer getCustomerById(@PathVariable final Long customerId) {
        return modelMapper.map(customerService.getCustomerById(customerId), ApiCustomer.class);
    }

    @PutMapping("/{customerId}")
    @ApiOperation(value = "Update a Customer.")
    public ApiCustomer updateCustomer(@PathVariable final Long customerId, @RequestBody final ApiCustomer customer) {
        return modelMapper.map(
                customerService.updateCustomer(customerId, customer.getFirstName(), customer.getLastName()),
                ApiCustomer.class);
    }

    @DeleteMapping("/{customerId}")
    @ApiOperation(value = "Delete a Customer.")
    public void deleteCustomer(@PathVariable final Long customerId) {
        customerService.deleteCustomer(customerId);
    }


    @GetMapping("/{customerId}/products")
    @ApiOperation(value = "Get a Customer's assigned Products.")
    public List<ApiProductExtended> getCustomerAssignedProducts(@PathVariable final Long customerId) {
        return modelMapper.mapAsList(customerService.getAssignedProducts(customerId), ApiProductExtended.class);
    }

    @PutMapping("/{customerId}/products/{productId}")
    @ApiOperation(value = "Assign a Product to a Customer.")
    public List<ApiProductExtended> assignedProductToCustomer(@PathVariable final Long customerId,
                                                              @PathVariable final Long productId) {
        return modelMapper.mapAsList(customerService.createCustomerProductAssignment(customerId, productId), ApiProductExtended.class);
    }

    @DeleteMapping("/{customerId}/products/{productId}")
    @ApiOperation(value = "Unassign a Product from a Customer.")
    public List<ApiProductExtended> unassignProductFromCustomer(@PathVariable final Long customerId,
                                                                @PathVariable final Long productId) {
        return modelMapper.mapAsList(customerService.deleteCustomerProductAssignment(customerId, productId), ApiProductExtended.class);
    }
}
