package com.tandem6.coffeeshop.coupon.application.internal.commandservices;

import com.tandem6.coffeeshop.coupon.domain.model.aggregates.CreateCouponId;
import com.tandem6.coffeeshop.coupon.domain.model.commands.CreateCouponCommand;
import com.tandem6.coffeeshop.coupon.domain.model.aggregates.Coupon;
import com.tandem6.coffeeshop.coupon.domain.service.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CouponCommandService {

    private CouponRepository couponRepository;

    public CouponCommandService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public CreateCouponId createCoupon(CreateCouponCommand createCouponCommand) {
        String random = UUID.randomUUID().toString().toUpperCase();
        createCouponCommand.setCouponId(random.substring(0, random.indexOf("-")));
        Coupon coupon = new Coupon(createCouponCommand);
        couponRepository.save(coupon);
        return new CreateCouponId(random);
    }
}
