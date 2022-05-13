package com.insurance.insurance.controller;


import com.insurance.insurance.dto.BaseResponse;
import com.insurance.insurance.dto.CustomerPolicyRequest;
import com.insurance.insurance.dto.LoginRequest;
import com.insurance.insurance.service.CustomerPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class CustomerPolicyController {

    @Autowired
    private CustomerPolicyService customerPolicyService;

    @PostMapping("insert_customer_policy")
    public ResponseEntity<BaseResponse> addCustomerPolicy(@RequestBody CustomerPolicyRequest customerPolicyRequest)
    {
        if(customerPolicyRequest==null) {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("Fields should not be null");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return customerPolicyService.insertCustomerPolicies(customerPolicyRequest);
    }

    @GetMapping("fetch-customer-policy/{customerId}")
    public ResponseEntity<BaseResponse> displayCustomerPolicy(@PathVariable int customerId)
    {
        if(customerId==0) {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("fields Should not be null");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return customerPolicyService.fetchCustomerPolicyInformation(customerId);
    }

    @PostMapping("buy-policies")
    public ResponseEntity<BaseResponse> buyPolicies(@RequestBody CustomerPolicyRequest customerPolicyRequest)
    {
        if(customerPolicyRequest==null) {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("fields Should not be null");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return customerPolicyService.customerBuyPolicies(customerPolicyRequest);

    }
}


