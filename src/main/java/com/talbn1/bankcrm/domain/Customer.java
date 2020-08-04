package com.talbn1.bankcrm.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author talbn on 7/15/2020
 **/


@Data
@Builder
@Entity
@AllArgsConstructor
@Table(name = "CUSTOMERS")

public class Customer extends PersonBaseEntity {

    public Customer() {
    }

/*
    public Customer(Long id, String firstName, String lastName, Set<Account> accountList,
                    Address address, CreditGrade creditGrade) {
        super(id, firstName, lastName);

        this.address = address;
        this.accountList = accountList;
        this.creditGrade = creditGrade;
    }
*/

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Account> accountList = new ArrayList<>();

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;

    @Column(name = "credit_grade")
        private CreditGrade creditGrade;
}
