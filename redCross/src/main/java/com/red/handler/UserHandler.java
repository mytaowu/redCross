package com.red.handler;


import com.red.config.myconst.CommonConst;
import com.red.entity.AdminInfo;
import com.red.service.UserInfoService;
import com.red.util.StringUtil;
import com.red.vo.InfomationVO;
import com.red.vo.PageInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * @author: TMingYi
 * @date: 2020/8/30 15:21
 */

@RestController
@Api(value = "控制管理员的类")
public class UserHandler {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("user/get/all/info")
    @ApiOperation(value = "查询所有的管理员信息（除去我们禁用的）", httpMethod = "GET")
    public PageInfoVO<AdminInfo> findAllUserInfo(
            @RequestParam(value = "rows",defaultValue = "5") String pageSize,
            @RequestParam(value = "page",defaultValue = "1") String pageNo,
            @RequestParam(value = "keyWord", defaultValue = "") String keyWord) {
        List<AdminInfo> adminInfos = userInfoService.findAllUserInfo(pageSize,pageNo,keyWord);
        Integer total = userInfoService.getAllUserUnfoCount();
        return new PageInfoVO<>(total,adminInfos);
    }


    @RequestMapping("user/get/prohibit/info")
    @ApiOperation(value = "查询禁用的管理员(可以通过审核)", httpMethod = "GET")
    public PageInfoVO<AdminInfo> findProhibitUserInfo(
            @RequestParam(value = "rows",defaultValue = "5") String pageSize,
            @RequestParam(value = "page",defaultValue = "1") String pageNo,
            @RequestParam(value = "keyWord", defaultValue = "") String keyWord) {
        List<AdminInfo> adminInfos = userInfoService.findProhibitUserInfo(pageSize,pageNo,keyWord);
        Integer total = userInfoService.getProhibitUserInfoCount();
        return new PageInfoVO<>(total,adminInfos);
    }

    @RequestMapping("user/get/info/by/num")
    @ApiOperation(value = "根据登录名到用户的信息", httpMethod = "GET")
    public AdminInfo findInfoByNum(@RequestParam("adminInfoLoginName") String adminInfoLoginName) {
        return userInfoService.findInfoByAdminInfoLoginName(adminInfoLoginName);
    }


