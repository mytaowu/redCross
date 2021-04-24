package com.red.service;

import com.red.entity.AdminInfo;
import com.red.entity.TotalInfoDetail;

import java.util.List;

/**
 * @author: TMingYi
 * @date: 2020/8/30 17:36
 */
public interface UserInfoService {

    List<AdminInfo> findAllUserInfo(String pageSize, String pageNo, String keyWord);

    Integer getAllUserUnfoCount();

    List<AdminInfo> findProhibitUserInfo(String pageSize, String pageNo, String keyWord);

    Integer getProhibitUserInfoCount();

    AdminInfo findInfoByAdminInfoLoginName(String adminInfoLoginName);

    void addAdminInfo(AdminInfo adminInfo);

    void deleteUserById(Integer adminInfoId);

    void updateUserInfo(AdminInfo userInfo);

    void resetUserPass(Integer adminInfoId);

    void modifyUserPass(String adminInfoLoginName, String pass);

    void addAdminInfoRegister(AdminInfo adminInfo);

    void userNoProhibit(Integer adminInfoId);

    void userProhibit(Integer adminInfoId);

    AdminInfo getUserInfoByadminInfologinName(String adminInfologinName);

    TotalInfoDetail getInfo();
}
