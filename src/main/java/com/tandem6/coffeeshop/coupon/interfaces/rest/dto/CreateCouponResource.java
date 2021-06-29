package com.tandem6.coffeeshop.coupon.interfaces.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCouponResource {
    @NotBlank(message = "please, Coupon Name input")
    private String couponName;
}
