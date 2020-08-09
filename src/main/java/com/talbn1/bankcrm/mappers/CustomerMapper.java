package com.talbn1.bankcrm.mappers;

import com.talbn1.bankcrm.domain.Customer;
import com.talbn1.bankcrm.dtomodel.CustomerDto;
import org.springframework.stereotype.Service;

/**
 * @author talbn on 8/6/2020
 **/
@Service
public class CustomerMapper implements Mappers{


    public Customer customerDtoToCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        //customer.address(customerDto.getAddress());
        customer.customerId( customerDto.getCustomerId() );
        customer.firstName( customerDto.getFirstName() );
        customer.lastName( customerDto.getLastName() );
        customer.creditGrade( customerDto.getCreditGrade() );

        return customer.build();
    }

    public CustomerDto customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto.CustomerDtoBuilder customerDto = CustomerDto.builder();

        customerDto.customerId( customer.getCustomerId() );
        customerDto.firstName( customer.getFirstName() );
        customerDto.lastName( customer.getLastName() );
        customerDto.creditGrade( customer.getCreditGrade() );

        return customerDto.build();
    }
}
