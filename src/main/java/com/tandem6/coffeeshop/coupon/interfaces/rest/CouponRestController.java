package com.tandem6.coffeeshop.coupon.interfaces.rest;

import com.tandem6.coffeeshop.coupon.application.internal.commandservices.CouponCommandService;
import com.tandem6.coffeeshop.coupon.application.internal.queryservices.CouponQueryService;
import com.tandem6.coffeeshop.coupon.domain.model.aggregates.CreateCouponId;
import com.tandem6.coffeeshop.coupon.domain.model.aggregates.Coupon;
import com.tandem6.coffeeshop.coupon.interfaces.rest.dto.CreateCouponResource;
import com.tandem6.coffeeshop.coupon.interfaces.rest.transform.CreateCouponCommandDTOAssembler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class CouponRestController {

    private CouponCommandService couponCommandService;
    private CouponQueryService couponQueryService;

    public CouponRestController(CouponCommandService couponCommandService, CouponQueryService couponQueryService) {
        this.couponCommandService = couponCommandService;
        this.couponQueryService = couponQueryService;
    }

    @PostMapping("/coupon")
    public CreateCouponId createCoupon(@Valid @RequestBody CreateCouponResource createCouponResource) {
        CreateCouponId createCouponId = couponCommandService.createCoupon(
        CreateCouponCommandDTOAssembler.toCommandFromDTO(createCouponResource));
        return createCouponId;
    }

    @GetMapping("/coupon")
    public Coupon findByCreateCouponId(@RequestParam String createCouponId) throws Exception {
        return couponQueryService.findByCreateCouponId(createCouponId);
    }

    @GetMapping("/coupons")
    public List<Coupon> getAllCoupons() {
        return couponQueryService.findAll();
    }

    @PutMapping("/coupon")
    public String updateCoupon() {
        return "coupons";
    }

    @DeleteMapping("/coupon/{couponId}")
    public String deleteCoupon(@PathVariable String couponId) {
        return "coupons";
    }
}