package com.JPQL_Demo.JPQL_Demo_Project.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int e_id;
    @Column(name = "E_name")
    private String ename;
    private int salary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Account> accounts;

    public Employee() {
    }

    public Employee(int e_id, String ename, int salary, List<Account> accounts) {
        this.e_id = e_id;
        this.ename = ename;
        this.salary = salary;
        this.accounts = accounts;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "e_id=" + e_id +
                ", ename='" + ename + '\'' +
                ", salary=" + salary +
                ", accounts=" + accounts +
                '}';
    }
}
