package com.talbn1.bankcrm.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author talbn on 7/23/2020
 **/

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ACCOUNTS")
public class Account {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long account_Id;

    @ManyToOne
    @JoinColumn(name = "person_id_fk")
    @JsonBackReference
    private Customer customer;

    private Double balance;



    @OneToMany(cascade= CascadeType.ALL, mappedBy = "account")
    @JsonManagedReference
    private List<Loan> loans = new ArrayList<>();



    public Long getAccount_Id() {
        return account_Id;
    }

    public void setAccount_Id(Long account_Id) {
        this.account_Id = account_Id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}
