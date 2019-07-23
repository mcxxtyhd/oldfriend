package com.feng.oldfriend.service;

import com.feng.oldfriend.entity.LyjAdvertisement;

import java.util.List;

public interface LyjAdvertisementService {

    /**
     * create by: yangchenxiao
     * create time: 2019/7/23 22:27
     * description: 根据广告页返回指定的广告信息
     */
    List<LyjAdvertisement> getAdvertisementsByPagename(String pageName);
}
