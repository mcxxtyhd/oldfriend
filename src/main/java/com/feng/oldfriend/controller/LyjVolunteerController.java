package com.feng.oldfriend.controller;

import com.feng.oldfriend.entity.LyjVolunteer;
import com.feng.oldfriend.service.LyjVolunteerService;
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
 * @description：志愿者api接口
 */
@RestController
@RequestMapping("/Volunteer")
@Api(value = "Volunteer", description = "志愿者")
public class LyjVolunteerController {

    @Autowired
    private LyjVolunteerService lyjVolunteerService;

    @ApiOperation(value = "根据用户ID查询义工ID")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "userId", dataType = "Integer", value = "用户ID", required = true),
    })
    @GetMapping("/user/{userId}")
    public ResponseEntity getVolunteerByUserId(@PathVariable("userId") Integer userId) {
        try{
            List<LyjVolunteer> lyjVolunteers=lyjVolunteerService.getVolunteerByUserId(userId);
            return new ResponseEntity(lyjVolunteers, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("后台程序出错，请联系管理员查看",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "根据义工ID查询用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "volunteerId", dataType = "Integer", value = "义工ID", required = true),
    })
    @GetMapping("/{volunteerId}")
    public ResponseEntity getVolunteerById(@PathVariable("volunteerId") Integer volunteerId) {
        try{
            List<LyjVolunteer> lyjVolunteers=lyjVolunteerService.getVolunteerByVolunteerId(volunteerId);
            return new ResponseEntity(lyjVolunteers, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("后台程序出错，请联系管理员查看",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/29 21:47
     * description: 新增义工
     */
    @ApiOperation(value = "新增义工")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "LyjVolunteer", dataType = "LyjVolunteer", value = "新增的义工", required = true)
    })
    @PostMapping()
    public ResponseEntity addLyjVolunteer(@RequestBody LyjVolunteer lyjVolunteer){
        try{
            lyjVolunteerService.saveVolunteer(lyjVolunteer);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("后台程序出错，请联系管理员查看",HttpStatus.INTERNAL_SERVER_ERROR);
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
    @DeleteMapping("/{VolunteerId}")
    public ResponseEntity removeVolunteer(@PathVariable("volunteerId") Integer volunteerId) {
        try{
            lyjVolunteerService.removeVolunteer(volunteerId);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("后台程序出错，请联系管理员查看",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
