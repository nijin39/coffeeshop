package com.tandem6.coffeeshop.payment.domain.model.aggregates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Getter
public class CreatePaymentId {
    @Column(name="create_payment_id")
    private String createPaymentId;
}