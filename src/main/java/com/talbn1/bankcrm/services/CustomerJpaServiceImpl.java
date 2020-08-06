package com.talbn1.bankcrm.services;

import com.talbn1.bankcrm.domain.Customer;
import com.talbn1.bankcrm.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author talbn on 8/4/2020
 **/

@RequiredArgsConstructor
@Service
public class CustomerJpaServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer saveNewBeer(Customer customer) {
        return customerRepository.save(customer);
    }


    @Override
    public Customer getById(Long customer_id){
        return customerRepository.findById(customer_id).orElse(null);
    }
}
