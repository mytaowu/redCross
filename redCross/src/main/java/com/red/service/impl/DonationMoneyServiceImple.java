package com.red.service.impl;

import com.github.pagehelper.PageHelper;
import com.red.config.myconst.ProjectParames;
import com.red.config.myconst.UserContst;
import com.red.entity.DonationMoney;
import com.red.mapper.DonationMoneyMapper;
import com.red.service.DonationMoneyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: TMingYi
 * @date: 2020/8/30 22:36
 */

@Service
public class DonationMoneyServiceImple implements DonationMoneyService {

    @Autowired
    private DonationMoneyMapper donationMoneyMapper;

    @Override
    public List<DonationMoney> getDonationMoneyList(String pageSize, String pageNo, String keyWord) {
        PageHelper.startPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        return donationMoneyMapper.getDonationMoneyList(keyWord);
    }

    @Override
    public Integer getDonationMoneyListCount() {
        return donationMoneyMapper.selectAll().size();
    }

    @Override
    public void addDonationMoney(DonationMoney donationMoney) {
        // 设置时间
        invokeBaseDateForDonationMoney(donationMoney);
        // 存入数据库;
        donationMoneyMapper.insert(donationMoney);
    }

    @Override
    public void updateDonationMoney(DonationMoney donationMoney) {
        invokeBaseDateForDonationMoney(donationMoney);
        // 存入数据库;
        donationMoneyMapper.updateByPrimaryKey(donationMoney);
    }



    @Override
    public void deleteByDonationMoneyId(Integer donationMoneyId) {
        DonationMoney money = new DonationMoney();
        money.setDonationMoneyId(donationMoneyId);
        donationMoneyMapper.deleteByPrimaryKey(money);
    }

    // 初始化基础的数据;
    private void invokeBaseDateForDonationMoney(DonationMoney donationMoney) {
        // 设置时间
        donationMoney.setDonationMoneyTime(new Date());
        // 判断是为大金额/小金额
        if (donationMoney.getDonationMoneyAmount() > ProjectParames.LARGE_MONEY_DIV) {
            // 表示为大金额;
            donationMoney.setDonationIsLargeMoney(Short.valueOf(String.valueOf(1)));
        } else {
            // 表示为小金额
            donationMoney.setDonationIsLargeMoney(Short.valueOf(String.valueOf(0)));
        }
    }
}
