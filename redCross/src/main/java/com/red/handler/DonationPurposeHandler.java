package com.red.handler;

import com.red.entity.DonationPurpose;
import com.red.entity.DonationType;
import com.red.service.DonationPurposeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: TMingYi
 * @date: 2020/8/30 16:21
 */

@RestController
@Api(value = "控制捐赠用途的类！")
public class DonationPurposeHandler {

    @Autowired
    private DonationPurposeService donationPurposeService;

    @RequestMapping("denation/purpose/list")
    @ApiOperation(value = "展示我们接收物品用途的列表", httpMethod = "GET")
    public List<DonationPurpose> receivingGoodDonationList() {
        return donationPurposeService.selectAll();
    }
}
