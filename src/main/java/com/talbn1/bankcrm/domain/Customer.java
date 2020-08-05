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

public class Customer{

    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Account> accountList = new ArrayList<>();

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;

    @Column(name = "credit_grade")
        private CreditGrade creditGrade;
}
