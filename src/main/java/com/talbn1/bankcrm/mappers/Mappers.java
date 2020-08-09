package com.talbn1.bankcrm.mappers;

import com.talbn1.bankcrm.domain.Customer;
import com.talbn1.bankcrm.dtomodel.CustomerDto;

/**
 * @author talbn on 8/6/2020
 **/
public interface Mappers {

    Customer customerDtoToCustomer(CustomerDto customerDto);

    CustomerDto customerToCustomerDto(Customer customer);
}
