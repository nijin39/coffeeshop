package com.tandem6.coffeeshop.product.domain.service;

import com.tandem6.coffeeshop.product.domain.model.aggregates.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findByCreateProductIdCreateProductId(String createProductId);
    List<Product> findAll();
}
