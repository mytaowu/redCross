package com.red.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class ReceivingGoodDonation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer receivingGoodDonationId;

    private Integer donationId;

    private String receivingGoodDonationCompany;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date receivingGoodDonationTime;

    private String receivingGoodDonationAdd;

    private String receivingGoodDonationContact;

    private String receivingGoodDonationTel;

    private String receivingGoodDonationMail;

    private Integer receivingGoodDonationGoodCount;

    private Integer receivingGoodDonationGoodTotalValue;

    private String receivingGoodDonationImag;

    private String receivingGoodDonationOtherExplain;

    private DonationGoods donationGoods;

    public DonationGoods getDonationGoods() {
        return donationGoods;
    }

    public void setDonationGoods(DonationGoods donationGoods) {
        this.donationGoods = donationGoods;
    }

    public Integer getReceivingGoodDonationId() {
        return receivingGoodDonationId;
    }

    public void setReceivingGoodDonationId(Integer receivingGoodDonationId) {
        this.receivingGoodDonationId = receivingGoodDonationId;
    }

    public Integer getDonationId() {
        return donationId;
    }

    public void setDonationId(Integer donationId) {
        this.donationId = donationId;
    }

    public String getReceivingGoodDonationCompany() {
        return receivingGoodDonationCompany;
    }

    public void setReceivingGoodDonationCompany(String receivingGoodDonationCompany) {
        this.receivingGoodDonationCompany = receivingGoodDonationCompany == null ? null : receivingGoodDonationCompany.trim();
    }

    public Date getReceivingGoodDonationTime() {
        return receivingGoodDonationTime;
    }

    public void setReceivingGoodDonationTime(Date receivingGoodDonationTime) {
        this.receivingGoodDonationTime = receivingGoodDonationTime;
    }

    public String getReceivingGoodDonationAdd() {
        return receivingGoodDonationAdd;
    }

    public void setReceivingGoodDonationAdd(String receivingGoodDonationAdd) {
        this.receivingGoodDonationAdd = receivingGoodDonationAdd == null ? null : receivingGoodDonationAdd.trim();
    }

    public String getReceivingGoodDonationContact() {
        return receivingGoodDonationContact;
    }

    public void setReceivingGoodDonationContact(String receivingGoodDonationContact) {
        this.receivingGoodDonationContact = receivingGoodDonationContact == null ? null : receivingGoodDonationContact.trim();
    }

    public String getReceivingGoodDonationTel() {
        return receivingGoodDonationTel;
    }

    public void setReceivingGoodDonationTel(String receivingGoodDonationTel) {
        this.receivingGoodDonationTel = receivingGoodDonationTel == null ? null : receivingGoodDonationTel.trim();
    }

    public String getReceivingGoodDonationMail() {
        return receivingGoodDonationMail;
    }

    public void setReceivingGoodDonationMail(String receivingGoodDonationMail) {
        this.receivingGoodDonationMail = receivingGoodDonationMail == null ? null : receivingGoodDonationMail.trim();
    }

    public Integer getReceivingGoodDonationGoodCount() {
        return receivingGoodDonationGoodCount;
    }

    public void setReceivingGoodDonationGoodCount(Integer receivingGoodDonationGoodCount) {
        this.receivingGoodDonationGoodCount = receivingGoodDonationGoodCount;
    }

    public Integer getReceivingGoodDonationGoodTotalValue() {
        return receivingGoodDonationGoodTotalValue;
    }

    public void setReceivingGoodDonationGoodTotalValue(Integer receivingGoodDonationGoodTotalValue) {
        this.receivingGoodDonationGoodTotalValue = receivingGoodDonationGoodTotalValue;
    }

    public String getReceivingGoodDonationImag() {
        return receivingGoodDonationImag;
    }

    public void setReceivingGoodDonationImag(String receivingGoodDonationImag) {
        this.receivingGoodDonationImag = receivingGoodDonationImag == null ? null : receivingGoodDonationImag.trim();
    }

    public String getReceivingGoodDonationOtherExplain() {
        return receivingGoodDonationOtherExplain;
    }

    public void setReceivingGoodDonationOtherExplain(String receivingGoodDonationOtherExplain) {
        this.receivingGoodDonationOtherExplain = receivingGoodDonationOtherExplain == null ? null : receivingGoodDonationOtherExplain.trim();
    }
}