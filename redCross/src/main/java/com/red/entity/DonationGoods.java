package com.red.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class DonationGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer donationId;

    private String donationCompany;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date donationTime;

    private String donationAdd;

    private String donationContact;

    private String donationTel;

    private String donationMail;

    private String donationGood;

    private String donationGoodModel;

    private String donationGoodUnit;

    private Integer donationGoodCount;

    private Integer donationGoodTotalValue;

    private Integer donationPurposeId;

    private Integer donationTypeId;

    private Short donationIsSecrecy;

    private Short donationIsLargeMoney;

    private String donationOtherExplain;

    private Integer donationGoodSurplusCount;

    public Integer getDonationId() {
        return donationId;
    }

    public void setDonationId(Integer donationId) {
        this.donationId = donationId;
    }

    public String getDonationCompany() {
        return donationCompany;
    }

    public void setDonationCompany(String donationCompany) {
        this.donationCompany = donationCompany == null ? null : donationCompany.trim();
    }

    public Date getDonationTime() {
        return donationTime;
    }

    public void setDonationTime(Date donationTime) {
        this.donationTime = donationTime;
    }

    public String getDonationAdd() {
        return donationAdd;
    }

    public void setDonationAdd(String donationAdd) {
        this.donationAdd = donationAdd == null ? null : donationAdd.trim();
    }

    public String getDonationContact() {
        return donationContact;
    }

    public void setDonationContact(String donationContact) {
        this.donationContact = donationContact == null ? null : donationContact.trim();
    }

    public String getDonationTel() {
        return donationTel;
    }

    public void setDonationTel(String donationTel) {
        this.donationTel = donationTel == null ? null : donationTel.trim();
    }

    public String getDonationMail() {
        return donationMail;
    }

    public void setDonationMail(String donationMail) {
        this.donationMail = donationMail == null ? null : donationMail.trim();
    }

    public String getDonationGood() {
        return donationGood;
    }

    public void setDonationGood(String donationGood) {
        this.donationGood = donationGood == null ? null : donationGood.trim();
    }

    public String getDonationGoodModel() {
        return donationGoodModel;
    }

    public void setDonationGoodModel(String donationGoodModel) {
        this.donationGoodModel = donationGoodModel == null ? null : donationGoodModel.trim();
    }

    public String getDonationGoodUnit() {
        return donationGoodUnit;
    }

    public void setDonationGoodUnit(String donationGoodUnit) {
        this.donationGoodUnit = donationGoodUnit == null ? null : donationGoodUnit.trim();
    }

    public Integer getDonationGoodCount() {
        return donationGoodCount;
    }

    public void setDonationGoodCount(Integer donationGoodCount) {
        this.donationGoodCount = donationGoodCount;
    }

    public Integer getDonationGoodTotalValue() {
        return donationGoodTotalValue;
    }

    public void setDonationGoodTotalValue(Integer donationGoodTotalValue) {
        this.donationGoodTotalValue = donationGoodTotalValue;
    }

    public Integer getDonationPurposeId() {
        return donationPurposeId;
    }

    public void setDonationPurposeId(Integer donationPurposeId) {
        this.donationPurposeId = donationPurposeId;
    }

    public Integer getDonationTypeId() {
        return donationTypeId;
    }

    public void setDonationTypeId(Integer donationTypeId) {
        this.donationTypeId = donationTypeId;
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

    public Integer getDonationGoodSurplusCount() {
        return donationGoodSurplusCount;
    }

    public void setDonationGoodSurplusCount(Integer donationGoodSurplusCount) {
        this.donationGoodSurplusCount = donationGoodSurplusCount;
    }
}