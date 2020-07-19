package ru.itis.work_with_db;
//https://java-course.ru/begin/database03/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itis.work_with_db.JDBC_test.models.*;
import ru.itis.work_with_db.JDBC_test.repositories.*;

import java.util.Collections;
import java.util.Date;

import static java.util.Arrays.asList;

@SpringBootApplication
public class WorkWithDbApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(WorkWithDbApplication.class, args);

        ClientRepository clientRepository = context.getBean(ClientRepository.class);
        PassportRepository passportRepository = context.getBean(PassportRepository.class);
        AccountRepository accountRepository = context.getBean(AccountRepository.class);
        BankRepository bankRepository = context.getBean(BankRepository.class);
        CompanyRepository companyRepository = context.getBean(CompanyRepository.class);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        ATMRepository atmRepository = context.getBean(ATMRepository.class);
        OperationRepository operationRepository= context.getBean(OperationRepository.class);

        Bank bank1 = Bank.builder()
                .name("bank1")
                .phone("bank1")
                .address("bank1")
                .build();

        Bank bank2 = Bank.builder()
                .name("bank2")
                .phone("bank2")
                .address("bank2")
                .build();

        bankRepository.save(bank1);
        bankRepository.save(bank2);

        Passport passport1 = Passport.builder()
                .number(100)
                .series(100)
                .whenIssued(new Date())
                .whoIssued("passport1")
                .dateOfBirth(new Date())
                .address("passport1")
                .build();

        Passport passport2 = Passport.builder()
                .number(200)
                .series(200)
                .whenIssued(new Date())
                .whoIssued("passport2")
                .dateOfBirth(new Date())
                .address("passport2")
                .build();

        passportRepository.save(passport1);
        passportRepository.save(passport2);

        Client client1 = Client.builder()
                .firstname("client1")
                .lastname("client1")
                .phone("client1")
                .passport(passport1)
                .banks(asList(bank1))
                .build();

        Client client2 = Client.builder()
                .firstname("client2")
                .lastname("client2")
                .phone("client2")
                .passport(passport2)
                .banks(asList(bank1, bank2))
                .build();

        clientRepository.save(client1);
        clientRepository.save(client2);

        Account account1 = Account.builder()
                .client(client1)
                .money(new Long(10000))
                .build();

        Account account2 = Account.builder()
                .client(client2)
                .money(new Long(100))
                .build();

        accountRepository.save(account1);
        accountRepository.save(account2);

        Company company1 = Company.builder()
                .name("company1")
                .money(new Long(100000))
                .banks(asList(bank1, bank2))
                .build();

        Company company2 = Company.builder()
                .name("company2")
                .money(new Long(1000000))
                .banks(asList(bank2))
                .build();

        companyRepository.save(company1);
        companyRepository.save(company2);

        Employee employee1 = Employee.builder()
                .firstname("employee1")
                .lastname("employee1")
                .bank(bank1)
                .build();

        Employee employee2 = Employee.builder()
                .firstname("employee2")
                .lastname("employee2")
                .bank(bank2)
                .build();

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        ATM atm1 = ATM.builder()
                .bank(bank1)
                .build();

        ATM atm2 = ATM.builder()
                .bank(bank2)
                .build();

        atmRepository.save(atm1);
        atmRepository.save(atm2);

        Operation operation1 = Operation.builder()
                .operation(Operations.FIFTH)
                .atm(atm1)
                .account(account1)
                .build();

        Operation operation2 = Operation.builder()
                .operation(Operations.THIRD)
                .employee(employee2)
                .account(account2)
                .build();

        operationRepository.save(operation1);
        operationRepository.save(operation2);
    }
}
