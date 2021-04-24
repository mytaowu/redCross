package com.red.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class DonationPurpose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer donationPurposeId;

    private String donationPurposeName;

    public Integer getDonationPurposeId() {
        return donationPurposeId;
    }

    public void setDonationPurposeId(Integer donationPurposeId) {
        this.donationPurposeId = donationPurposeId;
    }

    public String getDonationPurposeName() {
        return donationPurposeName;
    }

    public void setDonationPurposeName(String donationPurposeName) {
        this.donationPurposeName = donationPurposeName == null ? null : donationPurposeName.trim();
    }
}