    @RequestMapping("user/add")
    @ApiOperation(value = "添加管理员信息", httpMethod = "POST")
    public InfomationVO<String> add(@RequestBody AdminInfo adminInfo) {
        try {
            //我们添加了唯一索引,密码进行一个MD5加密
            adminInfo.setAdminInfoPass(StringUtil.md5(adminInfo.getAdminInfoPass()));
            userInfoService.addAdminInfo(adminInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new InfomationVO<String>(InfomationVO.FAILED, CommonConst.INFORMATION_ALREADY_EXISTS, InfomationVO.NO_DATA);
        }
        return new InfomationVO<String>(InfomationVO.SUCCESS, CommonConst.INFORMATION_UPDATED_SUCCESSFULLY, InfomationVO.NO_DATA);
    }

    @RequestMapping("user/register")
    @ApiOperation(value = "接收用户的注册", httpMethod = "POST")
    public InfomationVO<String> register(@RequestBody AdminInfo adminInfo) {
        try {
            //我们添加了唯一索引,密码进行一个MD5加密
            adminInfo.setAdminInfoPass(StringUtil.md5(adminInfo.getAdminInfoPass()));
            userInfoService.addAdminInfoRegister(adminInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new InfomationVO<String>(InfomationVO.FAILED, CommonConst.INFORMATION_ALREADY_EXISTS, InfomationVO.NO_DATA);
        }
        return new InfomationVO<String>(InfomationVO.SUCCESS, CommonConst.INFORMATION_UPDATED_SUCCESSFULLY, InfomationVO.NO_DATA);
    }


    @RequestMapping("user/delete")
    @ApiOperation(value = "删除用户", httpMethod = "GET")
    public InfomationVO<String> deleteUserById(@RequestParam("adminInfoId") Integer adminInfoId) {
        try {
            userInfoService.deleteUserById(adminInfoId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new InfomationVO<String>(InfomationVO.FAILED, CommonConst.DELETE_INFORMATION_EXCEPTION, InfomationVO.NO_DATA);
        }
        return new InfomationVO<String>(InfomationVO.SUCCESS, CommonConst.DELETE_INFORMATION_SUCCESS, InfomationVO.NO_DATA);
    }


    @RequestMapping("user/modify")
    @ApiOperation(value = "修改管理员信息", httpMethod = "POST")
    public InfomationVO<String> modify(@RequestBody AdminInfo userInfo) {
        try {
            userInfoService.updateUserInfo(userInfo);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new InfomationVO<String>(InfomationVO.FAILED, CommonConst.DATA_SAVING_FAILED, InfomationVO.NO_DATA);
        }
        return new InfomationVO<String>(InfomationVO.SUCCESS, CommonConst.INFORMATION_UPDATED_SUCCESSFULLY, InfomationVO.NO_DATA);
    }


    @RequestMapping("user/reset/pass")
    @ApiOperation(value = "重置管理员密码", httpMethod = "GET")
    public InfomationVO resetUserPass(@RequestParam("adminInfoId") Integer adminInfoId) {
        try {
            userInfoService.resetUserPass(adminInfoId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new InfomationVO<String>(InfomationVO.FAILED, CommonConst.DATA_SAVING_FAILED, InfomationVO.NO_DATA);
        }
        return new InfomationVO<String>(InfomationVO.SUCCESS, CommonConst.INFORMATION_UPDATED_SUCCESSFULLY, InfomationVO.NO_DATA);
    }

    @RequestMapping("user/prohibit")
    @ApiOperation(value = "禁用管理员", httpMethod = "GET")
    public InfomationVO userProhibit(@RequestParam("adminInfoId") Integer adminInfoId) {
        try {
            userInfoService.userProhibit(adminInfoId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new InfomationVO<String>(InfomationVO.FAILED, CommonConst.DATA_SAVING_FAILED, InfomationVO.NO_DATA);
        }
        return new InfomationVO<String>(InfomationVO.SUCCESS, CommonConst.INFORMATION_UPDATED_SUCCESSFULLY, InfomationVO.NO_DATA);
    }

    @RequestMapping("user/no/prohibit")
    @ApiOperation(value = "解除管理员的禁用", httpMethod = "GET")
    public InfomationVO userNoProhibit(@RequestParam("adminInfoId") Integer adminInfoId) {
        try {
            userInfoService.userNoProhibit(adminInfoId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new InfomationVO<String>(InfomationVO.FAILED, CommonConst.DATA_SAVING_FAILED, InfomationVO.NO_DATA);
        }
        return new InfomationVO<String>(InfomationVO.SUCCESS, CommonConst.INFORMATION_UPDATED_SUCCESSFULLY, InfomationVO.NO_DATA);
    }


    @RequestMapping("modify/user/pass")
    @ApiOperation(value = "修改管理员的密码", httpMethod = "get")
    public InfomationVO<String> modifyUserPass(@RequestParam("userOldPass") String userOldPass,
                                               @RequestParam("userNewPass") String userNewPass,
                                               HttpSession session) {

        AdminInfo adminInfo = (AdminInfo) session.getAttribute("userInfo");
        if (adminInfo == null){
            //这种情况在我们正常的操作中应该都不会出现;
            return new InfomationVO<String>(InfomationVO.FAILED,"请登录之后，在进行密码的修改！", InfomationVO.NO_DATA);
        }
        if (!(Objects.equals(StringUtil.md5(userOldPass),adminInfo.getAdminInfoPass()))){
            return new InfomationVO<String>(InfomationVO.FAILED,"原密码错误！", InfomationVO.NO_DATA);
        }
        // 我们的登录名是唯一索引;
        userInfoService.modifyUserPass(adminInfo.getAdminInfoLoginName(),StringUtil.md5(userNewPass));
        return new InfomationVO<String>(InfomationVO.SUCCESS,InfomationVO.NO_MSG, InfomationVO.NO_DATA);
    }
}
