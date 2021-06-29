package com.tandem6.coffeeshop.coupon.application.internal.queryservices;

import com.tandem6.coffeeshop.coupon.domain.model.aggregates.Coupon;
import com.tandem6.coffeeshop.coupon.domain.service.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponQueryService {

    private CouponRepository couponRepository;
    
    public CouponQueryService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }
    
    public Coupon findByCreateCouponId(String createCouponId) throws Exception {
        Optional<Coupon> coupon = couponRepository.findByCreateCouponIdCreateCouponId(createCouponId);
        if(!coupon.isEmpty()) {
            return coupon.get();
        } else {
            throw new Exception("Coupon is not exist!!");
        }
    }
    
    public List<Coupon> findAll() {
        return couponRepository.findAll();
    }
}
