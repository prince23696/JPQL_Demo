package com.JPQL_Demo.JPQL_Demo_Project.Repository;

import com.JPQL_Demo.JPQL_Demo_Project.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {


}
