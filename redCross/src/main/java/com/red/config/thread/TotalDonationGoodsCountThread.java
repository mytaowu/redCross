package com.red.config.thread;

import com.red.entity.TotalInfoDetail;
import com.red.mapper.AdminInfoMapper;

import java.util.concurrent.CountDownLatch;

/**
 * @author: TMingYi
 * @date: 2020/9/6 9:45
 */
public class TotalDonationGoodsCountThread extends TotalInfoDetailAbstractTread {
    public TotalDonationGoodsCountThread(
            CountDownLatch countDownLatch,
            TotalInfoDetail totalInfoDetail,
            AdminInfoMapper adminInfoMapper){
        super(countDownLatch,totalInfoDetail,adminInfoMapper);
    }
    @Override
    public void run() {
        totalInfoDetail.setTotalDonationGoodsCount(adminInfoMapper.getTotalDonationGoodsCount());
        countDownLatchDown();
    }
}
