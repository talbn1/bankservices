package com.talbn1.bankcrm.mappers;

import com.talbn1.bankcrm.domain.Account;
import com.talbn1.bankcrm.domain.Customer;
import com.talbn1.bankcrm.dtomodel.AccountDto;
import com.talbn1.bankcrm.dtomodel.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author talbn on 8/8/2020
 **/

@Component
public class CustomerConverter {

    private final AccountMapper accountMapper;

    public CustomerConverter(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }


    public Customer customerDtoToEntitiy(CustomerDto customerDto) {

/*        ModelMapper modelMapper = new ModelMapper();
        return  modelMapper.map(customerDto,Customer.class);*/

        if (customerDto == null) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();
        //customer.address()

        return null;
    }

    public CustomerDto customerEntityToDto(Customer customer) {

        CustomerDto.CustomerDtoBuilder customerDto = CustomerDto.builder();
        customerDto.customerId(customer.getCustomerId());
        customerDto.firstName(customer.getFirstName());
        customerDto.lastName(customer.getLastName());
        customerDto.creditGrade(customer.getCreditGrade());

        List<AccountDto> accountDtos = new ArrayList<>();

        if (customer.getAccountList().size() > 0 ){
            for (Account account: customer.getAccountList()) {
                accountDtos.add(accountMapper.EntityToAccountDto(account));
            }
        }
        customerDto.accounts(accountDtos);
        customerDto.address(customer.getAddress());

        return customerDto.build();
    }
}