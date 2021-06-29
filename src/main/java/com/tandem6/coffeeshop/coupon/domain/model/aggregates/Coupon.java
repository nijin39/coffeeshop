package com.tandem6.coffeeshop.coupon.domain.model.aggregates;

import com.tandem6.coffeeshop.coupon.domain.model.commands.CreateCouponCommand;
import com.tandem6.coffeeshop.coupon.domain.model.valueobjects.CouponBaseInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Coupon extends AbstractAggregateRoot<Coupon> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private CreateCouponId createCouponId;

    @Embedded
    private CouponBaseInfo couponBaseInfo;

    public Coupon(CreateCouponCommand createCouponCommand) {
    this.createCouponId = new CreateCouponId(createCouponCommand.getCouponId());
    this.couponBaseInfo = new CouponBaseInfo(createCouponCommand.getCouponName());
    }
}