package com.tandem6.coffeeshop.coupon.interfaces.rest.transform;

import com.tandem6.coffeeshop.coupon.domain.model.commands.CreateCouponCommand;
import com.tandem6.coffeeshop.coupon.interfaces.rest.dto.CreateCouponResource;

public class CreateCouponCommandDTOAssembler {

    public static CreateCouponCommand toCommandFromDTO(CreateCouponResource createCouponResource) {
        return new CreateCouponCommand(
            createCouponResource.getCouponName()
        );
    }
}
