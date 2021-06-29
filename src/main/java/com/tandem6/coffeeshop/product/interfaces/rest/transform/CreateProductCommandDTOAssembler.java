package com.tandem6.coffeeshop.product.interfaces.rest.transform;

import com.tandem6.coffeeshop.product.domain.model.commands.CreateProductCommand;
import com.tandem6.coffeeshop.product.interfaces.rest.dto.CreateProductResource;

public class CreateProductCommandDTOAssembler {

    public static CreateProductCommand toCommandFromDTO(CreateProductResource createProductResource) {
        return new CreateProductCommand(
            createProductResource.getProductName()
        );
    }
}
