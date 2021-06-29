package com.tandem6.coffeeshop.product.interfaces.rest.dto;

import com.tandem6.coffeeshop.product.interfaces.rest.validation.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductResource {
    @NotBlank(message = "please, Product Name input")
    private String productName;

    @Phone
    private String phone;
}
