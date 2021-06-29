package com.tandem6.coffeeshop.payment.interfaces.rest.transform;

import com.tandem6.coffeeshop.payment.domain.model.commands.CreatePaymentCommand;
import com.tandem6.coffeeshop.payment.interfaces.rest.dto.CreatePaymentResource;

public class CreatePaymentCommandDTOAssembler {

    public static CreatePaymentCommand toCommandFromDTO(CreatePaymentResource createPaymentResource) {
        return new CreatePaymentCommand(
            createPaymentResource.getPaymentName()
        );
    }
}
