package com.feng.oldfriend.service.impl;

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
    public void saveUser(LyjUser user) {
        lyjUserMapper.insert(user);
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
