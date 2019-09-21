package com.feng.oldfriend.service;

import com.feng.oldfriend.VO.BatchUserState;
import com.feng.oldfriend.entity.LyjCompany;
import com.feng.oldfriend.entity.LyjUser;

import java.util.HashSet;
import java.util.List;

public interface LyjUserService {

    /**
     * create by: yangchenxiao
     * create time: 2019/9/11 21:17
     * description: 批量更新用户的审批状态
     */
    void batchUpdateUserStatus(BatchUserState datas);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/28 14:58
     * description: 根据搜索内容找到对应的信息
     */
    List<LyjUser> getUsers(String searchText) throws Exception;

    Integer getUsersCount(String searchText) ;

    /**
     * create by: yangchenxiao
     * create time: 2019/9/8 14:37
     * description: 根据用户状态搜索用户
     */
    List<LyjUser> getUsersByStatus(String searchText,String status) throws Exception;

    Integer getUsersCountByStatus(String searchText,String status) ;

    /**
     * create by: yangchenxiao
     * create time: 2019/7/28 14:46
     * description: 根据用户ID查找到详情
     */
    LyjUser getUserById(Integer userId) throws Exception;

    String saveUser(LyjUser user);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/3 21:56
     * description: 根据openid生成用户
     */
    String saveWxUser(LyjUser user);


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
     * create time: 2019/9/6 21:30
     * description: 根据唯一标识找到用户的所有权限
     */
    HashSet<String> getUserPermissionByUUID(String userUUID);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/3 21:51
     * description: 根据openid找到用户
     */
    LyjUser getUserByOpenid(String openid) throws Exception;

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

    /**
     * create by: yangchenxiao
     * create time: 2019/9/8 15:25
     * description: 修改用户状态
     */
    void updateUserStatus(LyjUser user);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/11 20:57
     * description: 根据UUID和密码找到用户
     */
    LyjUser findUserByUuidAndPassword(LyjUser user);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/8 16:57
     * description: 修改用户密码
     */
    void updateUserPassword(LyjUser user);

    void removeUser(Integer id);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/9 21:35
     * description: 根据机构查询用户
     */
    List<LyjUser> getUsersByCompany(Integer state,Integer companyId,String searchText);

    Integer getUsersByCompanyCount(Integer state,Integer companyId,String searchText);

}
