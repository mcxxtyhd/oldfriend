package com.feng.oldfriend.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.feng.oldfriend.config.UploadUtils;
import com.feng.oldfriend.entity.LyjMeseage;
import com.feng.oldfriend.service.LyjUtilService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/7/30 21:53
 * @description：
 */
@Slf4j
@Service("LyjUtilService")
public class LyjUtilServiceImpl implements LyjUtilService {

    /**
     * create by: yangchenxiao
     * create time: 2019/7/30 21:54
     * description: 保存文件的方法
     */
    @Override
    public String saveFile(MultipartFile file) throws Exception{
        if (file.isEmpty()) {
            return "文件为空";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        // 存放上传图片的文件夹
        File fileDir = UploadUtils.getImgDirFile();

        String fileUUIDName= UUID.randomUUID()+suffixName;
        // 构建真实的文件路径
        String filePath=fileDir.getAbsolutePath() + File.separator + fileUUIDName;
        File newFile = new File(filePath);

        file.transferTo(newFile);
        return filePath;
    }

    @Override
    public String registerCheck(String phoneNumber) throws Exception {
        //生成6位的随机验证码
        String randomCheckCode=String.valueOf((int)((Math.random()*9+1)*100000));

        String randomCheckJson= JSON.toJSONString(new LyjMeseage(randomCheckCode));

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "2352werw", "1231231");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", "oldfeng");
        request.putQueryParameter("TemplateCode", "SMS_172222607");
        request.putQueryParameter("TemplateParam", randomCheckJson);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return randomCheckJson;
    }
}
