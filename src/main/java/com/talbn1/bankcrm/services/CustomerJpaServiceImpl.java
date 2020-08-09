package com.talbn1.bankcrm.services;

import com.talbn1.bankcrm.domain.Address;
import com.talbn1.bankcrm.domain.Customer;
import com.talbn1.bankcrm.dtomodel.CustomerDto;
import com.talbn1.bankcrm.mappers.AddressMapper;
import com.talbn1.bankcrm.mappers.CustomerConverter;
import com.talbn1.bankcrm.mappers.Mappers;
import com.talbn1.bankcrm.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

/**
 * @author talbn on 8/4/2020
 **/


@Service
public class CustomerJpaServiceImpl implements CustomerService {

    public CustomerJpaServiceImpl(CustomerRepository customerRepository, Mappers customerMapper, CustomerConverter customerConverter, AddressMapper addressMapper, AddressMapper address, AddressMapper addressMapper1) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.customerConverter = customerConverter;
        this.addressMapper = addressMapper;
    }

    private final CustomerRepository customerRepository;
    private final Mappers customerMapper;
    private final CustomerConverter customerConverter;
    private final AddressMapper addressMapper;

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {


        Address address  = customerDto.getAddress();

        Customer customer = customerMapper.customerDtoToCustomer(customerDto);

        address.setCustomer(customer);
        customer.setAddress(address);


        return customerConverter.customerEntityToDto(customerRepository.save(customer));

    }

    @Override
    public Customer getById(Long customer_id){
        return customerRepository.findById(customer_id).orElse(null);
    }
}
