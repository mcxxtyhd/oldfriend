package com.feng.oldfriend.service;

import com.feng.oldfriend.entity.LyjUser;
import com.feng.oldfriend.entity.LyjVolunteer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LyjVolunteerService {

    /**
     * create by: yangchenxiao
     * create time: 2019/7/29 21:50
     * description: 根据用户ID查找到志愿者ID
     */
    List<LyjVolunteer> getVolunteerByUserId(Integer userId);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/29 21:50
     * description: 根据志愿者ID查找到志愿者
     */
    List<LyjVolunteer> getVolunteerByVolunteerId(Integer volunteerId);

    void saveVolunteer(LyjVolunteer lyjVolunteer);

    void removeVolunteer(Integer id);

}
