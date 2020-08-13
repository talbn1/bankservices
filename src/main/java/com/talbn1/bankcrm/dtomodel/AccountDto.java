package com.talbn1.bankcrm.dtomodel;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

/**
 * @author talbn on 8/9/2020
 **/


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {

    @Null
    private Long account_Id;

    @NotEmpty
    private Double balance;


    private List<LoanDto> loans;

}
