package com.tandem6.coffeeshop.payment.domain.model.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PaymentBaseInfo {

    @Column(name = "payment_name", unique = true, updatable= true)
    private String paymentName;
}
