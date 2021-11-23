package com.JPQL_Demo.JPQL_Demo_Project.Repository;

import com.JPQL_Demo.JPQL_Demo_Project.Entity.Account;
import com.JPQL_Demo.JPQL_Demo_Project.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {


    @Query(value ="select e_id,e_name,salary,account.a_number from employee inner join account on employee.e_id=account.employee_e_id;;", nativeQuery = true)
    List<Employee> findByEmployeeRecord1();

}
