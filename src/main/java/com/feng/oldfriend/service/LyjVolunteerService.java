package com.feng.oldfriend.service;

import com.feng.oldfriend.entity.LyjUser;
import com.feng.oldfriend.entity.LyjVolunteer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LyjVolunteerService {

    /**
     * create by: yangchenxiao
     * create time: 2019/8/5 21:25
     * description: 获得所有的义工
     */
    List<LyjVolunteer> getAllVolunteer(String searchText,Integer state);

    /**
     * create by: yangchenxiao
     * create time: 2019/10/17 21:12
     * description: 获取志愿者的排行
     */
    List<LyjUser> getAllVolunteerTop(String searchText);

    Integer getAllVolunteerCount(String searchText,Integer state);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/29 21:50
     * description: 根据用户ID查找到志愿者ID
     */
    LyjVolunteer getVolunteerByUserId(String userId);


    /**
     * create by: yangchenxiao
     * create time: 2019/7/29 21:50
     * description: 根据志愿者ID查找到志愿者
     */
    LyjVolunteer getVolunteerByVolunteerId(Integer volunteerId);

    Integer saveVolunteer(String userid);

    /**
     * create by: yangchenxiao
     * create time: 2019/8/13 22:30
     * description: 成为义工
     */
    void becomeVolunteer(LyjUser user);

    /**
     * create by: yangchenxiao
     * create time: 2019/10/13 22:11
     * description: 义工的信息编辑
     */
    void eidtVolunteer(LyjUser lyjUser);


    void removeVolunteer(Integer id);

}
