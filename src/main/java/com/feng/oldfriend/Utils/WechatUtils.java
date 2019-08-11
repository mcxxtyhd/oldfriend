package com.feng.oldfriend.Utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.*;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/8/11 15:33
 * @description：
 */
public class WechatUtils {

    public static void main(String[] args) {
        getWxUserOpenid("011TTQZu1zaUme0KT7Zu15T80v1TTQZZ","wx52e3cedd9b311e28","e83a1d42d5fafb55a6f9cb8d4c53ee48");
    }


    //获取openid
    public static Map<String, Object> getWxUserOpenid(String code, String APPID, String APPSecret) {
        //拼接url
        StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
        url.append("appid=");//appid设置
        url.append(APPID);
        url.append("&secret=");//secret设置
        url.append(APPSecret);
        url.append("&js_code=");//code设置
        url.append(code);
        url.append("&grant_type=authorization_code");
        Map<String, Object> map = null;
        try {
            HttpClient client = HttpClientBuilder.create().build();//构建一个Client
            HttpGet get = new HttpGet(url.toString());    //构建一个GET请求
            HttpResponse response = client.execute(get);//提交GET请求
            HttpEntity result = response.getEntity();//拿到返回的HttpResponse的"实体"
            String content = EntityUtils.toString(result);
            System.out.println(content);//打印返回的信息
//            JSONObject res = JSONObject.fromObject(content);//把信息封装为json
//            //把信息封装到map
//            map = MdzwUtils.parseJSON2Map(res);//这个小工具的代码在下面
        } catch (Exception e) {
            System.out.println("调用失败啊");
            e.printStackTrace();
        }
        return map;
    }


}
