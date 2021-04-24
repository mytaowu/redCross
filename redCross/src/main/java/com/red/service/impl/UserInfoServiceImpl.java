package com.red.service.impl;

import com.github.pagehelper.PageHelper;
import com.red.config.myconst.UserContst;
import com.red.config.thread.*;
import com.red.entity.AdminInfo;
import com.red.entity.TotalInfoDetail;
import com.red.mapper.AdminInfoMapper;
import com.red.service.UserInfoService;
import com.red.util.StringUtil;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author: TMingYi
 * @date: 2020/8/30 17:37
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private AdminInfoMapper adminInfoMapper;

    @Override
    public List<AdminInfo> findAllUserInfo(String pageSize, String pageNo, String keyWord) {
        PageHelper.startPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        return adminInfoMapper.seachAllUserInfo(keyWord);
    }

    @Override
    public Integer getAllUserUnfoCount() {
        AdminInfo adminInfo = new AdminInfo();
        // 这里我们可以看到Short里面的一个缓存，-127 ~ 128;
        // 去除顶级管理员
        adminInfo.setIsTopAdmin(Short.valueOf(String.valueOf(0)));
        // 去除禁用的用户;
        adminInfo.setAdminProhibit(Short.valueOf(String.valueOf(0)));
        return adminInfoMapper.select(adminInfo).size();

    }

    @Override
    public List<AdminInfo> findProhibitUserInfo(String pageSize, String pageNo, String keyWord) {
        PageHelper.startPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        return adminInfoMapper.seacProhibitUserInfo(keyWord);
    }

    @Override
    public Integer getProhibitUserInfoCount() {
        AdminInfo adminInfo = new AdminInfo();
        // 这里我们可以看到Short里面的一个缓存，-127 ~ 128;
        // 去除顶级管理员
        adminInfo.setIsTopAdmin(Short.valueOf(String.valueOf(0)));
        // 去未被禁用的用户;
        adminInfo.setAdminProhibit(Short.valueOf(String.valueOf(1)));
        return adminInfoMapper.select(adminInfo).size();
    }

    @Override
    public AdminInfo findInfoByAdminInfoLoginName(String adminInfoLoginName) {
        AdminInfo adminInfo = new AdminInfo();
        // 我们的登录名设置成唯一索引，所以可以这么玩;
        adminInfo.setAdminInfoLoginName(adminInfoLoginName);
        return adminInfoMapper.selectOne(adminInfo);
    }

    @Override
    public void addAdminInfo(AdminInfo adminInfo) {
        // 添加默认可用，注册默认禁用;
        adminInfo.setIsTopAdmin(Short.valueOf(String.valueOf(0)));
        adminInfo.setAdminProhibit(Short.valueOf(String.valueOf(0)));
        adminInfoMapper.insert(adminInfo);
    }

    @Override
    public void deleteUserById(Integer adminInfoId) {
        AdminInfo adminInfo = new AdminInfo();
        // adminInfoId 为主键索引
        adminInfo.setAdminInfoId(adminInfoId);
        adminInfoMapper.deleteByPrimaryKey(adminInfo);
    }

    @Override
    public void updateUserInfo(AdminInfo adminInfo) {
        // 除了修改数据库，不可能在设置顶级管理员;
        adminInfo.setIsTopAdmin(Short.valueOf(String.valueOf(0)));
        // 只能是正在使用的账户才可能进行一个修改的操作;
        adminInfo.setAdminProhibit(Short.valueOf(String.valueOf(0)));
        adminInfoMapper.updateByPrimaryKey(adminInfo);
    }

    @Override
    public void resetUserPass(Integer adminInfoId) {
        // 重置用户密码，默认密码为12345678;
        adminInfoMapper.resetUserPass(StringUtil.md5(UserContst.DEFAULT_PASSWORD),adminInfoId);
    }

    @Override
    public void modifyUserPass(String adminInfoLoginName, String password) {
        adminInfoMapper.modifyUserPass(adminInfoLoginName,password);
    }

    @Override
    public void addAdminInfoRegister(AdminInfo adminInfo) {
        adminInfo.setIsTopAdmin(Short.valueOf(String.valueOf(0)));
        adminInfo.setAdminProhibit(Short.valueOf(String.valueOf(1)));
        adminInfoMapper.insert(adminInfo);
    }

    @Override
    public void userNoProhibit(Integer adminInfoId) {
        adminInfoMapper.userNoProhibit(adminInfoId);
    }

    @Override
    public void userProhibit(Integer adminInfoId) {
        adminInfoMapper.userProhibit(adminInfoId);

    }

    @Override
    public AdminInfo getUserInfoByadminInfologinName(String adminInfologinName) {
        AdminInfo info = new AdminInfo();
        info.setAdminInfoLoginName(adminInfologinName);
        return adminInfoMapper.selectOne(info);
    }

    @Override
    public TotalInfoDetail getInfo() {
        TotalInfoDetail totalInfoDetail = new TotalInfoDetail();
        // 设置CountDownLaunch;
        CountDownLatch countDownLatch = new CountDownLatch(6);
        // 启动线程
        new TotalDonationGoodsCountThread(countDownLatch, totalInfoDetail,adminInfoMapper).start();
        new TotalDonationGoodsMoneyThread(countDownLatch, totalInfoDetail,adminInfoMapper).start();
        new TotalDonationMoneyThread(countDownLatch, totalInfoDetail,adminInfoMapper).start();
        new TotalMoneyThread(countDownLatch, totalInfoDetail,adminInfoMapper).start();
        new TotalReceivingDonationGoodsCountThread(countDownLatch, totalInfoDetail,adminInfoMapper).start();
        new TotalReceivingDonationMoneyCountThread(countDownLatch, totalInfoDetail,adminInfoMapper).start();
        // 等待执行;
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return totalInfoDetail;
    }
}
