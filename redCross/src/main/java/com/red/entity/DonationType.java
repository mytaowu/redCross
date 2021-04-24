package com.red.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class DonationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer donationTypeId;

    private String donationTypeName;

    public Integer getDonationTypeId() {
        return donationTypeId;
    }

    public void setDonationTypeId(Integer donationTypeId) {
        this.donationTypeId = donationTypeId;
    }

    public String getDonationTypeName() {
        return donationTypeName;
    }

    public void setDonationTypeName(String donationTypeName) {
        this.donationTypeName = donationTypeName == null ? null : donationTypeName.trim();
    }
}