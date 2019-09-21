package com.feng.oldfriend.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.feng.oldfriend.Utils.HttpUtils;
import com.feng.oldfriend.config.UploadUtils;
import com.feng.oldfriend.config.WechatUtil;
import com.feng.oldfriend.entity.LyjUser;
import com.feng.oldfriend.service.LyjUserService;
import com.feng.oldfriend.service.LyjUtilService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/7/30 21:53
 * @description：
 */
@Slf4j
@Service("LyjUtilService")
public class LyjUtilServiceImpl implements LyjUtilService {


    @Value("${wxconfig.appId}")
    private String appId;

    @Value("${wxconfig.appSecret}")
    private String appSecret;

    @Value("${nginxfileurl.path}")
    private String webFileUrl;

    @Value("${messageapi.appcode}")
    private String messageAppCode;

    @Autowired
    private LyjUserService lyjUserService;

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

        String fileReturnPath=this.webFileUrl+ File.separator + fileUUIDName;
        return fileReturnPath;
    }

    @Override
    public String registerCheck(String phoneNumber) throws Exception {
        try {
            //生成6位的随机验证码
            String randomCheckCode=String.valueOf((int)((Math.random()*9+1)*100000));

            String host = "https://dxyzm.market.alicloudapi.com";
            String path = "/chuangxin/dxjk";
            String method = "POST";
            String appcode = this.messageAppCode;
            Map<String, String> headers = new HashMap<String, String>();
            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
            headers.put("Authorization", "APPCODE " + appcode);
            Map<String, String> querys = new HashMap<String, String>();
            querys.put("content", "【创信】你的验证码是："+randomCheckCode+"，3分钟内有效！");
            //测试可用短信模板：【创信】你的验证码是：#code#，3分钟内有效！，如需自定义短信内容或改动任意字符，请联系旺旺或QQ：726980650进行申请。
            querys.put("mobile", phoneNumber);
            Map<String, String> bodys = new HashMap<String, String>();

            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));

            return randomCheckCode;

        } catch (Exception e) {
            e.printStackTrace();
            //返回空
            return "";
        }
    }

    @Override
    public LyjUser wxLogin(String code) throws Exception{
        // 微信小程序ID
        String appid = this.appId;
        // 微信小程序秘钥
        String secret = this.appSecret;

        // 根据小程序穿过来的code想这个url发送请求
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        // 发送请求，返回Json字符串
        String str = WechatUtil.httpRequest(url, "GET", null);
        // 转成Json对象 获取openid
        JSONObject jsonObject = JSONObject.parseObject(str);

        // 我们需要的openid，在一个小程序中，openid是唯一的
        String openid = jsonObject.get("openid").toString();
        String session_key=jsonObject.get("session_key").toString();

        //然后去数据库找有没有 没有就注册一个用户 有就返回生成好的uuid
        LyjUser user=lyjUserService.getUserByOpenid(openid);
        if(user!=null){
            return user;
        }else{
            LyjUser userNew=new LyjUser();
            userNew.setLyjUserOpenid(openid);
            lyjUserService.saveWxUser(userNew);
            return userNew;
        }
    }
}
