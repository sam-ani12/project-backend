package com.insurance.insurance.serviceImpl;

import com.insurance.insurance.dto.*;
import com.insurance.insurance.entity.Customer;
import com.insurance.insurance.entity.CustomerPolicyDetail;
import com.insurance.insurance.entity.PoliciesDetails;
import com.insurance.insurance.repository.CustomerPolicyDAO;
import com.insurance.insurance.service.CustomerPolicyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerPolicyServiceImpl implements CustomerPolicyService {

    @Autowired
    private CustomerPolicyDAO customerPolicyDAO;

    @Override
    public ResponseEntity<BaseResponse> insertCustomerPolicies(CustomerPolicyRequest customerPolicyRequest) {
        CustomerPolicyDetail cp = new CustomerPolicyDetail();
        BaseResponse baseResponse = new BaseResponse();
        cp.setCustomerId(customerPolicyRequest.getCustomerId());
        cp.setPoliciesId(customerPolicyRequest.getPoliciesId());

        customerPolicyDAO.save(cp);
        baseResponse.setMessage("Successfully added");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        baseResponse.setResponse(cp);
        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<BaseResponse> fetchCustomerPolicyInformation(int customerId) {
        List<CustomerPolicyDetail> policesListFromDb = (List<CustomerPolicyDetail>) customerPolicyDAO.fetchPoliciesById(customerId);
        List<CustomerPolicyRequest> policiesList = new ArrayList<>();
        BaseResponse baseResponse = new BaseResponse();
        CustomerPolicyResponseDTO finalResponse = new CustomerPolicyResponseDTO();
        if (policesListFromDb.isEmpty()) {
            baseResponse.setMessage("Soryyy!!! You have not bought any Policies");
            baseResponse.setHttpStatus(HttpStatus.NOT_FOUND);
            baseResponse.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.NOT_FOUND);
        }

        for (CustomerPolicyDetail customerPolicyDetail : policesListFromDb) {
            CustomerPolicyRequest policiesObject = new CustomerPolicyRequest();
//policiesObject.set("The Policy Name: "+policiesDetails.getName());
//policiesObject.setAmountCover(policiesDetails.getAmountCover());
//            policiesObject.setPremiumAmount(policiesDetails.getPremiumAmount());
//            policiesObject.setAccommodation(policiesDetails.getAccommodation());
//            policiesObject.setHealthCheckup(policiesDetails.getHealthCheckup());
//            policiesObject.setCoverage(policiesDetails.getCoverage());
//            policiesObject.setDiscountPremium(policiesDetails.getDiscountPremium());
//            policiesObject.setClaim(policiesDetails.getClaim());


            policiesObject.setPoliciesId(customerPolicyDetail.getPoliciesId());
            policiesObject.setCustomerId(customerPolicyDetail.getCustomerId());
               policiesObject.setActive(customerPolicyDetail.isActive());
            policiesList.add(policiesObject);
        }
        baseResponse.setMessage("These are the Given Policies");
        finalResponse.setCustomerPolicyRequestList(policiesList);
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        baseResponse.setResponse(finalResponse);
        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse> customerBuyPolicies(CustomerPolicyRequest customerPolicyRequest) {
        CustomerPolicyDetail cust = new CustomerPolicyDetail();
        BaseResponse baseResponse = new BaseResponse();
        cust.setPoliciesId(customerPolicyRequest.getPoliciesId());
        cust.setCustomerId(customerPolicyRequest.getCustomerId());

        cust.setActive(customerPolicyRequest.isActive());
        customerPolicyDAO.save(cust);
        baseResponse.setMessage("Successfully Inserted Customer Policy Information");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
    }



    }



