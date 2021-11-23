package com.JPQL_Demo.JPQL_Demo_Project.Controller;

import com.JPQL_Demo.JPQL_Demo_Project.Entity.Account;
import com.JPQL_Demo.JPQL_Demo_Project.Entity.Employee;
import com.JPQL_Demo.JPQL_Demo_Project.Repository.EmployeeRepository;
import com.JPQL_Demo.JPQL_Demo_Project.Service.AccountService;
import com.JPQL_Demo.JPQL_Demo_Project.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    AccountService accountService;

    @GetMapping("getAccount/{id}")
    public Account getAccount(@PathVariable int id) {
        Account account = accountService.getAccount(id);
        return account;
    }

    @GetMapping("/getAccounts")
    public List<Account> getAll() {
        return (List<Account>) accountService.getAllAccount();
    }

    @PostMapping("/saveAccount")
    public Account addAccount(@RequestBody Account account) {
        accountService.addAccount(account);
        return account;
    }

    @GetMapping("/findByAccountRecord1")
    public List<Employee> findByAccountRecord1() {
        return employeeService.findByAccountRecord();
    }

    @DeleteMapping("/deleteAccount/{id}")
    public String deleteAccount(@PathVariable int id) {
        accountService.deleteAccount(id);
        return "item deleted form database id-" + id;
    }

    @PutMapping("/updateAccount/{id}")
    public Account updateAccount(@PathVariable int id, @RequestBody Account account) {
        accountService.updateAccount(id, account);
        return account;
    }
}
