package com.talbn1.bankcrm.mappers;

/**
 * @author talbn on 8/10/2020
 **/

import com.talbn1.bankcrm.domain.Account;
import com.talbn1.bankcrm.dtomodel.AccountDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account AccountDtoToEntitiy(AccountDto accountDto){






        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(accountDto, Account.class);
    }

    public AccountDto EntityToAccountDto(Account account){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(account, AccountDto.class);
    }

}
