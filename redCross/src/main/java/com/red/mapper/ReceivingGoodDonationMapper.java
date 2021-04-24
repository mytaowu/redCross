package com.red.mapper;

import com.red.entity.ReceivingGoodDonation;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ReceivingGoodDonationMapper extends Mapper<ReceivingGoodDonation> {
    List<ReceivingGoodDonation> receivingGoodDonationList(@Param("keyword") String keyword);
}