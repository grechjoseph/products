package com.jg.products.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity object of a Product.
 */
@Data
@Entity
@Builder
@NoArgsConstructor // Default
@AllArgsConstructor // For Builder
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

}
