package com.tandem6.coffeeshop.payment.interfaces.rest;

import com.tandem6.coffeeshop.payment.application.internal.commandservices.PaymentCommandService;
import com.tandem6.coffeeshop.payment.application.internal.queryservices.PaymentQueryService;
import com.tandem6.coffeeshop.payment.domain.model.aggregates.CreatePaymentId;
import com.tandem6.coffeeshop.payment.domain.model.aggregates.Payment;
import com.tandem6.coffeeshop.payment.interfaces.rest.dto.CreatePaymentResource;
import com.tandem6.coffeeshop.payment.interfaces.rest.transform.CreatePaymentCommandDTOAssembler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class PaymentRestController {

    private PaymentCommandService paymentCommandService;
    private PaymentQueryService paymentQueryService;

    public PaymentRestController(PaymentCommandService paymentCommandService, PaymentQueryService paymentQueryService) {
        this.paymentCommandService = paymentCommandService;
        this.paymentQueryService = paymentQueryService;
    }

    @PostMapping("/payment")
    public CreatePaymentId createPayment(@Valid @RequestBody CreatePaymentResource createPaymentResource) {
        CreatePaymentId createPaymentId = paymentCommandService.createPayment(
        CreatePaymentCommandDTOAssembler.toCommandFromDTO(createPaymentResource));
        return createPaymentId;
    }

    @GetMapping("/payment")
    public Payment findByCreatePaymentId(@RequestParam String createPaymentId) throws Exception {
        return paymentQueryService.findByCreatePaymentId(createPaymentId);
    }

    @GetMapping("/payments")
    public List<Payment> getAllPayments() {
        return paymentQueryService.findAll();
    }

    @PutMapping("/payment")
    public String updatePayment() {
        return "payments";
    }

    @DeleteMapping("/payment/{paymentId}")
    public String deletePayment(@PathVariable String paymentId) {
        return "payments";
    }
}