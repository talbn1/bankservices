package com.talbn1.bankcrm.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author talbn on 7/15/2020
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Entity
@Table(name = "LOANS")
public class Loan {

    @Id
    private Integer bankAccount;
    private Integer loanId;
    private Float amount;
    private Integer duration;
    private Float payment;
    private Float rate;
    private String status;
}
