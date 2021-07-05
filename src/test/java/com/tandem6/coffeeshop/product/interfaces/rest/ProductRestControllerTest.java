package com.tandem6.coffeeshop.product.interfaces.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tandem6.coffeeshop.product.application.internal.commandservices.ProductCommandService;
import com.tandem6.coffeeshop.product.application.internal.queryservices.ProductQueryService;
import com.tandem6.coffeeshop.product.domain.model.aggregates.CreateProductId;
import com.tandem6.coffeeshop.product.interfaces.rest.dto.CreateProductResource;
import com.tandem6.coffeeshop.product.interfaces.rest.transform.CreateProductCommandDTOAssembler;
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

@WebMvcTest(ProductRestController.class)
class ProductRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductCommandService productCommandService;

    @MockBean
    private ProductQueryService productQueryService;


    @Test
    @Order(1)
    @DisplayName("productName number and phone are abnormal")
    void createProduct_AllAbnormal() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/product")
                .content(asJsonString(new CreateProductResource(null, "010-9652-4489")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").exists());
    }

    @Test
    @Order(2)
    @DisplayName("Phone number is abnormal")
    void createProduct_phoneAbnormal() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/product")
                .content(asJsonString(new CreateProductResource("mac book", "010-9652-4489")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").exists());
    }

    @Test
    @Order(3)
    @DisplayName("productName is abnormal")
    void createProduct_productNameAbnormal() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/product")
                .content(asJsonString(new CreateProductResource(null, "01096524489")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").exists());
    }

    @Test
    @Order(4)
    @DisplayName("CreateProductResource is normal")
    void createProduct_normal() throws Exception {

        //given
        CreateProductResource createProductResource = new CreateProductResource("mac book", "01096524489");

        when(productCommandService.createProduct(CreateProductCommandDTOAssembler.toCommandFromDTO(createProductResource)))
                .thenReturn(new CreateProductId("1"));

        //when&then
        mockMvc.perform( MockMvcRequestBuilders
                .post("/product")
                .content(asJsonString(new CreateProductResource("mac book", "01096524489")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @Order(5)
    void findByCreateProductId() {
    }

    @Test
    @Order(6)
    void getAllProducts() {
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