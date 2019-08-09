package com.feng.oldfriend.service.impl;

import com.feng.oldfriend.dao.LyjVolunteerMapper;
import com.feng.oldfriend.entity.LyjVolunteer;
import com.feng.oldfriend.service.LyjVolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LyjVolunteerService")
public class LyjVolunteerServiceImpl implements LyjVolunteerService {

    @Autowired
   private LyjVolunteerMapper lyjVolunteerMapper;


    @Override
    public List<LyjVolunteer> getAllVolunteer() {
        return lyjVolunteerMapper.selectAll();
    }

    @Override
    public List<LyjVolunteer> getVolunteerByUserId(Integer userId) {
        return lyjVolunteerMapper.getVolunteerByUserId(userId);
    }

    @Override
    public List<LyjVolunteer> getVolunteerByVolunteerId(Integer volunteerId) {
        return lyjVolunteerMapper.selectByPrimaryKey(volunteerId);
    }

    @Override
    public void saveVolunteer(LyjVolunteer lyjVolunteer) {
        lyjVolunteerMapper.insert(lyjVolunteer);
    }

    @Override
    public void removeVolunteer(Integer id) {
        lyjVolunteerMapper.deleteByPrimaryKey(id);
    }
}
