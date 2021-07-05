package com.tandem6.coffeeshop.payment.interfaces.rest.dto;

import com.tandem6.coffeeshop.payment.interfaces.rest.validation.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentResource {
    @NotBlank(message = "please, Payment Name input")
    private String paymentName;

    @Phone
    private String phone;
}
