package com.feng.oldfriend.service.impl;

import com.feng.oldfriend.dao.LyjUserMapper;
import com.feng.oldfriend.dao.LyjVolunteerMapper;
import com.feng.oldfriend.entity.LyjUser;
import com.feng.oldfriend.entity.LyjVolunteer;
import com.feng.oldfriend.service.LyjVolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("LyjVolunteerService")
public class LyjVolunteerServiceImpl implements LyjVolunteerService {

    @Autowired
   private LyjVolunteerMapper lyjVolunteerMapper;

    @Autowired
    private LyjUserMapper lyjUserMapper;


    @Override
    public List<LyjVolunteer> getAllVolunteer(String searchText,Integer state) {
        return lyjVolunteerMapper.selectAll(searchText,state);
    }

    @Override
    public List<LyjUser> getAllVolunteerTop(String searchText) {
        return lyjUserMapper.getAllVolunteerTop(searchText);
    }

    @Override
    public Integer getAllVolunteerCount(String searchText,Integer state) {
        return lyjVolunteerMapper.selectAllCount(searchText,state);
    }

    @Override
    public LyjVolunteer getVolunteerByUserId(String userId) {
        return lyjVolunteerMapper.getVolunteerByUserId(userId);
    }

    @Override
    public LyjVolunteer getVolunteerByVolunteerId(Integer volunteerId) {
        return lyjVolunteerMapper.selectByPrimaryKey(volunteerId);
    }

    @Override
    public Integer saveVolunteer(String userid) {
        LyjVolunteer newObject=new LyjVolunteer();
        newObject.setLyjUserId(userid);
        lyjVolunteerMapper.insert(newObject);
        return newObject.getLyjVolunteerId();
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/8/13 22:30
     * description: 成为义工
     */
    @Override
    @Transactional
    public void becomeVolunteer(LyjUser user) {

        //1、先新增义工(前台传过来的接口是没有userid的)
        user.setLyjUserId(lyjUserMapper.findUserByUUID(user.getLyjUserUuid()).getLyjUserId());
        LyjVolunteer newObject=new LyjVolunteer();
        newObject.setLyjUserId(user.getLyjUserUuid());
        lyjVolunteerMapper.insert(newObject);

        //2、再更新用户
        lyjUserMapper.updateByPrimaryKeyForVolunteer(user);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/10/13 22:11
     * description: 义工的信息编辑
     */
    @Override
    public void eidtVolunteer(LyjUser lyjUser) {
        lyjUserMapper.updateByPrimaryByUUID(lyjUser);
    }

    @Override
    public void removeVolunteer(Integer id) {
        lyjVolunteerMapper.deleteByPrimaryKey(id);
    }
}
