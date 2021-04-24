package com.red.service.impl;

import com.github.pagehelper.PageHelper;
import com.red.config.myconst.ProjectParames;
import com.red.entity.DonationGoods;
import com.red.entity.DonationMoney;
import com.red.entity.GoodDetailInfo;
import com.red.mapper.DonationGoodsMapper;
import com.red.mapper.DonationMoneyMapper;
import com.red.service.DonationGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: TMingYi
 * @date: 2020/8/30 22:31
 */
@Service
public class DonationGoodServiceImple implements DonationGoodService {

    @Autowired
    private DonationGoodsMapper donationGoodsMapper;

    @Override
    public List<DonationGoods> getDonationGoodList(String pageSize, String pageNo, String keyWord) {
        PageHelper.startPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        return donationGoodsMapper.getDonationGoodList(keyWord);
    }

    @Override
    public Integer getDonationGoodListCount() {
        return donationGoodsMapper.selectAll().size();
    }

    @Override
    public void addDonationGood(DonationGoods donationGood) {
        // 设置初始容量的等于剩余容量;
        donationGood.setDonationGoodSurplusCount(donationGood.getDonationGoodCount());
        // 初始化基础的数据;
        invokeBaseDateForDonationGood(donationGood);
        donationGoodsMapper.insert(donationGood);
    }

    @Override
    public void updateDonationGood(DonationGoods donationGood) {
        invokeBaseDateForDonationGood(donationGood);
        donationGoodsMapper.updateByPrimaryKey(donationGood);
    }

    @Override
    public void deleteByDonationGoodId(Integer donationGoodId) {
        DonationGoods goods = new DonationGoods();
        goods.setDonationId(donationGoodId);
        donationGoodsMapper.deleteByPrimaryKey(goods);
    }

    @Override
    public List<DonationGoods> getAll() {
        return donationGoodsMapper.selectAll();
    }

    @Override
    public List<GoodDetailInfo> donationGoodDetailInfo(Integer donationGoodId) {
        return donationGoodsMapper.donationGoodDetailInfo(donationGoodId);
    }

    // 初始化基础的数据;
    private void invokeBaseDateForDonationGood(DonationGoods donationGood) {
        // 设置时间
        donationGood.setDonationTime(new Date());
        // 判断是为大金额/小金额
        if (donationGood.getDonationGoodTotalValue() > ProjectParames.LARGE_MONEY_DIV) {
            // 表示为大金额;
            donationGood.setDonationIsLargeMoney(Short.valueOf(String.valueOf(1)));
        } else {
            // 表示为小金额
            donationGood.setDonationIsLargeMoney(Short.valueOf(String.valueOf(0)));
        }
    }
}
