package com.tandem6.coffeeshop.product.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateProductCommand {
    private String productId;
    private String productName;
    
    public CreateProductCommand(String productName) {
        this.productName = productName;
    }
}
