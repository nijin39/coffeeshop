package com.tandem6.coffeeshop.payment.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePaymentCommand {
    private String paymentId;
    private String paymentName;
    
    public CreatePaymentCommand(String paymentName) {
        this.paymentName = paymentName;
    }
}
