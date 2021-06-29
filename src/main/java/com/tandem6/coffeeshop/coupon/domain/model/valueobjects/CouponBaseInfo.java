package com.tandem6.coffeeshop.coupon.domain.model.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CouponBaseInfo {

    @Column(name = "coupon_name", unique = true, updatable= true)
    private String couponName;
}
