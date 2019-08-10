package com.feng.oldfriend.controller;

import com.feng.oldfriend.entity.LyjUser;
import com.feng.oldfriend.service.LyjUtilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/8/4 11:31
 * @description：一些公用的方法
 */
@RestController
@RequestMapping("/Util")
@Api(value = "Util", description = "公用方法")
public class LyjUtilController {

    @Autowired
    private LyjUtilService lyjUtilService;


    @ApiOperation(value = "上传图片返回图片地址")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "img", dataType = "file", value = "上传的图片", required = true)
    })
    @PostMapping("/UploadImg")
    public ResponseEntity uploadImg(@RequestParam("img") MultipartFile file) {
        try{
            //获得上传文件的地址
            String filePath= lyjUtilService.saveFile(file);
            return new ResponseEntity(filePath, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity("后台程序出错，请联系管理员查看",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "调用短信验证码")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "phone", dataType = "String", value = "手机号码", required = true)
    })
    @GetMapping("/RegisterCheck")
    public ResponseEntity registerCheck(@RequestParam("phone") String phoneNumber) {
        try{
            //获得上传文件的地址
            String checkCode= lyjUtilService.registerCheck(phoneNumber);
            return new ResponseEntity(checkCode, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity("后台程序出错，请联系管理员查看",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
