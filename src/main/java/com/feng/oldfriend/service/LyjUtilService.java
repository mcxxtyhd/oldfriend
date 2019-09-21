package com.feng.oldfriend.service;

import com.feng.oldfriend.entity.LyjUser;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/7/30 21:51
 * @description：
 */
public interface LyjUtilService {

    /**
     * create by: yangchenxiao
     * create time: 2019/7/30 21:54
     * description: 保存文件的方法
     */
    String saveFile(MultipartFile file) throws Exception;

    String registerCheck(String phoneNumber) throws Exception;

    /**
     * create by: yangchenxiao
     * create time: 2019/9/3 21:08
     * description: 微信登录 返回openid 以及 session_key的加密值
     */
    LyjUser wxLogin(String code) throws Exception;

}
