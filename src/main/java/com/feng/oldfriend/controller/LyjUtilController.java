package com.feng.oldfriend.controller;

import com.feng.oldfriend.config.CommonResponse;
import com.feng.oldfriend.service.LyjUtilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * create by: yangchenxiao
     * create time: 2019/9/3 22:08
     * description: 微信接口的登录  没有用户就会注册
     */
    @ApiOperation(value = "微信接口的登录  没有用户就会注册")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "code", dataType = "String", value = "微信的登录的验证code", required = true)
    })
    @ResponseBody
    @GetMapping("/wxlogin")
    public CommonResponse user_login(@RequestParam(value = "code", required = false) String code)
    {
        try{
            return new CommonResponse(lyjUtilService.wxLogin(code), 200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500);
        }

    }

    @ApiOperation(value = "上传图片返回图片地址")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "img", dataType = "file", value = "上传的图片", required = true)
    })
    @PostMapping("/UploadImg")
    public CommonResponse uploadImg(@RequestParam("img") MultipartFile file) {
        try{
            //获得上传文件的地址
            String filePath= lyjUtilService.saveFile(file);
            return new CommonResponse(filePath, 200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500);
        }
    }

    @ApiOperation(value = "上传图片返回图片地址")
    @PostMapping("/UploadImgApi")
    public CommonResponse uploadImgApi(@RequestParam("file") MultipartFile file) {
        try{
            //获得上传文件的地址
            String filePath= lyjUtilService.saveFile(file);
            return new CommonResponse(filePath, 200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500);
        }
    }

    @ApiOperation(value = "调用短信验证码")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "phone", dataType = "String", value = "手机号码", required = true)
    })
    @GetMapping("/RegisterCheck")
    public CommonResponse registerCheck(@RequestParam("phone") String phoneNumber) {
        try{
            //获得上传文件的地址
            String checkCode= lyjUtilService.registerCheck(phoneNumber);
            return new CommonResponse(checkCode, 200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse(500);
        }
    }

}
