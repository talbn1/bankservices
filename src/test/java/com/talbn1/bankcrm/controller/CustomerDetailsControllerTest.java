package com.talbn1.bankcrm.controller;

import com.talbn1.bankcrm.dtomodel.CustomerDto;
import com.talbn1.bankcrm.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CustomerDetailsController.class)
class CustomerDetailsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService customerService;



    @BeforeEach
    void setUp() {
    }

    @Test
    void getCustomerById() throws Exception {
        given(customerService.getById(any())).willReturn(getValidCustomerDto());
        mockMvc.perform(get("/api/customer/1")).andExpect(status().isOk());
    }

    @Test
    void saveNewCustomer() {
    }

    @Test
    void getAll() {
    }

    @Test
    void saveAll() {
    }

    @Test
    void updateCustomer() {
    }

    CustomerDto getValidCustomerDto(){
        return CustomerDto.builder()
                .firstName("TestName")
                .lastName("testLastName")
                .build();
    }
}