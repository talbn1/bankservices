package com.talbn1.bankcrm.services;

import com.talbn1.bankcrm.domain.Customer;
import com.talbn1.bankcrm.dtomodel.CustomerDto;

import java.util.List;
import java.util.Set;

/**
 * @author talbn on 8/4/2020
 **/


public interface CustomerService {

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    CustomerDto getById(Long customerId);

    List<CustomerDto> getAll();

    List<CustomerDto> SaveAll(List<CustomerDto> customerDtos);

    CustomerDto updateCustomer(CustomerDto customerDto, Long customerId);
}
