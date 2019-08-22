package com.feng.oldfriend.service;

import com.feng.oldfriend.entity.LyjUser;

import java.util.List;

public interface LyjUserService {


    /**
     * create by: yangchenxiao
     * create time: 2019/7/28 14:58
     * description: 根据搜索内容找到对应的信息
     */
    List<LyjUser> getUsers(String searchText) throws Exception;

    Integer getUsersCount(String searchText) ;

    /**
     * create by: yangchenxiao
     * create time: 2019/7/28 14:46
     * description: 根据用户ID查找到详情
     */
    LyjUser getUserById(Integer userId) throws Exception;

    String saveUser(LyjUser user);

    /**
     * create by: yangchenxiao
     * create time: 2019/8/11 16:40
     * description: 用户登录
     */
    LyjUser loginUser(String phone,String password) throws Exception;

    /**
     * create by: yangchenxiao
     * create time: 2019/8/11 16:49
     * description: 根据唯一标识找到用户
     */
    LyjUser getUserByInfo(String userUUID) throws Exception;

    /**
     * create by: yangchenxiao
     * create time: 2019/8/12 21:39
     * description: 根据手机号检查是否重复
     */
    boolean checkPhone(String phone);

    /**
     * create by: yangchenxiao
     * create time: 2019/8/20 21:41
     * description: 丰富用户信息(年龄 评分 做工时间)
     */
    LyjUser setUserBasicInfo(LyjUser user) throws Exception;

    void updateUser(LyjUser user);

    void removeUser(Integer id);

}
