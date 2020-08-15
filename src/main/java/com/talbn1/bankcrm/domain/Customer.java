package com.talbn1.bankcrm.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@ToString
@Table(name = "CUSTOMERS")

public class Customer{

    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @JsonIgnoreProperties("customer")
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Account> accountList = new ArrayList<>();

    @JsonManagedReference
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;


    @Column(name = "credit_grade")
        private CreditGrade creditGrade;


    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
