package com.jg.products.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity object of a Customer.
 */
@Data
@Entity
@Builder
@NoArgsConstructor // Default
@AllArgsConstructor // For Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "customer_product_assignment",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> assignedProducts;

}
