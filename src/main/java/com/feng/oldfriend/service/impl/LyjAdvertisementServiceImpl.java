package com.feng.oldfriend.service.impl;

import com.feng.oldfriend.dao.LyjAdvertisementMapper;
import com.feng.oldfriend.entity.LyjAdvertisement;
import com.feng.oldfriend.service.LyjAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LyjAdvertisementService")
public class LyjAdvertisementServiceImpl implements LyjAdvertisementService {

    @Autowired
    private LyjAdvertisementMapper lyjAdvertisementMapper;

    /**
     * create by: yangchenxiao
     * create time: 2019/7/23 22:27
     * description: 根据广告页返回指定的广告信息
     */
    @Override
    public List<LyjAdvertisement> getAdvertisementsByPagename(String pageName) {
        return lyjAdvertisementMapper.selectAdvertisementsByPagename(pageName);
    }
}
