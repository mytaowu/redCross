package com.red.handler;

import com.red.entity.DonationType;
import com.red.service.DonationTypeService;
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
@Api(value = "控制捐赠类型的类！")
public class DonationTypeHandler {

    @Autowired
    private DonationTypeService donationTypeService;

    @RequestMapping("denation/type/list")
    @ApiOperation(value = "展示我们接收物品捐赠的列表", httpMethod = "GET")
    public List<DonationType> receivingGoodDonationList() {
        return donationTypeService.selectAll();
    }
}
