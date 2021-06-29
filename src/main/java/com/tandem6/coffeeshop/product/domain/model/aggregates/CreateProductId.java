package com.tandem6.coffeeshop.product.domain.model.aggregates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Getter
public class CreateProductId {
    @Column(name="create_product_id")
    private String createProductId;
}