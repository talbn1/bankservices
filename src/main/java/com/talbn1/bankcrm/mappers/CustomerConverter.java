package com.talbn1.bankcrm.mappers;

import com.talbn1.bankcrm.domain.Customer;
import com.talbn1.bankcrm.dtomodel.CustomerDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author talbn on 8/8/2020
 **/

@Component
public class CustomerConverter {

    public Customer customerDtoToEntitiy(CustomerDto customerDto) {

        ModelMapper modelMapper = new ModelMapper();
        return  modelMapper.map(customerDto,Customer.class);
    }

    public CustomerDto customerEntityToDto(Customer customer) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(customer,CustomerDto.class);
    }
}
