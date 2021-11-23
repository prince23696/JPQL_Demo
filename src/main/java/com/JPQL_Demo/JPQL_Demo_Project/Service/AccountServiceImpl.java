package com.JPQL_Demo.JPQL_Demo_Project.Service;

import com.JPQL_Demo.JPQL_Demo_Project.Entity.Account;
import com.JPQL_Demo.JPQL_Demo_Project.Entity.Employee;
import com.JPQL_Demo.JPQL_Demo_Project.Repository.AccountRepository;
import com.JPQL_Demo.JPQL_Demo_Project.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccount() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public Account getAccount(int id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public String addAccount(Account account) {
        accountRepository.save(account);
        return "Account Added Successfully";
    }


    @Override
    public Account updateAccount(int id, Account account) {
        Account account1 = accountRepository.findById(id).get();
        account1.setA_number(account.getA_number());
        account1.setType(account.getType());
        account1.setEmployee(account.getEmployee());
        accountRepository.save(account1);
        return account1;
    }

    @Override
    public String deleteAccount(int id) {
        accountRepository.deleteById(id);
        return "Account deleted from database id=" + id;
    }

    @Override
    public List<Employee> findByEmployeeRecord1() {
        return  accountRepository.findByEmployeeRecord1();
    }
}
