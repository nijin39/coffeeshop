package com.tandem6.coffeeshop.product.domain.model.aggregates;

import com.tandem6.coffeeshop.product.domain.model.commands.CreateProductCommand;
import com.tandem6.coffeeshop.product.domain.model.valueobjects.ProductBaseInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Product extends AbstractAggregateRoot<Product> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private CreateProductId createProductId;

    @Embedded
    private ProductBaseInfo productBaseInfo;

    public Product(CreateProductCommand createProductCommand) {
    this.createProductId = new CreateProductId(createProductCommand.getProductId());
    this.productBaseInfo = new ProductBaseInfo(createProductCommand.getProductName());
    }
}