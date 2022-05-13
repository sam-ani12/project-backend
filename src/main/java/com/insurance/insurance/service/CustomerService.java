package com.insurance.insurance.service;

import com.insurance.insurance.dto.BaseResponse;
import com.insurance.insurance.dto.CustomerRequest;
import com.insurance.insurance.dto.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface CustomerService {
    ResponseEntity<BaseResponse> customerRegistration(CustomerRequest customerRequest);

    ResponseEntity<BaseResponse> customerLogin(LoginRequest loginRequest);
}
