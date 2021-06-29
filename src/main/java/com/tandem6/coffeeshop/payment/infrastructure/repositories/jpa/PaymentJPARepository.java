package com.tandem6.coffeeshop.payment.infrastructure.repositories.jpa;

import com.tandem6.coffeeshop.payment.domain.model.aggregates.Payment;
import com.tandem6.coffeeshop.payment.domain.service.PaymentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentJPARepository extends PaymentRepository, JpaRepository<Payment, Long> {
    Payment save(Payment payment);
    Optional<Payment> findByCreatePaymentIdCreatePaymentId(String createPaymentId);
    List<Payment> findAll();
}