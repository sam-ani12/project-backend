package com.insurance.insurance.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private  String confirmPassword;
}
