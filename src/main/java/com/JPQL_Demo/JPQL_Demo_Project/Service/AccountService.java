package com.JPQL_Demo.JPQL_Demo_Project.Service;

import com.JPQL_Demo.JPQL_Demo_Project.Entity.Account;
import com.JPQL_Demo.JPQL_Demo_Project.Entity.Employee;

import java.util.List;

public interface AccountService {

    public List<Account> getAllAccount();

    public Account getAccount(int id);

    public String addAccount(Account account);

    public Account updateAccount(int id, Account account);

    public String deleteAccount(int id);

    public List<Employee> findByEmployeeRecord1();

}
