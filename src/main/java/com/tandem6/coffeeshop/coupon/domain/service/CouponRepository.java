package com.tandem6.coffeeshop.coupon.domain.service;

import com.tandem6.coffeeshop.coupon.domain.model.aggregates.Coupon;

import java.util.List;
import java.util.Optional;

public interface CouponRepository {
    Coupon save(Coupon coupon);
    Optional<Coupon> findByCreateCouponIdCreateCouponId(String createCouponId);
    List<Coupon> findAll();
}
