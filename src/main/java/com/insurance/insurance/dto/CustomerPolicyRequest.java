package com.insurance.insurance.dto;

import com.insurance.insurance.entity.CustomerPolicyDetail;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CustomerPolicyRequest {

    private int customerId;
    private int policiesId;
    private boolean isActive;
    private List<CustomerPolicyDetail> customerPolicyDetailList;
}
