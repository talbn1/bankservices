package com.talbn1.bankcrm.dtomodel;

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
    @Null
    private Account account;
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
