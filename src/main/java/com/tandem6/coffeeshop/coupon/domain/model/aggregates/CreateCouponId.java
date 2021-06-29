package com.tandem6.coffeeshop.coupon.domain.model.aggregates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Getter
public class CreateCouponId {
    @Column(name="create_coupon_id")
    private String createCouponId;
}