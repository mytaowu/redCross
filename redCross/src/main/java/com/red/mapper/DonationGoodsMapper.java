package com.red.mapper;

import com.red.entity.DonationGoods;
import com.red.entity.GoodDetailInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DonationGoodsMapper extends Mapper<DonationGoods> {

    void downStock(@Param("donationId") Integer donationId, @Param("count")Integer count);

    void upStock(@Param("donationId") Integer donationId, @Param("count")Integer count);

    List<DonationGoods> getDonationGoodList(@Param("keyword") String keyword);

    List<GoodDetailInfo> donationGoodDetailInfo(@Param("donationGoodId")Integer donationGoodId);
}