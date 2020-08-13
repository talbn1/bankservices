package com.talbn1.bankcrm.services;

import com.talbn1.bankcrm.domain.Account;
import com.talbn1.bankcrm.domain.Address;
import com.talbn1.bankcrm.domain.Customer;
import com.talbn1.bankcrm.domain.Loan;
import com.talbn1.bankcrm.dtomodel.AccountDto;
import com.talbn1.bankcrm.dtomodel.CustomerDto;
import com.talbn1.bankcrm.dtomodel.LoanDto;
import com.talbn1.bankcrm.mappers.*;
import com.talbn1.bankcrm.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author talbn on 8/4/2020
 **/


@Service
public class CustomerJpaServiceImpl implements CustomerService {

    public CustomerJpaServiceImpl(CustomerRepository customerRepository, Mappers customerMapper,
                                  CustomerConverter customerConverter, AddressMapper addressMapper,
                                  AddressMapper address, AddressMapper addressMapper1,
                                  AccountMapper accountMapper, LoanMapper loanMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.customerConverter = customerConverter;
        this.accountMapper = accountMapper;
        this.loanMapper = loanMapper;
    }
    private final CustomerRepository customerRepository;
    private final Mappers customerMapper;
    private final CustomerConverter customerConverter;
    private final AccountMapper accountMapper;
    private final LoanMapper loanMapper;


    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {

        Customer customer = customerMapper.customerDtoToCustomer(customerDto);

        Address address  = customerDto.getAddress();
        List<Account> accountsInitial = new ArrayList<>();
        customer.setAccountList(accountsInitial);
        List<AccountDto> accountDtos = customerDto.getAccounts();

        for (AccountDto accountDto: accountDtos)
        {
            Account account = accountMapper.AccountDtoToEntitiy(accountDto);
            List<Loan> loansInitial = new ArrayList<>();
            List<LoanDto> loanDtos = accountDto.getLoans();

            if (loanDtos != null){
                account.setLoans(loansInitial);
                for (LoanDto loanDto: loanDtos) {
                    Loan loan = loanMapper.LoanDtoToEntity(loanDto, account );
                    account.getLoans().add(loan);
                }
            }
            account.setCustomer(customer);
            customer.getAccountList().add(account);
        }

        address.setCustomer(customer);
        customer.setAddress(address);
        return customerConverter.customerEntityToDto(customerRepository.save(customer));
    }

    @Override
    public Customer getById(Long customer_id){
        return customerRepository.findById(customer_id).orElse(null);
    }

}
