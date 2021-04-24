package com.red.config.thread;

import com.red.entity.TotalInfoDetail;
import com.red.mapper.AdminInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;

import java.util.concurrent.CountDownLatch;

/**
 * @author: TMingYi
 * @date: 2020/9/6 9:42
 * 多线程的抽象类。
 */
public abstract class TotalInfoDetailAbstractTread extends Thread {

    protected CountDownLatch countDownLatch;

    protected TotalInfoDetail totalInfoDetail;

    protected AdminInfoMapper adminInfoMapper;

    public TotalInfoDetailAbstractTread(
            CountDownLatch countDownLatch,
            TotalInfoDetail totalInfoDetail,
            AdminInfoMapper adminInfoMapper) {
        this.countDownLatch = countDownLatch;
        this.totalInfoDetail = totalInfoDetail;
        this.adminInfoMapper = adminInfoMapper;
    }

    protected void countDownLatchDown(){
        if (countDownLatch != null){
            countDownLatch.countDown();
        }
    }

}
