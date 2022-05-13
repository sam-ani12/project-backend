package com.insurance.insurance.controller;

import com.insurance.insurance.dto.BaseResponse;
import com.insurance.insurance.dto.PolicyDetailsRequest;
import com.insurance.insurance.service.PoliciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
@RestController
@CrossOrigin(origins = "*")
public class PolicesController{
    @Autowired
    private PoliciesService policiesService;

    @GetMapping("policy")
    public ResponseEntity<BaseResponse> customerPolicyRequest() throws IOException {
//        if (policyDetailsRequest == null) {
//            BaseResponse baseResponse = new BaseResponse();
//            baseResponse.setMessage("Credentials Should not be null");
//            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
//            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
//            return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.BAD_REQUEST);
//
//        }
        return policiesService.displayPolicyList();
    }
}

