package com.JPQL_Demo.JPQL_Demo_Project.Service;

import com.JPQL_Demo.JPQL_Demo_Project.Entity.Employee;
import com.JPQL_Demo.JPQL_Demo_Project.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public String addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee Added Successfully";
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee employee1 = employeeRepository.findById(id).get();
        employee1.setEname(employee.getEname());
        employee1.setSalary(employee.getSalary());
        employee1.setAccounts(employee.getAccounts());
        employeeRepository.save(employee1);
        return employee1;
    }

    @Override
    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return "Employee Deleted Successfully id=" + id;
    }

    @Override
    public List<Employee> findByName(String name) {
        return (List<Employee>) employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> findBySalaryLessThan(int salary) {
        return (List<Employee>) employeeRepository.findBySalaryLessThan(salary);
    }

    @Override
    public List<Employee> findBySalaryBetween(int salary, int salary1) {
        return (List<Employee>) employeeRepository.findBySalaryBetween(salary, salary1);
    }

    @Override
    public List<Employee> findByStartWith(String name) {
        return (List<Employee>) employeeRepository.findByStartWith(name);
    }

    @Override
    public List<Employee> findBySalaryOrName(int salary, String name) {
        return employeeRepository.findBySalaryOrName(salary, name);
    }

    @Override
    public List<Employee> findByNative() {
        return (List<Employee>) employeeRepository.findByNative();
    }

    @Override
    public List<Employee> findByEmployeeRecord() {
        return (List<Employee>) employeeRepository.findByEmployeeRecord();
    }

    @Override
    public List<Employee> findByEmployeeRecordById(int id) {
        return employeeRepository.findByEmployeeRecordById(id);
    }

    @Override
    public List<Employee> findByAccountRecord() {
        return (List<Employee>) employeeRepository.findByAccountRecord();
    }

    @Override
    public List<Employee> findByAccountRecordById(int id) {
        return employeeRepository.findByAccountRecordById(id);
    }

    @Override
    public List<Employee> findByNameNative(String name) {
        return (List<Employee>) employeeRepository.findByNameNative(name);
    }
}
