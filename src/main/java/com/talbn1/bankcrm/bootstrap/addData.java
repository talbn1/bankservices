package com.talbn1.bankcrm.bootstrap;

import com.talbn1.bankcrm.domain.*;
import org.apache.tomcat.jni.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author talbn on 8/4/2020
 **/

@Component
public class addData implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Data loader start");
    }

    private void loadData() {

        Customer customer1 = new Customer();

        customer1.setFirstName("Tal");
        customer1.setLastName("Benui");
        customer1.setCreditGrade(CreditGrade.EXELLENT);

        Address address1 = Address.builder().aptNumber(54).city("Beer Sheva").email("tal@email" +
                ".com").street("thisStreet").telephone("0303887755").build();

        customer1.setAddress(address1);

        List<Double> balances1 = Arrays.asList(1256.38, 100005.56, 4.3);
        List<Account> accounts = createAccounts(balances1);

        customer1.setAccountList(accounts);


        // --------------------------------------------------------------

        Customer customer2 = new Customer();

        customer1.setFirstName("Eli");
        customer1.setLastName("Bsavc");
        customer1.setCreditGrade(CreditGrade.AVARAGE);

        Address address2 = Address.builder().aptNumber(3).city("Sheva kiriat").email("eli@email" +
                ".com").street("mainStreet").telephone("030322225").build();

        customer1.setAddress(address2);

        List<Double> balances2 = Arrays.asList(6256.38, 20225.56, 1.3);
        List<Account> accounts2 = createAccounts(balances2);

        customer2.setAccountList(accounts);

        //--------------------------------------------------------------------
    }

    private List<Account> createAccounts(List<Double> balances){
        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < balances.size(); i++) {

            Account account = new Account();
            account.setBalance(balances.get(i));

            List<Loan> loans = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                Loan loan = new Loan();
                loan.setAmount(12256d*i*j);
                loan.setDuration(12*i*j);
                loan.setLeftToPay(544f*i*j);
                loan.setPayment(1200f*j);
                loan.setRate(0.5f*i*j);
                loans.add(loan);
            }
            account.setLoans(loans);
        }
        return accounts;
    }

}
