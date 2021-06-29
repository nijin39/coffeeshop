package com.tandem6.coffeeshop.payment.application.internal.commandservices;

import com.tandem6.coffeeshop.payment.domain.model.aggregates.CreatePaymentId;
import com.tandem6.coffeeshop.payment.domain.model.commands.CreatePaymentCommand;
import com.tandem6.coffeeshop.payment.domain.model.aggregates.Payment;
import com.tandem6.coffeeshop.payment.domain.service.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentCommandService {

    private PaymentRepository paymentRepository;

    public PaymentCommandService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public CreatePaymentId createPayment(CreatePaymentCommand createPaymentCommand) {
        String random = UUID.randomUUID().toString().toUpperCase();
        createPaymentCommand.setPaymentId(random.substring(0, random.indexOf("-")));
        Payment payment = new Payment(createPaymentCommand);
        paymentRepository.save(payment);
        return new CreatePaymentId(random);
    }
}
