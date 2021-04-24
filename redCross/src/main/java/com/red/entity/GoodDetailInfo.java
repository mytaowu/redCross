package com.red.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: TMingYi
 * @date: 2020/9/3 15:28
 */
// 流水信息;
public class GoodDetailInfo implements Serializable {

    // 接收方数据;
    private String donationCompany;

    private String donationGood;

    private String donationContact;

    private String donationTel;

    // 流水方数据
    private String receivingGoodDonationCompany;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date receivingGoodDonationTime;

    private String receivingGoodDonationContact;

    private String receivingGoodDonationTel;

    private Integer receivingGoodDonationGoodCount;

    public String getDonationCompany() {
        return donationCompany;
    }

    public void setDonationCompany(String donationCompany) {
        this.donationCompany = donationCompany;
    }

    public String getDonationGood() {
        return donationGood;
    }

    public void setDonationGood(String donationGood) {
        this.donationGood = donationGood;
    }

    public String getDonationContact() {
        return donationContact;
    }

    public void setDonationContact(String donationContact) {
        this.donationContact = donationContact;
    }

    public String getDonationTel() {
        return donationTel;
    }

    public void setDonationTel(String donationTel) {
        this.donationTel = donationTel;
    }

    public String getReceivingGoodDonationCompany() {
        return receivingGoodDonationCompany;
    }

    public void setReceivingGoodDonationCompany(String receivingGoodDonationCompany) {
        this.receivingGoodDonationCompany = receivingGoodDonationCompany;
    }

    public Date getReceivingGoodDonationTime() {
        return receivingGoodDonationTime;
    }

    public void setReceivingGoodDonationTime(Date receivingGoodDonationTime) {
        this.receivingGoodDonationTime = receivingGoodDonationTime;
    }

    public String getReceivingGoodDonationContact() {
        return receivingGoodDonationContact;
    }

    public void setReceivingGoodDonationContact(String receivingGoodDonationContact) {
        this.receivingGoodDonationContact = receivingGoodDonationContact;
    }

    public String getReceivingGoodDonationTel() {
        return receivingGoodDonationTel;
    }

    public void setReceivingGoodDonationTel(String receivingGoodDonationTel) {
        this.receivingGoodDonationTel = receivingGoodDonationTel;
    }

    public Integer getReceivingGoodDonationGoodCount() {
        return receivingGoodDonationGoodCount;
    }

    public void setReceivingGoodDonationGoodCount(Integer receivingGoodDonationGoodCount) {
        this.receivingGoodDonationGoodCount = receivingGoodDonationGoodCount;
    }
}
