package com.talbn1.bankcrm.repositories;

import com.talbn1.bankcrm.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author talbn on 8/4/2020
 **/

public interface CustomerRepository extends CrudRepository<Customer,Long> {

    Customer saveCustomer(Customer customer);

}
