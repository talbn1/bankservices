package com.talbn1.bankcrm.dtomodel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.talbn1.bankcrm.domain.Account;
import com.talbn1.bankcrm.domain.Address;
import com.talbn1.bankcrm.domain.CreditGrade;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.List;

/**
 * @author talbn on 8/6/2020
 **/

@Data
@NoArgsConstructor
@Builder
public class CustomerDto {

    public CustomerDto(@Null Long customerId,
                       @NotBlank String firstName,
                       @NotBlank String lastName,
                       @NotBlank Address address,
                       @NotBlank CreditGrade creditGrade,
                       List<AccountDto> accounts) {

        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.creditGrade = creditGrade;
        this.accounts = accounts;
    }

    @Null
    private Long customerId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private Address address;

    @NotBlank
    private CreditGrade creditGrade;

    //@JsonBackReference
    private List<AccountDto> accounts;


}
