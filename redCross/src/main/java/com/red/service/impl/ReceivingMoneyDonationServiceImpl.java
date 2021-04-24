package com.red.service.impl;

import com.github.pagehelper.PageHelper;
import com.red.entity.ReceivingMoneyDonation;
import com.red.mapper.ReceivingMoneyDonationMapper;
import com.red.service.ReceivingMoneyDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: TMingYi
 * @date: 2020/8/30 18:18
 */
@Service
public class ReceivingMoneyDonationServiceImpl implements ReceivingMoneyDonationService {

    @Autowired
    private ReceivingMoneyDonationMapper receivingMoneyDonationMapper;

    @Override
    public List<ReceivingMoneyDonation> receivingMoneyDonationList(String pageSize, String pageNo, String keyWord) {
        PageHelper.startPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        return receivingMoneyDonationMapper.seachReceivingMoneyDonationList(keyWord);
    }

    @Override
    public Integer receivingMoneyDonationListCount() {
        return receivingMoneyDonationMapper.selectAll().size();
    }


    @Override
    public void addReceivingMoneyDonation(ReceivingMoneyDonation receivingGoodDonation) {
        // 时间后端生成;
        receivingGoodDonation.setReceivingMoneyDonationTime(new Date());
        receivingMoneyDonationMapper.insert(receivingGoodDonation);
    }

    @Override
    public void updateReceivingMoneyDonation(ReceivingMoneyDonation receivingGoodDonation) {
        // 时间后端生成;
        receivingGoodDonation.setReceivingMoneyDonationTime(new Date());
        receivingMoneyDonationMapper.updateByPrimaryKey(receivingGoodDonation);
    }

    @Override
    public void deleteReceivingMoneyDonation(Integer receivingMoneyDonationId) {
        ReceivingMoneyDonation donation = new ReceivingMoneyDonation();
        donation.setReceivingMoneyDonationId(receivingMoneyDonationId);
        receivingMoneyDonationMapper.deleteByPrimaryKey(donation);
    }
}
