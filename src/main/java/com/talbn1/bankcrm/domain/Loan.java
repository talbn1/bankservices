package com.talbn1.bankcrm.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

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

    @Column(name = "loan_Id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loanId;



    @ManyToOne
    @JoinColumn(name = "Account_id")
    private Account account;
    private Double amount;
    @Column(name = "left_To_Pay")
    private Float leftToPay;
    private Integer duration;
    private Float payment;
    private Float rate;
    private String status;
    @Column(name = "start_Date")
    private Date startDate;
}
