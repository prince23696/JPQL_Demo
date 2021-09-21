package com.JPQL_Demo.JPQL_Demo_Project.Repository;

import com.JPQL_Demo.JPQL_Demo_Project.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select e from Employee e where e.ename=:n")
    List<Employee> findByName(@Param("n") String name);
    

}
