package com.tandem6.coffeeshop.product.application.internal.commandservices;

import com.tandem6.coffeeshop.product.domain.model.aggregates.CreateProductId;
import com.tandem6.coffeeshop.product.domain.model.commands.CreateProductCommand;
import com.tandem6.coffeeshop.product.domain.model.aggregates.Product;
import com.tandem6.coffeeshop.product.domain.service.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductCommandService {

    private ProductRepository productRepository;

    public ProductCommandService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public CreateProductId createProduct(CreateProductCommand createProductCommand) {
        String random = UUID.randomUUID().toString().toUpperCase();
        createProductCommand.setProductId(random.substring(0, random.indexOf("-")));
        Product product = new Product(createProductCommand);
        productRepository.save(product);
        return new CreateProductId(random);
    }
}
