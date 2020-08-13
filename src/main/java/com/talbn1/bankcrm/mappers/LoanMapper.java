package com.talbn1.bankcrm.mappers;

import com.talbn1.bankcrm.domain.Account;
import com.talbn1.bankcrm.domain.Loan;
import com.talbn1.bankcrm.dtomodel.LoanDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author talbn on 8/12/2020
 **/

@Component
public class LoanMapper {

    public Loan LoanDtoToEntity(LoanDto loanDto, Account account) {

        Loan.LoanBuilder loan = Loan.builder();
        loan.account(account);
        loan.amount(loanDto.getAmount());
        loan.duration(loanDto.getDuration());
        loan.leftToPay(loanDto.getLeftToPay());
        loan.payment(loanDto.getPayment());
        loan.status(loanDto.getStatus());
        loan.rate(loanDto.getRate());

        return  loan.build();
    }
}
