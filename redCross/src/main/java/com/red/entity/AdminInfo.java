package com.red.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class AdminInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminInfoId;

    private String adminInfoName;

    private BigDecimal adminInfoTel;

    private String adminInfoLoginName;

    private String adminInfoPass;

    private Short adminProhibit;

    private Short isTopAdmin;

    public Integer getAdminInfoId() {
        return adminInfoId;
    }

    public void setAdminInfoId(Integer adminInfoId) {
        this.adminInfoId = adminInfoId;
    }

    public String getAdminInfoName() {
        return adminInfoName;
    }

    public void setAdminInfoName(String adminInfoName) {
        this.adminInfoName = adminInfoName;
    }

    public BigDecimal getAdminInfoTel() {
        return adminInfoTel;
    }

    public void setAdminInfoTel(BigDecimal adminInfoTel) {
        this.adminInfoTel = adminInfoTel;
    }

    public String getAdminInfoLoginName() {
        return adminInfoLoginName;
    }

    public void setAdminInfoLoginName(String adminInfoLoginName) {
        this.adminInfoLoginName = adminInfoLoginName == null ? null : adminInfoLoginName.trim();
    }

    public String getAdminInfoPass() {
        return adminInfoPass;
    }

    public void setAdminInfoPass(String adminInfoPass) {
        this.adminInfoPass = adminInfoPass == null ? null : adminInfoPass.trim();
    }

    public Short getAdminProhibit() {
        return adminProhibit;
    }

    public void setAdminProhibit(Short adminProhibit) {
        this.adminProhibit = adminProhibit;
    }

    public Short getIsTopAdmin() {
        return isTopAdmin;
    }

    public void setIsTopAdmin(Short isTopAdmin) {
        this.isTopAdmin = isTopAdmin;
    }
}