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

    @Query("select e from Employee e where e.salary<:s")
    List<Employee> findBySalaryLessThan(@Param("s") int salary);

    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> findBySalaryBetween(int salary, int salary1);

    @Query("select e from Employee e where e.salary<= ?1 or e.ename=?2")
    List<Employee> findBySalaryOrName(int salary, String name);

    @Query("select e from Employee e where e.ename like ?1%")
    List<Employee> findByStartWith(String name);

    @Query(value = "select * from employee", nativeQuery = true)
    List<Employee> findByNative();

    @Query(value = "select * from Employee e where e.e_name=?1 ",
            /*countQuery = "select count(e_id) from employee e where e.ename= ?1,"*/ nativeQuery = true)
    List<Employee> findByNameNative(String name);

}