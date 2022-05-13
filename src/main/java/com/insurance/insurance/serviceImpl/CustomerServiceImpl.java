package com.insurance.insurance.serviceImpl;

import com.insurance.insurance.dto.BaseResponse;
import com.insurance.insurance.dto.CustomerRequest;
import com.insurance.insurance.dto.LoginRequest;
import com.insurance.insurance.entity.Customer;
import com.insurance.insurance.repository.CustomerDAO;
import com.insurance.insurance.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public ResponseEntity<BaseResponse> customerRegistration(CustomerRequest customerRequest) {

        Customer cust = new Customer();
        BaseResponse baseResponse = new BaseResponse();
        cust.setFirstName(customerRequest.getFirstName());
        cust.setLastName(customerRequest.getLastName());
        cust.setEmail(customerRequest.getEmail());
        cust.setPhoneNumber(customerRequest.getPhoneNumber());
        cust.setPassword(customerRequest.getPassword());
        cust.setConfirmPassword(customerRequest.getConfirmPassword());
        customerDAO.save(cust);
        baseResponse.setMessage(" Customer Sucessfully  Registred");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
//        baseResponse.setResponse(cust);
        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<BaseResponse> customerLogin(LoginRequest loginRequest) {

        Optional<Customer> customer = Optional.ofNullable(customerDAO.login(loginRequest.getEmail(), loginRequest.getPassword()));
        BaseResponse baseResponse = new BaseResponse();
        if (!customer.isPresent()) {
            baseResponse.setMessage("Invalid Username and Password");
            baseResponse.setHttpStatus(HttpStatus.NOT_FOUND);
            baseResponse.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.NOT_FOUND);
        }
        baseResponse.setMessage("Successfully Login");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        baseResponse.setResponse(customer);
        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
    }
}

