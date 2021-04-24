package com.red.service.impl;

import com.github.pagehelper.PageHelper;
import com.red.entity.ReceivingGoodDonation;
import com.red.mapper.DonationGoodsMapper;
import com.red.mapper.ReceivingGoodDonationMapper;
import com.red.service.ReceivingGoodDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.StyledEditorKit;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author: TMingYi
 * @date: 2020/8/30 18:48
 */
@Service
public class ReceivingGoodDonationServiceImpl implements ReceivingGoodDonationService {

    @Autowired
    private ReceivingGoodDonationMapper receivingGoodDonationMapper;

    @Autowired
    private DonationGoodsMapper donationGoodsMapper;


    @Override
    public List<ReceivingGoodDonation> receivingGoodDonationList(String pageSize, String pageNo, String keyWord) {
        PageHelper.startPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        return receivingGoodDonationMapper.receivingGoodDonationList(keyWord);
    }

    @Override
    public Integer receivingGoodDonationListCount() {
        return receivingGoodDonationMapper.selectAll().size();
    }

    @Override
    @Transactional
    public synchronized void addReceivingGoodDonation(ReceivingGoodDonation receivingGoodDonation) {
        // 设置时间;
        receivingGoodDonation.setReceivingGoodDonationTime(new Date());
        // 减少库存;
        donationGoodsMapper.downStock(receivingGoodDonation.getDonationId(),receivingGoodDonation.getReceivingGoodDonationGoodCount());
        // 添加入数据库;
        receivingGoodDonationMapper.insert(receivingGoodDonation);
    }

    @Override
    @Transactional
    public void updateReceivingGoodDonation(ReceivingGoodDonation receivingGoodDonation) {
        // 设置时间;
        receivingGoodDonation.setReceivingGoodDonationTime(new Date());
        // 查询出原库存;
        ReceivingGoodDonation orgin = new ReceivingGoodDonation();
        orgin.setReceivingGoodDonationId(receivingGoodDonation.getReceivingGoodDonationId());
        orgin = receivingGoodDonationMapper.selectOne(orgin);
        // 判断库存,这里极有可能抛异常;
        Integer diff = orgin.getReceivingGoodDonationGoodCount() - receivingGoodDonation.getReceivingGoodDonationGoodCount();
        boolean isCommonGood = Objects.equals(orgin.getDonationId(),receivingGoodDonation.getDonationId());
        if (isCommonGood && diff > 0){
            donationGoodsMapper.upStock(receivingGoodDonation.getDonationId(), diff);
        }else if (isCommonGood && diff < 0){
            donationGoodsMapper.downStock(receivingGoodDonation.getDonationId(),Math.abs(diff));
        }else if (!isCommonGood){
            donationGoodsMapper.upStock(orgin.getDonationId(), orgin.getReceivingGoodDonationGoodCount());
            donationGoodsMapper.downStock(receivingGoodDonation.getDonationId(),receivingGoodDonation.getReceivingGoodDonationGoodCount());
        }
        // 添加入数据库;
        receivingGoodDonationMapper.updateByPrimaryKey(receivingGoodDonation);
    }

    @Override
    public void deleteReceivingGoodDonation(Integer receivingGoodDonationId) {
        // 查询出原库存;
        ReceivingGoodDonation orgin = new ReceivingGoodDonation();
        orgin.setReceivingGoodDonationId(receivingGoodDonationId);
        orgin = receivingGoodDonationMapper.selectOne(orgin);
        // 恢复库存;
        donationGoodsMapper.upStock(orgin.getDonationId(), orgin.getReceivingGoodDonationGoodCount());
        // 删除数据;
        receivingGoodDonationMapper.deleteByPrimaryKey(orgin);
    }
}
