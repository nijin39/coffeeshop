package com.tandem6.coffeeshop.product.domain.model.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProductBaseInfo {

    @Column(name = "product_name", unique = true, updatable= true)
    private String productName;
}
