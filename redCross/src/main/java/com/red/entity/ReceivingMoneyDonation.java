package com.red.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ReceivingMoneyDonation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer receivingMoneyDonationId;

    private Integer receivingMoneyDonationAmount;

    private String receivingMoneyDonationCompany;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date receivingMoneyDonationTime;

    private String receivingMoneyDonationAdd;

    private String receivingMoneyDonationContact;

    private String receivingMoneyDonationTel;

    private String receivingMoneyDonationMail;

    private String receivingMoneyDonationImag;

    private String receivingMoneyDonationOtherExplain;

    public Integer getReceivingMoneyDonationId() {
        return receivingMoneyDonationId;
    }

    public void setReceivingMoneyDonationId(Integer receivingMoneyDonationId) {
        this.receivingMoneyDonationId = receivingMoneyDonationId;
    }

    public Integer getReceivingMoneyDonationAmount() {
        return receivingMoneyDonationAmount;
    }

    public void setReceivingMoneyDonationAmount(Integer receivingMoneyDonationAmount) {
        this.receivingMoneyDonationAmount = receivingMoneyDonationAmount;
    }

    public String getReceivingMoneyDonationCompany() {
        return receivingMoneyDonationCompany;
    }

    public void setReceivingMoneyDonationCompany(String receivingMoneyDonationCompany) {
        this.receivingMoneyDonationCompany = receivingMoneyDonationCompany == null ? null : receivingMoneyDonationCompany.trim();
    }

    public Date getReceivingMoneyDonationTime() {
        return receivingMoneyDonationTime;
    }

    public void setReceivingMoneyDonationTime(Date receivingMoneyDonationTime) {
        this.receivingMoneyDonationTime = receivingMoneyDonationTime;
    }

    public String getReceivingMoneyDonationAdd() {
        return receivingMoneyDonationAdd;
    }

    public void setReceivingMoneyDonationAdd(String receivingMoneyDonationAdd) {
        this.receivingMoneyDonationAdd = receivingMoneyDonationAdd == null ? null : receivingMoneyDonationAdd.trim();
    }

    public String getReceivingMoneyDonationContact() {
        return receivingMoneyDonationContact;
    }

    public void setReceivingMoneyDonationContact(String receivingMoneyDonationContact) {
        this.receivingMoneyDonationContact = receivingMoneyDonationContact == null ? null : receivingMoneyDonationContact.trim();
    }

    public String getReceivingMoneyDonationTel() {
        return receivingMoneyDonationTel;
    }

    public void setReceivingMoneyDonationTel(String receivingMoneyDonationTel) {
        this.receivingMoneyDonationTel = receivingMoneyDonationTel == null ? null : receivingMoneyDonationTel.trim();
    }

    public String getReceivingMoneyDonationMail() {
        return receivingMoneyDonationMail;
    }

    public void setReceivingMoneyDonationMail(String receivingMoneyDonationMail) {
        this.receivingMoneyDonationMail = receivingMoneyDonationMail == null ? null : receivingMoneyDonationMail.trim();
    }

    public String getReceivingMoneyDonationImag() {
        return receivingMoneyDonationImag;
    }

    public void setReceivingMoneyDonationImag(String receivingMoneyDonationImag) {
        this.receivingMoneyDonationImag = receivingMoneyDonationImag == null ? null : receivingMoneyDonationImag.trim();
    }

    public String getReceivingMoneyDonationOtherExplain() {
        return receivingMoneyDonationOtherExplain;
    }

    public void setReceivingMoneyDonationOtherExplain(String receivingMoneyDonationOtherExplain) {
        this.receivingMoneyDonationOtherExplain = receivingMoneyDonationOtherExplain == null ? null : receivingMoneyDonationOtherExplain.trim();
    }
}