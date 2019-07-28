package com.feng.oldfriend.service;

import com.feng.oldfriend.entity.LyjUser;

import java.util.List;

public interface LyjUserService {


    /**
     * create by: yangchenxiao
     * create time: 2019/7/28 14:58
     * description: 根据搜索内容找到对应的信息
     */
    List<LyjUser> getUsers(String searchText);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/28 14:46
     * description: 根据用户ID查找到详情
     */
    LyjUser getUserById(Integer userId);

    void saveUser(LyjUser user);

    void updateUser(LyjUser user);

    void removeUser(Integer id);

}
