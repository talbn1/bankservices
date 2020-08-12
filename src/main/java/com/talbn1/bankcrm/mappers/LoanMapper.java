package com.talbn1.bankcrm.mappers;

import com.talbn1.bankcrm.domain.Customer;
import com.talbn1.bankcrm.domain.Loan;
import com.talbn1.bankcrm.dtomodel.CustomerDto;
import com.talbn1.bankcrm.dtomodel.LoanDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author talbn on 8/12/2020
 **/

@Component
public class LoanMapper {

    public Loan LoanDtoToEntity(LoanDto loanDto) {
        ModelMapper modelMapper = new ModelMapper();
        return  modelMapper.map(loanDto,Loan.class);
    }
}
