package com.insurance.insurance.controller;

import com.insurance.insurance.dto.BaseResponse;
import com.insurance.insurance.dto.CustomerRequest;
import com.insurance.insurance.dto.LoginRequest;
import com.insurance.insurance.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("register")
    public ResponseEntity<BaseResponse> customerRegistration(@RequestBody CustomerRequest customerRequest) {
        if (customerRequest == null) {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("Fields Should not be Empty");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());

        }

        return customerService.customerRegistration(customerRequest);
    }

    @PostMapping("login")
    public ResponseEntity<BaseResponse> customerLogin(@RequestBody LoginRequest loginRequest)
    {
        if(loginRequest==null) {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("fields Should not be null");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return customerService.customerLogin(loginRequest);
    }
}
