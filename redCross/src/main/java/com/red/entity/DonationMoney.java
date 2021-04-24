package com.red.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class DonationMoney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer donationMoneyId;

    private String donationMoneyCompany;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date donationMoneyTime;

    private String donationMoneyAdd;

    private String donationMoneyContact;

    private String donationMoneyTel;

    private String donationMoneyMail;

    private Integer donationMoneyAmount;

    private Short donationIsSecrecy;

    private Short donationIsLargeMoney;

    private String donationOtherExplain;

    public Integer getDonationMoneyId() {
        return donationMoneyId;
    }

    public void setDonationMoneyId(Integer donationMoneyId) {
        this.donationMoneyId = donationMoneyId;
    }

    public String getDonationMoneyCompany() {
        return donationMoneyCompany;
    }

    public void setDonationMoneyCompany(String donationMoneyCompany) {
        this.donationMoneyCompany = donationMoneyCompany == null ? null : donationMoneyCompany.trim();
    }

    public Date getDonationMoneyTime() {
        return donationMoneyTime;
    }

    public void setDonationMoneyTime(Date donationMoneyTime) {
        this.donationMoneyTime = donationMoneyTime;
    }

    public String getDonationMoneyAdd() {
        return donationMoneyAdd;
    }

    public void setDonationMoneyAdd(String donationMoneyAdd) {
        this.donationMoneyAdd = donationMoneyAdd == null ? null : donationMoneyAdd.trim();
    }

    public String getDonationMoneyContact() {
        return donationMoneyContact;
    }

    public void setDonationMoneyContact(String donationMoneyContact) {
        this.donationMoneyContact = donationMoneyContact == null ? null : donationMoneyContact.trim();
    }

    public String getDonationMoneyTel() {
        return donationMoneyTel;
    }

    public void setDonationMoneyTel(String donationMoneyTel) {
        this.donationMoneyTel = donationMoneyTel == null ? null : donationMoneyTel.trim();
    }

    public String getDonationMoneyMail() {
        return donationMoneyMail;
    }

    public void setDonationMoneyMail(String donationMoneyMail) {
        this.donationMoneyMail = donationMoneyMail == null ? null : donationMoneyMail.trim();
    }

    public Integer getDonationMoneyAmount() {
        return donationMoneyAmount;
    }

    public void setDonationMoneyAmount(Integer donationMoneyAmount) {
        this.donationMoneyAmount = donationMoneyAmount;
    }

    public Short getDonationIsSecrecy() {
        return donationIsSecrecy;
    }

    public void setDonationIsSecrecy(Short donationIsSecrecy) {
        this.donationIsSecrecy = donationIsSecrecy;
    }

    public Short getDonationIsLargeMoney() {
        return donationIsLargeMoney;
    }

    public void setDonationIsLargeMoney(Short donationIsLargeMoney) {
        this.donationIsLargeMoney = donationIsLargeMoney;
    }

    public String getDonationOtherExplain() {
        return donationOtherExplain;
    }

    public void setDonationOtherExplain(String donationOtherExplain) {
        this.donationOtherExplain = donationOtherExplain == null ? null : donationOtherExplain.trim();
    }
}