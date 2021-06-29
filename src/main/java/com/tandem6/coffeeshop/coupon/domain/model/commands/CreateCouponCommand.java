package com.tandem6.coffeeshop.coupon.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCouponCommand {
    private String couponId;
    private String couponName;
    
    public CreateCouponCommand(String couponName) {
        this.couponName = couponName;
    }
}
