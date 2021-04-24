package com.red.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;

/**
 * @author: TMingYi
 * @date: 2020/9/6 9:19
 */
@ApiModel("汇总信息")
public class TotalInfoDetail {

    @ApiParam("总共的接收捐物数")
    private Integer totalDonationGoodsCount;

    @ApiParam("总共的接收捐物价值金额")
    private Integer totalDonationGoodsMoney;

    @ApiParam("总共的接收捐款金额")
    private Integer totalDonationMoney;

    @ApiParam("总共资助单位数量")
    private Integer totalReceivingDonationGoodsCount;

    @ApiParam("总共资助金钱单位")
    private Integer totalRecevingDonationMoneyCount;

    @ApiParam("现存资金")
    private Integer totalMoney;

    public Integer getTotalDonationGoodsCount() {
        return totalDonationGoodsCount;
    }

    public void setTotalDonationGoodsCount(Integer totalDonationGoodsCount) {
        this.totalDonationGoodsCount = totalDonationGoodsCount;
    }

    public Integer getTotalDonationGoodsMoney() {
        return totalDonationGoodsMoney;
    }

    public void setTotalDonationGoodsMoney(Integer totalDonationGoodsMoney) {
        this.totalDonationGoodsMoney = totalDonationGoodsMoney;
    }

    public Integer getTotalDonationMoney() {
        return totalDonationMoney;
    }

    public void setTotalDonationMoney(Integer totalDonationMoney) {
        this.totalDonationMoney = totalDonationMoney;
    }

    public Integer getTotalReceivingDonationGoodsCount() {
        return totalReceivingDonationGoodsCount;
    }

    public void setTotalReceivingDonationGoodsCount(Integer totalReceivingDonationGoodsCount) {
        this.totalReceivingDonationGoodsCount = totalReceivingDonationGoodsCount;
    }

    public Integer getTotalRecevingDonationMoneyCount() {
        return totalRecevingDonationMoneyCount;
    }

    public void setTotalRecevingDonationMoneyCount(Integer totalRecevingDonationMoneyCount) {
        this.totalRecevingDonationMoneyCount = totalRecevingDonationMoneyCount;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }
}
