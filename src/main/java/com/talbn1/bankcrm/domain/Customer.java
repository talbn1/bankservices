package com.talbn1.bankcrm.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

/**
 * @author talbn on 7/15/2020
 **/


@Data
@Builder
@Entity
@Table(name = "CUSTOMERS")
public class Customer extends PersonBaseEntity {


    public Customer(Long id, String firstName, String lastName, Integer bankAccount,
                    Double balance, Set<Loan> loans, Integer addressId, CreditGrade creditGrade) {
        super(id, firstName, lastName);
        this.bankAccount = bankAccount;
        this.balance = balance;
        this.loans = loans;
        this.addressId = addressId;
        this.creditGrade = creditGrade;
    }

    public Customer(Integer bankAccount, Double balance, Set<Loan> loans, Integer addressId, CreditGrade creditGrade) {
        this.bankAccount = bankAccount;
        this.balance = balance;
        this.loans = loans;
        this.addressId = addressId;
        this.creditGrade = creditGrade;
    }

    public Customer(String firstName, String lastName, Integer bankAccount, Double balance, Set<Loan> loans, Integer addressId, CreditGrade creditGrade) {
        super(firstName, lastName);
        this.bankAccount = bankAccount;
        this.balance = balance;
        this.loans = loans;
        this.addressId = addressId;
        this.creditGrade = creditGrade;
    }

    @Column(name = "bank_account")
    @Id
    private Integer bankAccount;
    private Double balance;
    private Set<Loan> loans;
    private Integer addressId;
    @Column(name = "credit_Grade")
    private CreditGrade creditGrade;
}
