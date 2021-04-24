package com.red.handler;

import com.red.config.myconst.CommonConst;
import com.red.entity.ReceivingGoodDonation;
import com.red.service.ReceivingGoodDonationService;
import com.red.vo.InfomationVO;
import com.red.vo.PageInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: TMingYi
 * @date: 2020/8/30 15:21
 */

@RestController
@Api(value = "控制捐赠物品的类")
public class ReceivingGoodDonationHandler {

    @Autowired
    private ReceivingGoodDonationService receivingGoodDonationService;

    @RequestMapping("receiving/good/donation/list")
    @ApiOperation(value = "展示我们接收物品捐赠的列表", httpMethod = "GET")
    public PageInfoVO<ReceivingGoodDonation> receivingGoodDonationList(
            @RequestParam(value = "rows",defaultValue = "5") String pageSize,
            @RequestParam(value = "page",defaultValue = "1") String pageNo,
            @RequestParam(value = "keyWord", defaultValue = "") String keyWord) {
        List<ReceivingGoodDonation> receivingGoodDonations = receivingGoodDonationService.receivingGoodDonationList(pageSize, pageNo, keyWord);
        Integer total = receivingGoodDonationService.receivingGoodDonationListCount();
        return new PageInfoVO<ReceivingGoodDonation>(total, receivingGoodDonations);
    }

    @RequestMapping("receiving/good/donation/add/or/update")
    @ApiOperation(value = "添加或者修改我们接收捐赠的信息", httpMethod = "POST")
    public InfomationVO<String> add(@RequestBody ReceivingGoodDonation receivingGoodDonation) {

        try {
            if (receivingGoodDonation.getReceivingGoodDonationId() == null){
                receivingGoodDonationService.addReceivingGoodDonation(receivingGoodDonation);
            }else {
                receivingGoodDonationService.updateReceivingGoodDonation(receivingGoodDonation);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new InfomationVO<String>(InfomationVO.FAILED, "信息已经存在，请重新输入", InfomationVO.NO_DATA);
        }
        return new InfomationVO<String>(InfomationVO.SUCCESS, CommonConst.INFORMATION_UPDATED_SUCCESSFULLY, InfomationVO.NO_DATA);
    }


    @RequestMapping("receiving/good/donation/delete")
    @ApiOperation(value = "删除捐赠信息", httpMethod = "GET")
    public InfomationVO<String> deleteReceivingGoodDonation(@RequestParam("receivingGoodDonationId") Integer receivingGoodDonationId) {
        try {
            receivingGoodDonationService.deleteReceivingGoodDonation(receivingGoodDonationId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new InfomationVO<String>(InfomationVO.FAILED,CommonConst.DELETE_INFORMATION_EXCEPTION , InfomationVO.NO_DATA);
        }
        return new InfomationVO<String>(InfomationVO.SUCCESS, CommonConst.DELETE_INFORMATION_SUCCESS, InfomationVO.NO_DATA);
    }
}
