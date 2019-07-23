package com.feng.oldfriend.controller;

import com.feng.oldfriend.entity.LyjAdvertisement;
import com.feng.oldfriend.service.LyjAdvertisementService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/7/21 10:23
 * @description：广告的api接口
 */

@RestController
@RequestMapping("/Advertisement")
@Api(value = "Advertisement", description = "广告")
public class LyjAdvertisementController {

    @Autowired
    private LyjAdvertisementService lyjAdvertisementService;


    /**
     * create by: yangchenxiao
     * create time: 2019/7/23 22:28
     * description: 根据广告页返回指定的广告信息
     */
    @ApiOperation(value = "根据广告页找到指定的图片url")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "pageName", dataType = "String", value = "哪个页面的广告", required = true)
    })
    @GetMapping()
    public ResponseEntity getAdvertisementByPageName(@RequestParam(value = "pageName", required = false) String pageName) {
        List<LyjAdvertisement> tyjAdvertisement=lyjAdvertisementService.getAdvertisementsByPagename(pageName);
        return new ResponseEntity(tyjAdvertisement,HttpStatus.OK);

    }

}
