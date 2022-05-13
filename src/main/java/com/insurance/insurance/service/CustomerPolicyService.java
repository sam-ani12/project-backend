package com.insurance.insurance.service;

import com.insurance.insurance.dto.BaseResponse;
import com.insurance.insurance.dto.CustomerPolicyRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface CustomerPolicyService {
    ResponseEntity<BaseResponse> insertCustomerPolicies(CustomerPolicyRequest customerPolicyRequest);

    ResponseEntity<BaseResponse> fetchCustomerPolicyInformation(int customerId);

    ResponseEntity<BaseResponse> customerBuyPolicies(CustomerPolicyRequest customerPolicyRequest);
}
