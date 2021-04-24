package com.red.mapper;

import com.red.entity.ReceivingMoneyDonation;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ReceivingMoneyDonationMapper extends Mapper<ReceivingMoneyDonation> {
    List<ReceivingMoneyDonation> seachReceivingMoneyDonationList( @Param("keyword") String keyword);
}