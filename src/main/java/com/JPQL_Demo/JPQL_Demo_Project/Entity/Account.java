package com.JPQL_Demo.JPQL_Demo_Project.Entity;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int a_id;
    private String a_number;
    private String type;
   @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;

    public Account() {
    }

    public Account(int a_id, String a_number, String type, Employee employee) {
        this.a_id = a_id;
        this.a_number = a_number;
        this.type = type;
        this.employee = employee;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_number() {
        return a_number;
    }

    public void setA_number(String a_number) {
        this.a_number = a_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Account{" +
                "a_id=" + a_id +
                ", a_number='" + a_number + '\'' +
                ", type='" + type + '\'' +
                ", employee=" + employee +
                '}';
    }
}
