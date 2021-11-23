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

    //Native Query
    @Query(value = "select * from employee", nativeQuery = true)
    List<Employee> findByNative();

    /*
      Not Working In Project but working in Database Mysql :-
      select e_name,salary,account.a_number from employee right join account on employee.e_id=account.employee_e_id
      select e_name,salary,a.a_number from employee e,account a where e.e_id=a.employee_e_id
    */
    @Query(value = "select * from employee e right join account a on e.e_id= a.employee_e_id", nativeQuery = true)
    List<Employee> findByEmployeeRecord();

    @Query(value = "select * from employee e inner join account a on e.e_id= a.employee_e_id where e.E_id=?1", nativeQuery = true)
    List<Employee> findByEmployeeRecordById(int id);

    @Query(value = "select * from account a inner join employee e on e.e_id= a.employee_e_id", nativeQuery = true)
    public List<Employee> findByAccountRecord();

    @Query(value = "select * from account a inner join employee e on e.e_id= a.employee_e_id where a.a_id=?1 ", nativeQuery = true)
    public List<Employee> findByAccountRecordById(int id);

    @Query(value = "select * from employee e where e.E_name=?1 ", nativeQuery = true)
    List<Employee> findByNameNative(String name);
}