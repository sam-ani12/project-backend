package com.insurance.insurance.repository;

import com.insurance.insurance.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<Customer,Integer> {

    @Query(value ="select * from customer where email=?1 and password=?2",nativeQuery = true)
    Customer login(String email,String password);
}
