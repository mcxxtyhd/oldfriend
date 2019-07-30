package com.feng.oldfriend.service.impl;

import com.feng.oldfriend.config.UploadUtils;
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
}
