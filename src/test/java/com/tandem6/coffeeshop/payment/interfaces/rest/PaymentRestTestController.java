package com.tandem6.coffeeshop.payment.interfaces.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tandem6.coffeeshop.payment.application.internal.commandservices.PaymentCommandService;
import com.tandem6.coffeeshop.payment.application.internal.queryservices.PaymentQueryService;
import com.tandem6.coffeeshop.payment.domain.model.aggregates.CreatePaymentId;
import com.tandem6.coffeeshop.payment.interfaces.rest.dto.CreatePaymentResource;
import com.tandem6.coffeeshop.payment.interfaces.rest.transform.CreatePaymentCommandDTOAssembler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PaymentRestController.class)
class PaymentRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentCommandService paymentCommandService;

    @MockBean
    private PaymentQueryService paymentQueryService;


    @Test
    @Order(1)
    @DisplayName("paymentName number and phone are abnormal")
    void createPayment_AllAbnormal() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
        .post("/payment")
        .content(asJsonString(new CreatePaymentResource(null, "010-9652-4489")))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andExpect(MockMvcResultMatchers.jsonPath("$.phone").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("$.paymentName").exists());
    }

    @Test
    @Order(2)
    @DisplayName("Phone number is abnormal")
    void createPayment_phoneAbnormal() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
        .post("/payment")
        .content(asJsonString(new CreatePaymentResource("mac book", "010-9652-4489")))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andExpect(MockMvcResultMatchers.jsonPath("$.phone").exists());
    }

    @Test
    @Order(3)
    @DisplayName("paymentName is abnormal")
    void createPayment_paymentNameAbnormal() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
        .post("/payment")
        .content(asJsonString(new CreatePaymentResource(null, "01096524489")))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andExpect(MockMvcResultMatchers.jsonPath("$.paymentName").exists());
    }

    @Test
    @Order(4)
    @DisplayName("CreatePaymentResource is normal")
    void createPayment_normal() throws Exception {

        //given
        CreatePaymentResource createPaymentResource = new CreatePaymentResource("mac book", "01096524489");

        when(paymentCommandService.createPayment(CreatePaymentCommandDTOAssembler.toCommandFromDTO(createPaymentResource)))
        .thenReturn(new CreatePaymentId("1"));

        //when&then
        mockMvc.perform( MockMvcRequestBuilders
        .post("/payment")
        .content(asJsonString(new CreatePaymentResource("mac book", "01096524489")))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
    }

    @Test
    @Order(5)
    void findByCreatePaymentId() {
    }

    @Test
    @Order(6)
    void getAllPayments() {
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}