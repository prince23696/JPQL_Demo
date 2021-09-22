package com.JPQL_Demo.JPQL_Demo_Project.Controller;

import com.JPQL_Demo.JPQL_Demo_Project.Entity.Employee;
import com.JPQL_Demo.JPQL_Demo_Project.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("getEmployee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

    @GetMapping("/getEmployees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PostMapping("/save")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employee;
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteItem(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "item deleted form database id-" + id;
    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
        return employee;
    }

    @GetMapping("/findByName/{name}")
    public List<Employee> findByName(@PathVariable String name) {
        return employeeService.findByName(name);
    }

    @GetMapping("/findBySalaryLessThan/{salary}")
    public List<Employee> findBySalaryLessThan(@PathVariable int salary) {
        return employeeService.findBySalaryLessThan(salary);
    }

    @GetMapping("/findBySalaryBetween/{salary}/{salary1}")
    public List<Employee> findBySalaryBetween(@PathVariable int salary, @PathVariable int salary1) {
        return employeeService.findBySalaryBetween(salary, salary1);
    }

    @GetMapping("/findBySalaryOrName/{salary}/{name}")
    public List<Employee> findBySalaryOrName(@PathVariable int salary, @PathVariable String name) {
        return employeeService.findBySalaryOrName(salary, name);
    }

    @GetMapping("/findByStartWith/{name}")
    public List<Employee> findByStartWith(@PathVariable String name) {
        return employeeService.findByStartWith(name);
    }


    @GetMapping("/findByNative")
    public List<Employee> findByNative() {
        return employeeService.findByNative();
    }

    @GetMapping("/findByNameNative/{name}")
    public List<Employee> findByNameNative(@PathVariable String name) {
        return employeeService.findByNameNative(name);
    }

}
