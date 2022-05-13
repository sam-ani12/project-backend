package com.insurance.insurance.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name ="policies")
public class PoliciesDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "policies_id")
    private  int id;

    @Column(name = "name")
    private String name;

    @Column(name = "amount_cover")
    private int AmountCover;

    @Column(name = "premium_amount")
    private int premiumAmount;

    @Column(name = "accommodation")
    private String accommodation;

    @Column(name = "health_checkup")
    private String healthCheckup;

    @Column(name = "coverage")
    private String coverage;

    @Column(name = "discount_premium")
    private int discountPremium;

    @Column(name = "claim")
    private int claim;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name = "policy_image")
    private String policyImage;
}
