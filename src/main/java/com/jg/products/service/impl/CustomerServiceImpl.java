package com.jg.products.service.impl;

import com.jg.products.domain.entity.Customer;
import com.jg.products.domain.entity.Product;
import com.jg.products.domain.exception.BaseException;
import com.jg.products.domain.exception.ErrorCode;
import com.jg.products.domain.repository.CustomerRepository;
import com.jg.products.service.CustomerService;
import com.jg.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.jg.products.domain.exception.ErrorCode.CUSTOMER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ProductService productService;

    @Override
    public Customer createCustomer(final String firstName, final String lastName) {
        return customerRepository.save(Customer.builder().firstName(firstName).lastName(lastName).build());
    }

    @Override
    public Customer getCustomerById(final Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new BaseException(CUSTOMER_NOT_FOUND));
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(final Long customerId, final String firstName, final String lastName) {
        final Customer customer = getCustomerById(customerId);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(final Long customerId) {
        customerRepository.delete(getCustomerById(customerId));
    }


    @Override
    public Set<Product> createCustomerProductAssignment(final Long customerId, final Long productId) {
        final Customer customer = getCustomerById(customerId);
        customer.getAssignedProducts().add(productService.getProductById(productId));
        return customerRepository.save(customer).getAssignedProducts();
    }

    @Override
    public Set<Product> getAssignedProducts(final Long customerId) {
        return getCustomerById(customerId).getAssignedProducts();
    }

    @Override
    public Set<Product> deleteCustomerProductAssignment(final Long customerId, final Long productId) {
        final Customer customer = getCustomerById(customerId);
        customer.getAssignedProducts().remove(productService.getProductById(productId));
        return customerRepository.save(customer).getAssignedProducts();
    }
}
