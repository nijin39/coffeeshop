package com.tandem6.coffeeshop.payment.application.internal.queryservices;

import com.tandem6.coffeeshop.payment.domain.model.aggregates.Payment;
import com.tandem6.coffeeshop.payment.domain.service.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentQueryService {

    private PaymentRepository paymentRepository;
    
    public PaymentQueryService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    
    public Payment findByCreatePaymentId(String createPaymentId) throws Exception {
        Optional<Payment> payment = paymentRepository.findByCreatePaymentIdCreatePaymentId(createPaymentId);
        if(!payment.isEmpty()) {
            return payment.get();
        } else {
            throw new Exception("Payment is not exist!!");
        }
    }
    
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }
}
