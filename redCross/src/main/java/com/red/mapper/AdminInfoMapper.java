package com.red.mapper;

import com.red.entity.AdminInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AdminInfoMapper extends Mapper<AdminInfo> {
    void modifyUserPass(@Param("adminInfoLoginName")String adminInfoLoginName, @Param("password")String password);

    void resetUserPass(@Param("defaultPassword") String defaultPassword, @Param("adminInfoId")Integer adminInfoId);

    List<AdminInfo> seacProhibitUserInfo(@Param("keyword") String keyword);

    List<AdminInfo> seachAllUserInfo(@Param("keyword") String keyword);

    void userProhibit(@Param("adminInfoId") Integer adminInfoId);

    void userNoProhibit(@Param("adminInfoId") Integer adminInfoId);

    Integer getTotalDonationGoodsCount();

    Integer getTotalDonationGoodsMoney();

    Integer getTotalDonationMoney();

    Integer getTotalReceivingDonationGoodsCount();

    Integer getTotalRecevingDonationMoneyCount();

    Integer getTotalMoney();
}