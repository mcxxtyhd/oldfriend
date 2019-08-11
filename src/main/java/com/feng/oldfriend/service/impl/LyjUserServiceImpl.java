package com.feng.oldfriend.service.impl;

import com.feng.oldfriend.Utils.Md5Util;
import com.feng.oldfriend.dao.LyjUserMapper;
import com.feng.oldfriend.entity.LyjUser;
import com.feng.oldfriend.service.LyjUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LyjUserService")
public class LyjUserServiceImpl implements LyjUserService {

    @Autowired
    private LyjUserMapper lyjUserMapper;

    /**
     * create by: yangchenxiao
     * create time: 2019/7/28 14:59
     * description: 根据搜索内容拿到指定的信息
     */
    @Override
    public List<LyjUser> getUsers(String searchText) {
        return lyjUserMapper.getUsers(searchText);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/28 14:59
     * description: 根据用户ID拿到详情
     */
    @Override
    public LyjUser getUserById(Integer userId) {
        return lyjUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public String saveUser(LyjUser user) {
        //根据手机号码和密码生成用户唯一标识
        String encryptUserInfo= Md5Util.string2MD5(user.getLyjUserPhone()+user.getLyjUserPassword());
        user.setLyjUserUuid(encryptUserInfo);

        lyjUserMapper.insert(user);

        return encryptUserInfo;
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/8/11 16:40
     * description: 用户登录
     */
    @Override
    public LyjUser loginUser(String phone,String password) {
        return lyjUserMapper.userLogin(phone,password);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/8/11 16:49
     * description: 根据唯一标识找到用户
     */
    @Override
    public LyjUser getUserByInfo(String userUUID) {
        return lyjUserMapper.findUserByUUID(userUUID);
    }

    @Override
    public void updateUser(LyjUser user) {
        lyjUserMapper.updateByPrimaryKey(user);
    }

    @Override
    public void removeUser(Integer id) {
        lyjUserMapper.deleteByPrimaryKey(id);
    }
}
