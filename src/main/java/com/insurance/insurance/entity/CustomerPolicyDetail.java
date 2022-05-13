package com.insurance.insurance.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name="customer_policies")
public class CustomerPolicyDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="customer_id")
    private int customerId;

    @Column(name="policies_id")
    private int policiesId;

    @Column(name = "is_active")
    private boolean isActive;
}
