package com.feng.oldfriend.service.impl;

import com.feng.oldfriend.Utils.MathUtils;
import com.feng.oldfriend.Utils.Md5Util;
import com.feng.oldfriend.dao.LyjRequirementApplyMapper;
import com.feng.oldfriend.dao.LyjUserMapper;
import com.feng.oldfriend.entity.LyjRequirementApply;
import com.feng.oldfriend.entity.LyjUser;
import com.feng.oldfriend.service.LyjUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("LyjUserService")
public class LyjUserServiceImpl implements LyjUserService {

    @Autowired
    private LyjUserMapper lyjUserMapper;

    @Autowired
    private LyjRequirementApplyMapper lyjRequirementApplyMapper;

    /**
     * create by: yangchenxiao
     * create time: 2019/7/28 14:59
     * description: 根据搜索内容拿到指定的信息
     */
    @Override
    public List<LyjUser> getUsers(String searchText) throws Exception{

        List<LyjUser> allUsers=lyjUserMapper.getUsers(searchText);

        List<LyjUser> newAllUsers=new ArrayList<>();

        for(LyjUser single:allUsers){
            newAllUsers.add(this.setUserBasicInfo(single));
        }

        return newAllUsers;
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/8/20 21:41
     * description: 丰富用户信息(年龄 评分 做工时间)
     */
    public LyjUser setUserBasicInfo(LyjUser user) throws Exception{
        List<LyjRequirementApply> allDatas=lyjRequirementApplyMapper.selectAllByUuid(user.getLyjUserUuid(),5);
        List<Integer> allStars=new ArrayList<>();
        Integer AllDuration=0;
        for(LyjRequirementApply singleApply:allDatas){
            //累加时长
            if(null!=singleApply.getLyjRequirementApplyduration())AllDuration+=singleApply.getLyjRequirementApplyduration();
            //累加评分
            if(null!=singleApply.getLyjRequirementApplystar())allStars.add(singleApply.getLyjRequirementApplystar());
        }

        user.setAllDuration(AllDuration);
        user.setPersonalStar(MathUtils.convertToStar(allStars));
        user.setLyjUserAge(MathUtils.getAgeByBirth(user.getLyjUserBirthday()));
        return user;
    }

    @Override
    public Integer getUsersCount(String searchText) {
        return lyjUserMapper.getUsersCount(searchText);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/28 14:59
     * description: 根据用户ID拿到详情
     */
    @Override
    public LyjUser getUserById(Integer userId) throws Exception{
        return this.setUserBasicInfo(lyjUserMapper.selectByPrimaryKey(userId));
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
    public LyjUser loginUser(String phone,String password) throws Exception{
        return this.setUserBasicInfo(lyjUserMapper.userLogin(phone,password));
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/8/11 16:49
     * description: 根据唯一标识找到用户
     */
    @Override
    public LyjUser getUserByInfo(String userUUID)  throws Exception{
        return this.setUserBasicInfo(lyjUserMapper.findUserByUUID(userUUID));
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/8/12 21:39
     * description: 根据手机号检查是否重复
     */
    @Override
    public boolean checkPhone(String phone) {
        //不等于空 则说明该手机号码重复
        boolean reuslt=(lyjUserMapper.findUserByPhone(phone)!=0)?false:true;
        return reuslt;
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
