package com.jg.products.service;

import com.jg.products.domain.entity.Customer;
import com.jg.products.domain.entity.Product;

import java.util.List;
import java.util.Set;

public interface CustomerService {

    Customer createCustomer(final String firstName, final String lastName);

    Customer getCustomerById(final Long customerId);

    List<Customer> getCustomers();

    Customer updateCustomer(final Long customerId, final String firstName, final String lastName);

    void deleteCustomer(final Long customerId);


    Set<Product> createCustomerProductAssignment(final Long customerId, final Long productId);

    Set<Product> getAssignedProducts(final Long customerId);

    Set<Product> deleteCustomerProductAssignment(final Long customerId, final Long productId);

}
