package com.talbn1.bankcrm.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author talbn on 7/23/2020
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "ACCOUNTS")
public class Account {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long account_Id;

    @ManyToOne
    @JoinColumn(name = "person_id_fk")
    private Customer customer;

    private Double balance;

    @OneToMany(cascade= CascadeType.ALL, mappedBy = "account")
    private List<Loan> loans = new ArrayList<>();
}
