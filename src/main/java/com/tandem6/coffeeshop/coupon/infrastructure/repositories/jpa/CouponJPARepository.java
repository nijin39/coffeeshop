package com.tandem6.coffeeshop.coupon.infrastructure.repositories.jpa;

import com.tandem6.coffeeshop.coupon.domain.model.aggregates.Coupon;
import com.tandem6.coffeeshop.coupon.domain.service.CouponRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CouponJPARepository extends CouponRepository, JpaRepository<Coupon, Long> {
    Coupon save(Coupon coupon);
    Optional<Coupon> findByCreateCouponIdCreateCouponId(String createCouponId);
    List<Coupon> findAll();
}