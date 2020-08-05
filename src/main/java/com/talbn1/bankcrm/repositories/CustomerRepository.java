package com.talbn1.bankcrm.repositories;

import com.talbn1.bankcrm.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * @author talbn on 8/4/2020
 **/

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer save(Customer customer);

}
