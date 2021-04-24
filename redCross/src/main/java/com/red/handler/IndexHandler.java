package com.red.handler;


import com.red.config.myconst.UserContst;
import com.red.entity.AdminInfo;
import com.red.entity.TotalInfoDetail;
import com.red.service.UserInfoService;
import com.red.util.StringUtil;
import com.red.vo.InfomationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class IndexHandler {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("getInfo")
    public TotalInfoDetail getInfo() {
        return userInfoService.getInfo();
    }

    @RequestMapping("dologin")
    public InfomationVO doLodin(@RequestParam("adminInfologinName") String adminInfologinName, @RequestParam("adminInfoPass") String adminInfoPass) {
        //账号存在，密码不正确的情况下；
        AdminInfo adminInfo = userInfoService.getUserInfoByadminInfologinName(adminInfologinName);
        if (adminInfo == null) {
            return new InfomationVO<String>(InfomationVO.FAILED, InfomationVO.NO_MSG, UserContst.ACCOUNT_DOES_NOT_EXIST);
        }

        if (adminInfo.getAdminProhibit() == 1){
            return new InfomationVO<String>(InfomationVO.FAILED, "该用户已经被禁用，请联系管理员解除！", InfomationVO.NO_DATA);
        }

        //对密码进行md5加密；
        adminInfoPass = StringUtil.md5(adminInfoPass);

        //取出数据库的原串；
        String sourceLoginPwd = adminInfo.getAdminInfoPass();
        if (adminInfoPass.equals(sourceLoginPwd)) {
            // 登录成功，判断判断是否为顶级管理员，来进行一个跳转;
            return new InfomationVO<Short>(InfomationVO.SUCCESS, InfomationVO.NO_MSG, adminInfo.getIsTopAdmin());
        } else {
            return new InfomationVO<String>(InfomationVO.FAILED, UserContst.PASSWORD_ERROR, InfomationVO.NO_DATA);
        }
    }

}
