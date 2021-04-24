package com.red.service;

import com.red.entity.ReceivingMoneyDonation;

import java.util.List;

/**
 * @author: TMingYi
 * @date: 2020/8/30 18:18
 */
public interface ReceivingMoneyDonationService {


    List<ReceivingMoneyDonation> receivingMoneyDonationList(String pageSize, String pageNo, String keyWord);

    Integer receivingMoneyDonationListCount();

    void addReceivingMoneyDonation(ReceivingMoneyDonation receivingGoodDonation);

    void updateReceivingMoneyDonation(ReceivingMoneyDonation receivingGoodDonation);

    void deleteReceivingMoneyDonation(Integer receivingMoneyDonationId);
}
