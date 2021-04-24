package com.red.handler;

import com.red.config.myconst.CommonConst;
import com.red.entity.DonationGoods;
import com.red.entity.DonationMoney;
import com.red.entity.GoodDetailInfo;
import com.red.service.DonationGoodService;
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
 * @date: 2020/8/30 18:21
 */

@RestController
@Api(value = "捐物的控制类")
public class DonationGoodHandler {
    @Autowired
    private DonationGoodService donationGoodHandlerService;

    @RequestMapping("donation/good/list")
    @ApiOperation(value = "捐物的列表", httpMethod = "GET")
    public PageInfoVO<DonationGoods> getDonationGoodList(
            @RequestParam(value = "rows",defaultValue = "5") String pageSize,
            @RequestParam(value = "page",defaultValue = "1") String pageNo,
            @RequestParam(value = "keyWord",defaultValue = "") String keyWord) {
        List<DonationGoods> donationMoneyList = donationGoodHandlerService.getDonationGoodList(pageSize,pageNo,keyWord);
        Integer total = donationGoodHandlerService.getDonationGoodListCount();
        return new PageInfoVO<DonationGoods>(total, donationMoneyList);
    }

    @RequestMapping("donation/good/all")
    @ApiOperation(value = "所有的捐赠信息", httpMethod = "GET")
    public List<DonationGoods> getDonationGoodList() {
        List<DonationGoods> donationMoneyList = donationGoodHandlerService.getAll();
        return donationMoneyList;
    }

    @RequestMapping("donation/good/add/or/update")
    @ApiOperation(value = "添加或者修改捐物的信息", httpMethod = "POST")
    public InfomationVO<String> addOrUpdate(
            @RequestBody DonationGoods DonationGood) {

        try {
            if (DonationGood.getDonationId() == null){
                donationGoodHandlerService.addDonationGood(DonationGood);
            }else {
                donationGoodHandlerService.updateDonationGood(DonationGood);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new InfomationVO<String>(InfomationVO.FAILED, "信息已经存在，请重新输入", InfomationVO.NO_DATA);
        }
        return new InfomationVO<String>(InfomationVO.SUCCESS, CommonConst.INFORMATION_UPDATED_SUCCESSFULLY, InfomationVO.NO_DATA);
    }


    @RequestMapping("donation/good/delete")
    @ApiOperation(value = "删除捐赠信息", httpMethod = "GET")
    public InfomationVO<String> deleteReceivingMoneyDonation(
            @RequestParam("donationGoodId") Integer donationGoodId) {
        try {
            donationGoodHandlerService.deleteByDonationGoodId(donationGoodId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new InfomationVO<String>(InfomationVO.FAILED,CommonConst.DELETE_INFORMATION_EXCEPTION , InfomationVO.NO_DATA);
        }
        return new InfomationVO<String>(InfomationVO.SUCCESS, CommonConst.DELETE_INFORMATION_SUCCESS, InfomationVO.NO_DATA);
    }

    @RequestMapping("donation/good/detail/info")
    @ApiOperation(value = "返回某捐赠物资的流水信息", httpMethod = "GET")
    public InfomationVO<List<GoodDetailInfo>> donationGoodDetailInfo(
            @RequestParam("donationId") Integer donationId) {
        List<GoodDetailInfo> detailInfos =  donationGoodHandlerService.donationGoodDetailInfo(donationId);
        return new InfomationVO(InfomationVO.SUCCESS,InfomationVO.NO_MSG,detailInfos);
    }
}
