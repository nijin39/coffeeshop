package com.tandem6.coffeeshop.product.interfaces.rest;

import com.tandem6.coffeeshop.product.application.internal.commandservices.ProductCommandService;
import com.tandem6.coffeeshop.product.application.internal.queryservices.ProductQueryService;
import com.tandem6.coffeeshop.product.domain.model.aggregates.CreateProductId;
import com.tandem6.coffeeshop.product.domain.model.aggregates.Product;
import com.tandem6.coffeeshop.product.interfaces.rest.dto.CreateProductResource;
import com.tandem6.coffeeshop.product.interfaces.rest.transform.CreateProductCommandDTOAssembler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class ProductRestController {

    private ProductCommandService productCommandService;
    private ProductQueryService productQueryService;

    public ProductRestController(ProductCommandService productCommandService, ProductQueryService productQueryService) {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;
    }

    @PostMapping("/product")
    public CreateProductId createProduct(@Valid @RequestBody CreateProductResource createProductResource) {
        CreateProductId createProductId = productCommandService.createProduct(
        CreateProductCommandDTOAssembler.toCommandFromDTO(createProductResource));
        return createProductId;
    }

    @GetMapping("/product")
    public Product findByCreateProductId(@RequestParam String createProductId) throws Exception {
        return productQueryService.findByCreateProductId(createProductId);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productQueryService.findAll();
    }

    @PutMapping("/product")
    public String updateProduct() {
        return "products";
    }

    @DeleteMapping("/product/{productId}")
    public String deleteProduct(@PathVariable String productId) {
        return "products";
    }
}