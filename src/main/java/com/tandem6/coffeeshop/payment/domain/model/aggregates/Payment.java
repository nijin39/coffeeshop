package com.tandem6.coffeeshop.payment.domain.model.aggregates;

import com.tandem6.coffeeshop.payment.domain.model.commands.CreatePaymentCommand;
import com.tandem6.coffeeshop.payment.domain.model.valueobjects.PaymentBaseInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Payment extends AbstractAggregateRoot<Payment> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private CreatePaymentId createPaymentId;

    @Embedded
    private PaymentBaseInfo paymentBaseInfo;

    public Payment(CreatePaymentCommand createPaymentCommand) {
    this.createPaymentId = new CreatePaymentId(createPaymentCommand.getPaymentId());
    this.paymentBaseInfo = new PaymentBaseInfo(createPaymentCommand.getPaymentName());
    }
}