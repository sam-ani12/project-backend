package com.insurance.insurance.dto;

import com.insurance.insurance.entity.PoliciesDetails;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.File;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PolicyDetailsRequest {

    private File policyImage;
    private String name;
    private int AmountCover;
    private int premiumAmount;
    private String accommodation;
    private String healthCheckup;
    private String coverage;
    private int discountPremium;
    private int claim;
    private boolean isActive;

}
