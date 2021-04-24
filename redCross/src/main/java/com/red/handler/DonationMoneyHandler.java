package com.red.handler;

import com.red.config.myconst.CommonConst;
import com.red.entity.DonationMoney;
import com.red.service.DonationMoneyService;
import com.red.vo.InfomationVO;
import com.red.vo.PageInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: TMingYi
 * @date: 2020/8/30 18:21
 */

@RestController
@Api(value = "捐钱的控制类")
public class DonationMoneyHandler {
    @Autowired
    private DonationMoneyService donationMoneyService;

    @RequestMapping("donation/money/list")
    @ApiOperation(value = "捐款的列表", httpMethod = "GET")
    public PageInfoVO<DonationMoney> getDonationMoneyList(
            @RequestParam(value = "rows",defaultValue = "5") String pageSize,
            @RequestParam(value = "page",defaultValue = "1") String pageNo,
            @RequestParam(value = "keyWord",defaultValue = "") String keyWord) {
        List<DonationMoney> donationMoneyList = donationMoneyService.getDonationMoneyList(pageSize, pageNo,keyWord);
        Integer total = donationMoneyService.getDonationMoneyListCount();
        return new PageInfoVO<DonationMoney>(total, donationMoneyList);
    }

    @RequestMapping("donation/money/add/or/update")
    @ApiOperation(value = "添加或者修改捐款的信息", httpMethod = "POST")
    public InfomationVO<String> addOrUpdate(
            @RequestBody DonationMoney donationMoney) {

        try {
            if (donationMoney.getDonationMoneyId() == null){
                donationMoneyService.addDonationMoney(donationMoney);
            }else {
                donationMoneyService.updateDonationMoney(donationMoney);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new InfomationVO<String>(InfomationVO.FAILED, "信息已经存在，请重新输入", InfomationVO.NO_DATA);
        }
        return new InfomationVO<String>(InfomationVO.SUCCESS, CommonConst.INFORMATION_UPDATED_SUCCESSFULLY, InfomationVO.NO_DATA);
    }


    @RequestMapping("donation/money/delete")
    @ApiOperation(value = "删除捐赠信息", httpMethod = "GET")
    public InfomationVO<String> deleteReceivingMoneyDonation(
            @RequestParam("donationMoneyId") Integer donationMoneyId) {
        try {
            donationMoneyService.deleteByDonationMoneyId(donationMoneyId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new InfomationVO<String>(InfomationVO.FAILED,CommonConst.DELETE_INFORMATION_EXCEPTION , InfomationVO.NO_DATA);
        }
        return new InfomationVO<String>(InfomationVO.SUCCESS, CommonConst.DELETE_INFORMATION_SUCCESS, InfomationVO.NO_DATA);
    }
}
