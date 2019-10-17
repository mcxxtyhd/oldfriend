package com.feng.oldfriend.controller;

import com.feng.oldfriend.config.CommonResponse;
import com.feng.oldfriend.entity.LyjAdvertisement;
import com.feng.oldfriend.entity.LyjUser;
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
import org.springframework.web.bind.annotation.*;

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
            @ApiImplicitParam(paramType = "query", name = "pageName", dataType = "String", value = "哪个页面的广告", required = false),
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "Integer", value = "页码", defaultValue = "0", required = false),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Integer", value = "每页数量", defaultValue = "10", required = false)
    })
    @GetMapping()
    public CommonResponse getAdvertisementByPageName(@RequestParam(value = "pageName", required = false) String pageName,
                                                     @RequestParam(value = "pageNo", required = false) Integer pageNo,
                                                     @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        try{
            pageNo = pageNo == null ? 1 : pageNo;
            pageSize = pageSize == null ? 10 : pageSize;

            PageHelper.startPage(pageNo, pageSize);

            PageInfo pageInfo = new PageInfo(lyjAdvertisementService.getAdvertisementsByPagename(pageName));

            return new CommonResponse(pageInfo,200,lyjAdvertisementService.getAdvertisementByPageNameCount(pageName));
        }
        catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/8/4 11:23
     * description: 新增广告
     */
    @ApiOperation(value = "新增广告")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "user", dataType = "LyjUser", value = "新增的广告", required = true)
    })
    @PostMapping()
    public CommonResponse addAdvertisement(@RequestBody LyjAdvertisement lyjAdvertisement){
        try{
            lyjAdvertisementService.saveAdvertisement(lyjAdvertisement);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/8/4 11:23
     * description: 更新广告信息
     */
    @ApiOperation(value = "更新广告信息")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "user", dataType = "LyjUser", value = "更新的广告信息", required = true)
    })
    @PutMapping()
    public CommonResponse updateAdvertisement(@RequestBody LyjAdvertisement lyjAdvertisement) {

        lyjAdvertisementService.updateAdvertisement(lyjAdvertisement);
        return new CommonResponse(200);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/8/4 11:23
     * description: 删除广告
     */
    @ApiOperation(value = "删除广告")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "lyjAdvertisementId", dataType = "Integer", value = "需要删除的广告ID", required = true)
    })
    @DeleteMapping("/{lyjAdvertisementId}")
    public CommonResponse removeAdvertisement(@PathVariable("lyjAdvertisementId") Integer lyjAdvertisementId) {
        try{
            lyjAdvertisementService.removeAdvertisement(lyjAdvertisementId);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }

    }
}
