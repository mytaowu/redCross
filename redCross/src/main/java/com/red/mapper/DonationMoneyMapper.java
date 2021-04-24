package com.red.mapper;

import com.red.entity.DonationMoney;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DonationMoneyMapper extends Mapper<DonationMoney> {
    List<DonationMoney> getDonationMoneyList(@Param("keyword")  String keyword);
}