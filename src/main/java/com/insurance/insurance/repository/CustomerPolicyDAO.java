package com.insurance.insurance.repository;

import com.insurance.insurance.entity.CustomerPolicyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerPolicyDAO extends JpaRepository<CustomerPolicyDetail,Integer> {
    @Query(value ="select * from customer_policies where customer_id=?1 and is_active='1'",nativeQuery = true)
    List<CustomerPolicyDetail> fetchPoliciesById(int cId);

}
