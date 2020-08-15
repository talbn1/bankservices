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

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author talbn on 8/5/2020
 **/

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class CustomerDetailsController {

    private final CustomerService customerService;

    @GetMapping("customer/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") Long customerId) {
        return new ResponseEntity<>(customerService.getById(customerId), HttpStatus.OK);
    }

    @PostMapping(path = "customer/save")
    public ResponseEntity<CustomerDto> saveNewCustomer(@RequestBody @Validated CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.saveNewCustomer(customerDto), HttpStatus.CREATED);
    }

    @GetMapping("customer/getAll")
    public ResponseEntity<List<CustomerDto>> getAll() {
        List<CustomerDto> CustomerDto = customerService.getAll();
        return new ResponseEntity<List<CustomerDto>>(CustomerDto, HttpStatus.OK);
    }

    @PostMapping("customer/saveAll")
    public ResponseEntity<List<CustomerDto>> saveAll(@RequestBody @Validated List<CustomerDto> customerDtos) {
        return new ResponseEntity<List<CustomerDto>>(customerService.SaveAll(customerDtos),
                HttpStatus.CREATED);
    }

    @PutMapping("customer/update/{customerId}")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody @Validated CustomerDto customerDto,
                                                      @PathVariable("customerId") Long customerId) {
        return new ResponseEntity<CustomerDto>(customerService.updateCustomer(customerDto, customerId),
                HttpStatus.NO_CONTENT);

    }

}

