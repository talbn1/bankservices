package com.talbn1.bankcrm.bootstrap;

import com.talbn1.bankcrm.domain.*;
import com.talbn1.bankcrm.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author talbn on 8/4/2020
 **/

@RequiredArgsConstructor
@Component
public class addData implements CommandLineRunner {


    private final CustomerRepository  customerRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Data loader START");
        //loadData();
        System.out.println("Data loader END");
    }

    private void loadData() {


        List<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer();

        customer1.setFirstName("Tal");
        customer1.setLastName("Benui");
        customer1.setCreditGrade(CreditGrade.EXELLENT);

        Address address1 = Address.builder().aptNumber(54).city("Beer Sheva").email("tal@email" +
                ".com").street("thisStreet").telephone("0303887755").customer(customer1).build();

        customer1.setAddress(address1);

        List<Double> balances1 = Arrays.asList(1256.38, 100005.56, 4.3);
        List<Account> accounts = createAccounts(balances1);

        for (int i = 0; i < accounts.size(); i++) {

            accounts.get(i).setCustomer(customer1);
        }
            customer1.setAccountList(accounts);

        customers.add(customer1);

        // --------------------------------------------------------------

        Customer customer2 = new Customer();

        customer2.setFirstName("Eli");
        customer2.setLastName("Bsavc");
        customer2.setCreditGrade(CreditGrade.AVARAGE);

        Address address2 = Address.builder().aptNumber(3).city("Sheva kiriat").email("eli@email" +
                ".com").street("mainStreet").telephone("030322225").customer(customer2).build();

        customer2.setAddress(address2);

        List<Double> balances2 = Arrays.asList(6256.38, 20225.56, 1.3);
        List<Account> accounts2 = createAccounts(balances2);

        for (int i = 0; i < accounts.size(); i++) {

            accounts2.get(i).setCustomer(customer2);
        }


        customer2.setAccountList(accounts2);

        // --------------------------------------------------------------

        Customer customer3 = new Customer();

        customer3.setFirstName("yorm");
        customer3.setLastName("lavin");
        customer3.setCreditGrade(CreditGrade.AVARAGE);

        Address address3 = Address.builder().aptNumber(33).city("Tel kiriat").email("yoram@email" +
                ".com").street("BeniStreet").telephone("030322225").customer(customer3).build();

        customer3.setAddress(address3);

        List<Double> balances3 = Arrays.asList(61111.0, 208885.56, 2.3);
        List<Account> accounts3 = createAccounts(balances3);



        for (int i = 0; i < accounts.size(); i++) {

            accounts3.get(i).setCustomer(customer3);
        }

        customer3.setAccountList(accounts3);


        //--------------------------------------------------------------------
        System.out.println("--------->>>>>>insert 1: " + customer1.getFirstName());
        customerRepository.save(customer1);

        System.out.println("--------->>>>>>insert 2: " + customer2.getFirstName());
        customerRepository.save(customer2);

        System.out.println("--------->>>>>>insert 3: " + customer3.getFirstName());
        customerRepository.save(customer3);

    }

    private List<Account> createAccounts(List<Double> balances){
        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < balances.size(); i++) {

            Account account = new Account();
            account.setBalance(balances.get(i));

            List<Loan> loans = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                Loan loan = new Loan();
                loan.setAmount(12256d*(i+1)*(j+1));
                loan.setDuration(12*(i+1)*(j+1));
                loan.setLeftToPay(544f*(i+1)*(j+1));
                loan.setPayment(1200f*(i+1)*(j+1));
                loan.setRate(0.5f*(i+1)*(j+1));
                loan.setStatus("Active");
                loan.setAccount(account);
                loans.add(loan);

            }
            account.setLoans(loans);
            accounts.add(account);
        }
        return accounts;
    }

}
