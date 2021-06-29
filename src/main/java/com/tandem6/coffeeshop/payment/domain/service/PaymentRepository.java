package com.tandem6.coffeeshop.payment.domain.service;

import com.tandem6.coffeeshop.payment.domain.model.aggregates.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {
    Payment save(Payment payment);
    Optional<Payment> findByCreatePaymentIdCreatePaymentId(String createPaymentId);
    List<Payment> findAll();
}
