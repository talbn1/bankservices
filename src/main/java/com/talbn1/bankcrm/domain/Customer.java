package com.talbn1.bankcrm.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

/**
 * @author talbn on 7/15/2020
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Entity
@Table(name = "CUSTOMERS")
public class Customer extends PersonBaseEntity {

    private Integer bankAccount;
    private Double balance;
    private Set<Loan> loans;
    private Set<Mortgage> mortgages;
    private Address address;
    private CreditGrade creditGrade;
}
