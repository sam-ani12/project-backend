package com.insurance.insurance.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CustomerPolicyResponseDTO {

    private List<CustomerPolicyRequest> customerPolicyRequestList;
}
