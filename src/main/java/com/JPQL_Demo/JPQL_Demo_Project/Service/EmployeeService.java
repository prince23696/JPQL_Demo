package com.JPQL_Demo.JPQL_Demo_Project.Service;

import com.JPQL_Demo.JPQL_Demo_Project.Entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeService {

   public List<Employee> getAllEmployee();

    public Employee getEmployee(int id);

    public String addEmployee(Employee employee);

    public Employee updateEmployee(int id, Employee employee);

    public String deleteEmployee(int id);

    //JPQl QUERY
    public List<Employee> findByName(String name);

    public List<Employee> findBySalaryLessThan(int salary);

    public List<Employee> findBySalaryBetween(int salary, int salary1);

    public List<Employee> findByStartWith(String name);

    public List<Employee> findBySalaryOrName(int salary, String name);

    //JPQL NATIVE QUERY
    public List<Employee> findByNative();

    public List<Employee> findByNameNative(String name);

}
