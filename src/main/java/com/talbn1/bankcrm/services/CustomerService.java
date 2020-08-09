package com.talbn1.bankcrm.services;

import com.talbn1.bankcrm.domain.Customer;
import com.talbn1.bankcrm.dtomodel.CustomerDto;

/**
 * @author talbn on 8/4/2020
 **/


public interface CustomerService {

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    Customer getById(Long customerId);
}
