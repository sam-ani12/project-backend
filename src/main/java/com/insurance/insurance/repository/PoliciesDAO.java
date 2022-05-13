package com.insurance.insurance.repository;

import com.insurance.insurance.entity.PoliciesDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliciesDAO extends JpaRepository<PoliciesDetails,Integer> {
    @Query(value ="select * from policies",nativeQuery = true)
    PoliciesDetails fetchPolicies();
}

