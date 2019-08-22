package com.feng.oldfriend.controller;

import com.feng.oldfriend.config.CommonResponse;
import com.feng.oldfriend.dao.LyjUserMapper;
import com.feng.oldfriend.entity.LyjUser;
import com.feng.oldfriend.service.LyjUserService;
import com.feng.oldfriend.service.LyjUtilService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/7/21 10:23
 * @description：用户api接口
 */
@RestController
@RequestMapping("/User")
@Api(value = "User", description = "用户")
public class LyjUserController {

    @Autowired
    private LyjUserService lyjUserService;

    @Autowired
    private LyjUtilService lyjUtilService;

    @ApiOperation(value = "根据搜索内容查询所有的用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "Integer", value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Integer", value = "每页数量", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "searchText", dataType = "String", value = "搜索内容", required = false),
    })
    @GetMapping()
    public CommonResponse getUserBySearch(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                          @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                          @RequestParam(value = "searchText", required = false) String searchText){
        try{
            pageNo = pageNo == null ? 1 : pageNo;
            pageSize = pageSize == null ? 10 : pageSize;

            PageHelper.startPage(pageNo, pageSize);

            //判断是否需要根据需求类型ID进行查询
            PageInfo pageInfo = new PageInfo(lyjUserService.getUsers(searchText));

            return new CommonResponse(pageInfo, 200,lyjUserService.getUsersCount(searchText));
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    @ApiOperation(value = "根据用户ID查询详情")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "userId", dataType = "Integer", value = "用户ID", required = true),
    })
    @GetMapping("/{userId}")
    public CommonResponse getUserById(@PathVariable("userId") Integer userId) {
        try{
            LyjUser lyjUser=lyjUserService.getUserById(userId);
            return new CommonResponse(lyjUser, 200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }


    /**
     * create by: yangchenxiao
     * create time: 2019/7/28 14:55
     * description: 新增用户信息
     */
    @ApiOperation(value = "新增用户(注册)")
    @ApiImplicitParams(value = {
//            @ApiImplicitParam(paramType = "query", name = "phone", dataType = "String", value = "手机号码", required = true),
//            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", value = "密码", required = true)
            @ApiImplicitParam(paramType = "body", name = "user", dataType = "User", value = "用户信息", required = true)
    })
    @PostMapping("/register")
    public CommonResponse addUser(@RequestBody LyjUser newUser){
        try{
            String encryptUserInfo=lyjUserService.saveUser(newUser);
            return new CommonResponse(encryptUserInfo,200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/8/11 16:38
     * description: 用户登录  成功返回用户信息
     */
    @ApiOperation(value = "用户登录")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "phone", dataType = "String", value = "手机号码", required = true),
            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", value = "密码", required = true)
    })
    @GetMapping("/login")
    public CommonResponse loginUser(@RequestParam(value = "phone", required = true) String phone,
                                    @RequestParam(value = "password", required = true) String password){
        try{
            return new CommonResponse(lyjUserService.loginUser(phone,password),200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    @ApiOperation(value = "根据唯一标识找到用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "userUUID", dataType = "String", value = "需要查找用户的UUID", required = true)
    })
    @GetMapping("/userinfo")
    public CommonResponse getUserInfoByUUID(@RequestParam(value = "userUUID", required = true) String userUUID){
        try{
            return new CommonResponse(lyjUserService.getUserByInfo(userUUID),200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    @ApiOperation(value = "判断手机号是否重复 返回false则说明该手机号码重复")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "phone", dataType = "String", value = "手机号", required = true)
    })
    @GetMapping("/checkphone")
    public CommonResponse checkPhone(@RequestParam(value = "phone", required = true) String phone){
        try{
            boolean result=lyjUserService.checkPhone(phone);
            return new CommonResponse(result,200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/28 14:55
     * description: 更新用户信息
     */
    @ApiOperation(value = "更新用户信息")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "user", dataType = "LyjUser", value = "更新的用户信息", required = true)
    })
    @PutMapping()
    public CommonResponse updateUser(@RequestBody LyjUser lyjUser) {

        lyjUserService.updateUser(lyjUser);
        return new CommonResponse(200);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/28 14:55
     * description: 删除用户
     */
    @ApiOperation(value = "删除用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "userId", dataType = "Integer", value = "需要删除的用户ID", required = true)
    })
    @DeleteMapping("/{userId}")
    public CommonResponse removeUser(@PathVariable("userId") Integer userId) {
        try{
            lyjUserService.removeUser(userId);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }

    }

}
