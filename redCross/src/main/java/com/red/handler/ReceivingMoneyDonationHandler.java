package com.red.handler;

import com.red.config.myconst.CommonConst;
import com.red.entity.ReceivingGoodDonation;
import com.red.entity.ReceivingMoneyDonation;
import com.red.service.ReceivingMoneyDonationService;
import com.red.vo.InfomationVO;
import com.red.vo.PageInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: TMingYi
 * @date: 2020/8/30 15:21
 */

@RestController
@Api(value = "接收捐款的类")
public class ReceivingMoneyDonationHandler {

    @Autowired
    private ReceivingMoneyDonationService receivingMoneyDonationService;

    @RequestMapping("receiving/money/donation/list")
    @ApiOperation(value = "展示我们接收物品捐赠的列表", httpMethod = "GET")
    public PageInfoVO<ReceivingMoneyDonation> receivingMoneyDonationList(
            @RequestParam(value = "rows",defaultValue = "5") String pageSize,
            @RequestParam(value = "page",defaultValue = "1") String pageNo,
            @RequestParam(value = "keyWord",defaultValue = "") String keyWord) {
        List<ReceivingMoneyDonation> receivingGoodDonations = receivingMoneyDonationService.receivingMoneyDonationList(pageSize, pageNo,keyWord);
        Integer total = receivingMoneyDonationService.receivingMoneyDonationListCount();
        return new PageInfoVO<ReceivingMoneyDonation>(total, receivingGoodDonations);
    }

    @RequestMapping("receiving/money/donation/add/or/update")
    @ApiOperation(value = "添加或者修改我们接收捐赠的信息", httpMethod = "POST")
    public InfomationVO<String> addOrUpdate(@RequestBody ReceivingMoneyDonation receivingGoodDonation) {

        try {
            if (receivingGoodDonation.getReceivingMoneyDonationId() == null){
                receivingMoneyDonationService.addReceivingMoneyDonation(receivingGoodDonation);
            }else {
                receivingMoneyDonationService.updateReceivingMoneyDonation(receivingGoodDonation);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new InfomationVO<String>(InfomationVO.FAILED, "信息已经存在，请重新输入", InfomationVO.NO_DATA);
        }
        return new InfomationVO<String>(InfomationVO.SUCCESS, CommonConst.INFORMATION_UPDATED_SUCCESSFULLY, InfomationVO.NO_DATA);
    }


    @RequestMapping("receiving/money/donation/delete")
    @ApiOperation(value = "删除捐赠信息", httpMethod = "GET")
    public InfomationVO<String> deleteReceivingMoneyDonation(@RequestParam("receivingMoneyDonationId") Integer receivingMoneyDonationId) {
        try {
            receivingMoneyDonationService.deleteReceivingMoneyDonation(receivingMoneyDonationId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new InfomationVO<String>(InfomationVO.FAILED,CommonConst.DELETE_INFORMATION_EXCEPTION , InfomationVO.NO_DATA);
        }
        return new InfomationVO<String>(InfomationVO.SUCCESS, CommonConst.DELETE_INFORMATION_SUCCESS, InfomationVO.NO_DATA);
    }
}
