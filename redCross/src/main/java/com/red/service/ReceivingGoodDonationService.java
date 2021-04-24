package com.red.service;

import com.red.entity.ReceivingGoodDonation;

import java.util.List;

/**
 * @author: TMingYi
 * @date: 2020/8/30 18:48
 */
public interface ReceivingGoodDonationService {
    List<ReceivingGoodDonation> receivingGoodDonationList(String pageSize, String pageNo, String keyWord);

    Integer receivingGoodDonationListCount();

    void addReceivingGoodDonation(ReceivingGoodDonation receivingGoodDonation);

    void updateReceivingGoodDonation(ReceivingGoodDonation receivingGoodDonation);

    void deleteReceivingGoodDonation(Integer receivingGoodDonationId);
}
