package com.talbn1.bankcrm.dtomodel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.talbn1.bankcrm.domain.Account;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;


/**
 * @author talbn on 8/12/2020
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LoanDto {

    @Null
    private Long loan_Id;

    private Long account_Id;
    @NotBlank
    private Double amount;
    @NotBlank
    private Float leftToPay;
    @NotBlank
    private Integer duration;
    @NotBlank
    private Float payment;
    @NotBlank
    private Float rate;
    @NotBlank
    private String status;
}
