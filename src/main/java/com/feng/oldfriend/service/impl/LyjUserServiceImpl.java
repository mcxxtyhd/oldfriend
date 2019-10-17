package com.feng.oldfriend.service.impl;

import com.feng.oldfriend.Utils.MathUtils;
import com.feng.oldfriend.Utils.Md5Util;
import com.feng.oldfriend.VO.BatchUserState;
import com.feng.oldfriend.dao.*;
import com.feng.oldfriend.entity.LyjCompany;
import com.feng.oldfriend.entity.LyjCompanyuserRelation;
import com.feng.oldfriend.entity.LyjRequirementApply;
import com.feng.oldfriend.entity.LyjUser;
import com.feng.oldfriend.service.LyjCompanyService;
import com.feng.oldfriend.service.LyjUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service("LyjUserService")
public class LyjUserServiceImpl implements LyjUserService {

    @Autowired
    private LyjUserMapper lyjUserMapper;

    @Autowired
    private LyjRequirementApplyMapper lyjRequirementApplyMapper;

    @Autowired
    private SysRoleuserRelationMapper sysRoleuserRelationMapper;

    @Autowired
    private SysRolepermissionRelationMapper sysRolepermissionRelationMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Autowired
    private LyjCompanyService lyjCompanyService;

    @Autowired
    private LyjCompanyuserRelationMapper lyjCompanyuserRelationMapper;

    /**
     * create by: yangchenxiao
     * create time: 2019/9/11 21:17
     * description: 批量更新用户的审批状态
     */
    @Override
    public void batchUpdateUserStatus(BatchUserState datas) {
        lyjUserMapper.batchUpdateUserStatus(datas);
    }

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

        //這個是時長  個人得分 年龄
        user.setAllDuration(AllDuration);
        user.setPersonalStar(MathUtils.convertToStar(allStars));
        user.setLyjUserAge(MathUtils.getAgeByBirth(user.getLyjUserBirthday()));

        //下面这个是放权限
        //这个是找角色
        List<String> roleIds=sysRoleuserRelationMapper.selectRoleIdsByUUID(user.getLyjUserUuid());

        List<String> permissionIds=sysRolepermissionRelationMapper.selectPermissionidsByRoleids(roleIds);
        //最后是根据ID找到名称
        List<String> permissionNames=sysPermissionMapper.selectByPermissionids(permissionIds);

        HashSet allPermissions=new HashSet();
        for(String permission:permissionNames){
            allPermissions.add(permission);
        }
        user.setPermissions(allPermissions);

        //这个是所属机构
        user.setCompanyIds(lyjCompanyService.getCompanyIdsByUUID(user.getLyjUserUuid()));

        return user;
    }

    @Override
    public Integer getUsersCount(String searchText) {
        return lyjUserMapper.getUsersCount(searchText);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/8 14:37
     * description: 根据用户状态搜索用户
     */
    @Override
    public List<LyjUser> getUsersByStatus(String searchText, String status) throws Exception {
        return lyjUserMapper.getUsersByStatus(searchText,status);
    }

    @Override
    public Integer getUsersCountByStatus(String searchText, String status) {
        return lyjUserMapper.getUsersCountByStatus(searchText,status);
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

        //在增加用户机构关系
        if(user.getCompanyIds().size()>0){
            LyjCompanyuserRelation data=new LyjCompanyuserRelation();
            data.setLyjCuRelationCompanyid(user.getCompanyIds().get(0));
            data.setLyjCuRelationUuid(user.getLyjUserUuid());
            lyjCompanyuserRelationMapper.insert(data);
        }

        return encryptUserInfo;
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/3 21:56
     * description: 根据openid生成用户
     */
    @Override
    public String saveWxUser(LyjUser user) {
        //根据手机号码和密码生成用户唯一标识
        String encryptUserInfo= Md5Util.string2MD5(user.getLyjUserOpenid());
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
     * create time: 2019/9/6 21:30
     * description: 根据唯一标识找到用户的所有权限
     */
    @Override
    public HashSet<String> getUserPermissionByUUID(String userUUID) {
        return null;
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/3 21:51
     * description: 根据openid找到用户
     */
    @Override
    public LyjUser getUserByOpenid(String openid) throws Exception {
        return lyjUserMapper.findUserByOpenId(openid);
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

    /**
     * create by: yangchenxiao
     * create time: 2019/9/8 15:25
     * description: 修改用户状态
     */
    @Override
    public void updateUserStatus(LyjUser user) {
        lyjUserMapper.updateStatus(user);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/11 20:57
     * description: 根据UUID和密码找到用户
     */
    @Override
    public LyjUser findUserByUuidAndPassword(LyjUser user) {
        return lyjUserMapper.findUserByUuidAndPassword(user);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/8 16:57
     * description: 修改用户密码
     */
    @Override
    public void updateUserPassword(LyjUser user) {
        lyjUserMapper.updateUserPassword(user);
    }

    @Override
    public void removeUser(Integer id) {
        lyjUserMapper.deleteByPrimaryKey(id);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/9 21:35
     * description: 根据机构查询用户
     */
    @Override
    public List<LyjUser> getUsersByCompany(Integer state,Integer companyId,String searchText) {
        return lyjUserMapper.getUsersByCompany(state,companyId,searchText);
    }

    @Override
    public Integer getUsersByCompanyCount(Integer state,Integer companyId,String searchText) {
        return lyjUserMapper.getUsersByCompanyCount(state,companyId,searchText);
    }
}
