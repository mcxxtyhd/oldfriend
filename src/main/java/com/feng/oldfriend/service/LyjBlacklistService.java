package com.feng.oldfriend.service;

import com.feng.oldfriend.entity.LyjBlacklist;

import java.util.List;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/10/15 21:11
 * @description： 黑名单的相关接口方法
 */
public interface LyjBlacklistService {

    List<LyjBlacklist> getDatas(String searchText);

    void saveBlack(LyjBlacklist data);

    void removeBlack(String uuid);
}
