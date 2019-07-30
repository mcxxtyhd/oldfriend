package com.feng.oldfriend.service;

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

}
