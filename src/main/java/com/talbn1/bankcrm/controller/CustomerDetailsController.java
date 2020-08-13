package com.talbn1.bankcrm.controller;

import com.talbn1.bankcrm.domain.Customer;
import com.talbn1.bankcrm.dtomodel.CustomerDto;
import com.talbn1.bankcrm.repositories.CustomerRepository;
import com.talbn1.bankcrm.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author talbn on 8/5/2020
 **/

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class CustomerDetailsController {

    private final CustomerRepository customerRepository;
    private final CustomerService customerService;


    @GetMapping("customer/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") Long customerId) {
        return new ResponseEntity<>(customerService.getById(customerId), HttpStatus.OK);
    }


    @PostMapping(path = "customer/save")
    public ResponseEntity saveNewCustomer(@RequestBody @Validated CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.saveNewCustomer(customerDto), HttpStatus.CREATED);
    }




}

