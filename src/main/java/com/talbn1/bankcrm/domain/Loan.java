package com.talbn1.bankcrm.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loan_Id;

    @ManyToOne
    @JoinColumn(name = "account_Id_fk")
    @JsonBackReference
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
