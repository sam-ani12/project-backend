package com.insurance.insurance.service;

import com.insurance.insurance.dto.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface PoliciesService{

    ResponseEntity<BaseResponse> displayPolicyList() throws IOException;
}
