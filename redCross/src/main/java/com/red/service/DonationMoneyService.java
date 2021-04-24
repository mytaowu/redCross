package com.red.service;

import com.red.entity.DonationMoney;

import java.util.List;

/**
 * @author: TMingYi
 * @date: 2020/8/30 22:36
 */
public interface DonationMoneyService {
    List<DonationMoney> getDonationMoneyList(String pageSize, String pageNo, String keyWord);

    Integer getDonationMoneyListCount();

    void addDonationMoney(DonationMoney donationMoney);

    void updateDonationMoney(DonationMoney donationMoney);

    void deleteByDonationMoneyId(Integer donationMoneyId);
}
