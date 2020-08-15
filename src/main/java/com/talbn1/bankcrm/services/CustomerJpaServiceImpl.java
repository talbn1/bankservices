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
import java.util.Objects;

/**
 * @author talbn on 8/4/2020
 **/


@Service
public class CustomerJpaServiceImpl implements CustomerService {

    public CustomerJpaServiceImpl(CustomerRepository customerRepository, Mappers customerMapper,
                                  CustomerConverter customerConverter,
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
        return customerConverter.customerEntityToDto(customerRepository.save(mapCustomer(customerDto)));
    }


    @Override
    public CustomerDto getById(Long customerId){
        return customerConverter.customerEntityToDto(Objects.requireNonNull
                (customerRepository.findById(customerId).orElse(null)));
    }

    @Override
    public List<CustomerDto> getAll() {

        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDto> dtoList = new ArrayList<>();
        for (Customer customer: customerList) {
            dtoList.add(customerConverter.customerEntityToDto(customer));
        }
        return dtoList;

    }

    @Override
    public List<CustomerDto> SaveAll(List<CustomerDto> customerDtos) {

        List<Customer> customers = new ArrayList<>();

        for (CustomerDto customerDto: customerDtos) {
            customers.add(mapCustomer(customerDto));
        }
        List<Customer> savedCustomers =  customerRepository.saveAll(customers);
        List<CustomerDto> dtos = new ArrayList<>();
        for (Customer customer: savedCustomers) {
            dtos.add(customerConverter.customerEntityToDto(customer));
        }
        return dtos;
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, Long customerId) {

        try {
            Customer customer = customerRepository.findById(customerId).orElse(null);
            customer.setFirstName(customerDto.getFirstName());
            return  customerConverter.customerEntityToDto(customer);
        }catch (NullPointerException  e){
            return null;
        }
    }

    public Customer mapCustomer(CustomerDto customerDto){

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

        return customer;
    }
}
