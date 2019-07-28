package com.feng.oldfriend.controller;

import com.feng.oldfriend.dao.LyjUserMapper;
import com.feng.oldfriend.entity.LyjUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * @description：用户api接口
 */
@RestController
@RequestMapping("/User")
@Api(value = "User", description = "用户")
public class LyjUserController {

    @Autowired
    private LyjUserMapper lyjUserMapper;

    @ApiOperation(value = "根据搜索内容查询所有的用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "Integer", value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Integer", value = "每页数量", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "searchText", dataType = "String", value = "搜索内容", required = true),
    })
    @GetMapping()
    public ResponseEntity getUserBySearch(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                          @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                          @RequestParam("searchText") String searchText) {
        try{
            pageNo = pageNo == null ? 1 : pageNo;
            pageSize = pageSize == null ? 10 : pageSize;

            PageHelper.startPage(pageNo, pageSize);

            //判断是否需要根据需求类型ID进行查询
            PageInfo pageInfo = new PageInfo(lyjUserMapper.getUsers(searchText));

            return new ResponseEntity(pageInfo, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("后台程序出错，请联系管理员查看",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "根据用户ID查询详情")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "userId", dataType = "Integer", value = "用户ID", required = true),
    })
    @GetMapping("/{userId}")
    public ResponseEntity getUserById(@PathVariable("userId") Integer userId) {
        try{
            LyjUser lyjUser=lyjUserMapper.selectByPrimaryKey(userId);
            return new ResponseEntity(lyjUser, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("后台程序出错，请联系管理员查看",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * create by: yangchenxiao
     * create time: 2019/7/28 14:55
     * description: 新增用户信息
     */
    @ApiOperation(value = "新增用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "user", dataType = "LyjUser", value = "新增的用户", required = true)
    })
    @PostMapping()
    public ResponseEntity addUser(@RequestBody LyjUser lyjUser){
        try{
            lyjUserMapper.insert(lyjUser);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("后台程序出错，请联系管理员查看",HttpStatus.INTERNAL_SERVER_ERROR);
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
    public ResponseEntity updateUser(@RequestBody LyjUser lyjUser) {

        lyjUserMapper.updateByPrimaryKey(lyjUser);
        return new ResponseEntity(HttpStatus.OK);
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
    public ResponseEntity removeUser(@PathVariable("userId") Integer userId) {
        try{
            lyjUserMapper.deleteByPrimaryKey(userId);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("后台程序出错，请联系管理员查看",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
