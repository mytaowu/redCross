package com.red.service;

import com.red.entity.DonationGoods;
import com.red.entity.GoodDetailInfo;

import java.util.List;

/**
 * @author: TMingYi
 * @date: 2020/8/30 22:31
 */
public interface DonationGoodService {
    List<DonationGoods> getDonationGoodList(String pageSize, String pageNo, String keyWord);

    Integer getDonationGoodListCount();

    void addDonationGood(DonationGoods donationGood);

    void updateDonationGood(DonationGoods donationGood);

    void deleteByDonationGoodId(Integer donationGoodId);

    List<DonationGoods> getAll();

    List<GoodDetailInfo> donationGoodDetailInfo(Integer donationGoodId);
}
