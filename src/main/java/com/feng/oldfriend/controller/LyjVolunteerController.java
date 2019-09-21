package com.feng.oldfriend.controller;

import com.feng.oldfriend.config.CommonResponse;
import com.feng.oldfriend.entity.LyjUser;
import com.feng.oldfriend.entity.LyjVolunteer;
import com.feng.oldfriend.service.LyjVolunteerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/7/21 10:23
 * @description：志愿者api接口
 */
@RestController
@RequestMapping("/Volunteer")
@Api(value = "Volunteer", description = "志愿者")
public class LyjVolunteerController {

    @Autowired
    private LyjVolunteerService lyjVolunteerService;

    @ApiOperation(value = "查询所有的义工")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "Integer", value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Integer", value = "每页数量", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "searchText", dataType = "String", value = "搜索内容", required = false),
            @ApiImplicitParam(paramType = "query", name = "state", dataType = "Integer", value = "状态", required = false)

    })
    @GetMapping()
    public CommonResponse getVolunteer(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                       @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                       @RequestParam(value = "searchText", required = false) String searchText,
                                       @RequestParam(value = "state", required = false) Integer state) {
        try {

            pageNo = pageNo == null ? 1 : pageNo;
            pageSize = pageSize == null ? 10 : pageSize;

            PageHelper.startPage(pageNo, pageSize);
            PageInfo pageInfo = new PageInfo(lyjVolunteerService.getAllVolunteer(searchText,state));

            return new CommonResponse(pageInfo, 200, lyjVolunteerService.getAllVolunteerCount(searchText,state));

        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }
    }


    @ApiOperation(value = "根据用户唯一标识查询义工ID")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "userId", dataType = "String", value = "用户ID", required = true),
    })
    @GetMapping("/user/{userId}")
    public CommonResponse getVolunteerByUserId(@PathVariable("userId") String userId) {
        try {
            LyjVolunteer lyjVolunteer = lyjVolunteerService.getVolunteerByUserId(userId);
            return new CommonResponse(lyjVolunteer, 200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }
    }

    @ApiOperation(value = "根据义工ID查询用户ID")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "volunteerId", dataType = "Integer", value = "义工ID", required = true),
    })
    @GetMapping("/{volunteerId}")
    public CommonResponse getVolunteerById(@PathVariable("volunteerId") Integer volunteerId) {
        try {
            LyjVolunteer lyjVolunteer = lyjVolunteerService.getVolunteerByVolunteerId(volunteerId);
            return new CommonResponse(lyjVolunteer, 200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/29 21:47
     * description: 新增义工
     */
    @ApiOperation(value = "新增义工")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "lyjVolunteer", dataType = "LyjVolunteer", value = "新增义工", required = true)
    })
    @PostMapping()
    public CommonResponse addLyjVolunteer(@RequestBody LyjVolunteer lyjVolunteer) {
        try {
            return new CommonResponse(lyjVolunteerService.saveVolunteer(lyjVolunteer.getLyjUserId()), 200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/29 21:47
     * description: 成为义工(新增义工的升级版)
     */
    @ApiOperation(value = "新增义工(升级版)")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "userVolunteer", dataType = "user", value = "新增义工的用户信息", required = true)
    })
    @PostMapping("/becomeV")
    public CommonResponse becomeVolunteer(@RequestBody LyjUser lyjUser) {
        try {
            lyjVolunteerService.becomeVolunteer(lyjUser);
            return new CommonResponse(200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/29 21:47
     * description: 删除义工
     */
    @ApiOperation(value = "删除义工")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "volunteerId", dataType = "Integer", value = "需要删除的义工ID", required = true)
    })
    @DeleteMapping("/{lyjVolunteerId}")
    public CommonResponse removeVolunteer(@PathVariable("lyjVolunteerId") Integer lyjVolunteerId) {
        try {
            lyjVolunteerService.removeVolunteer(lyjVolunteerId);
            return new CommonResponse(200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }

    }

}
