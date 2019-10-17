package com.feng.oldfriend.service.impl;

import com.alibaba.fastjson.JSON;
import com.feng.oldfriend.Utils.DataUtils;
import com.feng.oldfriend.VO.BatchUserState;
import com.feng.oldfriend.dao.LyjBlacklistMapper;
import com.feng.oldfriend.dao.LyjRequirementApplyMapper;
import com.feng.oldfriend.dao.LyjRequirementMapper;
import com.feng.oldfriend.dao.LyjVolunteerMapper;
import com.feng.oldfriend.entity.*;
import com.feng.oldfriend.enums.ApplyStatus;
import com.feng.oldfriend.service.LyjRequirementApplyService;
import com.feng.oldfriend.service.LyjRequirementService;
import com.feng.oldfriend.service.LyjUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service("LyjRequirementApplyService")
public class LyjRequirementApplyServiceImpl implements LyjRequirementApplyService {

    @Autowired
    private LyjRequirementApplyMapper lyjRequirementApplyMapper;

    @Autowired
    private LyjRequirementMapper lyjRequirementMapper;

    @Autowired
    private LyjRequirementService lyjRequirementService;

    @Autowired
    private LyjUserService lyjUserService;

    @Autowired
    private LyjVolunteerMapper lyjVolunteerMapper;

    @Autowired
    private LyjBlacklistMapper lyjBlacklistMapper;


    /**
     * create by: yangchenxiao
     * create time: 2019/7/24 21:53
     * description: 根据需求ID查询所有的申请
     */
    @Override
    public List<LyjRequirementApply> getRequirementApplys(Integer requirementId) {
        return lyjRequirementApplyMapper.selectByRequirementId(requirementId);
    }

    @Override
    public Integer getRequirementApplysCount(Integer requirementId) {
        return lyjRequirementApplyMapper.getRequirementApplysCount(requirementId);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 11:05
     * description: 根据参数(搜索内容,唯一标识ID)进行查找
     */
    @Override
    public List<LyjRequirementApplyField> getRequirementByParams(String searchText, String uuid, Integer[] status) {

        //先拿到所有的数据
        List<LyjRequirementApplyField> Result = lyjRequirementApplyMapper.getRequirementByParams(searchText, uuid, status);

        List<LyjRequirementApplyField> newResult = new ArrayList<>();

        //再遍历  将需求类型加进去
        for (LyjRequirementApplyField single : Result) {
            List<LyjRequirementType> singleAllTypes = lyjRequirementMapper.getTypesById(single.getLyj_requirement_id());
            single.setAllTypes(singleAllTypes);
            newResult.add(single);
        }

        return newResult;
    }

    @Override
    public Integer getRequirementByParamsCount(String searchText, String uuid, Integer[] status) {
        return lyjRequirementApplyMapper.getRequirementByParamsCount(searchText, uuid, status);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 11:05
     * description: 根据参数(搜索内容,唯一标识ID，需求的状态)进行查找
     */
    @Override
    public List<LyjRequirementApplyField> getRequirementByParamsType(String searchText, String uuid, Integer[] status, Integer typeid) {

        //先拿到所有的数据
        List<LyjRequirementApplyField> oldResult = lyjRequirementApplyMapper.getRequirementByParams(searchText, uuid, status);

        List<LyjRequirementApplyField> newResult = new ArrayList<>();

        //再遍历  将需求类型加进去
        for (LyjRequirementApplyField single : oldResult) {
            boolean findFlag = false;
            List<LyjRequirementType> singleAllTypes = lyjRequirementMapper.getTypesById(single.getLyj_requirement_id());
            for (LyjRequirementType singleType : singleAllTypes) {
                //如果找到了 跳出循环
                if (singleType.getLyjRequirementTypeid().equals(typeid)) {
                    findFlag = true;
                    break;
                }
            }
            //如果找到了 就加入到集合之中
            if (findFlag == true) {
                single.setAllTypes(singleAllTypes);
                newResult.add(single);
            }
        }

        return newResult;
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/8/18 11:29
     * description: 根据需求ID和状态查询需求申请的数据
     */
    @Override
    public List<LyjRequirementApplyField> getRequirementByIdStatus(Integer applyid, Integer status) throws Exception{
        List<LyjRequirementApplyField> result=lyjRequirementApplyMapper.getRequirementByIdStatus(applyid, status);

        for(LyjRequirementApplyField single:result){
            LyjUser user=new LyjUser();
            String currentUUID="";
            //如果用户姓名等于空 就再去volunter里面去找一下用户信息
            if(single.getLyj_user_name()==null){
                user=lyjUserService.getUserByInfo(lyjVolunteerMapper.selectByPrimaryKey(single.getLyj_volunteer_id()).getLyjUserId());
            }else{
                user=lyjUserService.getUserByInfo(single.getLyj_user_id());
            }
            single.setLyj_user_id(user.getLyjUserUuid());
            single.setLyj_user_name(user.getLyjUserName());
            single.setLyj_user_phone(user.getLyjUserPhone());
            single.setLyj_requirement_applyduration(user.getLyjUserAllduration());
            //星级评价
//            single.setLyj_user_avestar(xx);
        }
        return result;
    }

    @Override
    public void saveRequirementApply(LyjRequirementApply lyjRequirementApply) {
        lyjRequirementApplyMapper.insert(lyjRequirementApply);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/24 21:57
     * description: 更新某个需求的内容
     */
    @Override
    @Transactional
    public void updateRequirementApply(LyjRequirementApply LyjRequirementApply) {

        //1、如果是更改为待完成  就往需求上加已申请的人数
        if (LyjRequirementApply.getLyjRequirementApplystate() == 3) {
//            this.updateApplyFailed(LyjRequirementApply.getLyjRequirementApplyrequirementid(), LyjRequirementApply.getLyjRequirementApplyid());

            //根据需求申请找到对应的需求
            LyjRequirement requirement=lyjRequirementMapper.selectByPrimaryKey(LyjRequirementApply.getLyjRequirementApplyrequirementid());
            //需求当前人数
            Integer currentNum=requirement.getLyjRequirementApplyednum();
            //将申请的加上
            requirement.setLyjRequirementApplyednum(currentNum+1);
            //改变需求状态
            lyjRequirementMapper.updateByPrimaryKeyNormal(requirement);
        }

        //2、然后更新此状态
        lyjRequirementApplyMapper.updateByPrimaryKey(LyjRequirementApply);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/11 22:07
     * description: 批量更新需求申请的状态
     */
    @Override
    @Transactional
    public Boolean batchUpdateApplyState(BatchUserState datas) throws Exception{

        //如果是更改为待完成  就往需求上加已申请的人数
        if(datas.getState()==3){
            //根据需求申请找到对应的需求
            LyjRequirement requirement=lyjRequirementMapper.selectByPrimaryKey(lyjRequirementApplyMapper.selectByPrimaryKey(datas.getIds().get(0)).getLyjRequirementApplyrequirementid());
            //需求当前人数
            Integer currentNum=requirement.getLyjRequirementApplyednum();
            //需要的人数
            Integer needNum=requirement.getLyjRequirementNum();

            //这次更新的数据数
            Integer changeNum=currentNum+datas.getIds().size();

            //如果大于 则说明人数超标了
            if(changeNum>needNum){
                return false;
            }

            //将申请的加上
            requirement.setLyjRequirementApplyednum(changeNum);
            //改变需求状态
            lyjRequirementMapper.updateByPrimaryKeyNormal(requirement);
        }

        //1.5完成时 需要将完成的时间加到用户身上 还有积分
        if (datas.getState() == 5) {
            for(Integer single:datas.getIds()){
                LyjRequirementApply currentData = lyjRequirementApplyMapper.selectByPrimaryKey(single);
                LyjRequirement lyjRequirement = lyjRequirementService.getRequirementById(currentData.getLyjRequirementApplyrequirementid());
                Integer minutes = DataUtils.getMinutes(lyjRequirement.getLyjRequirementBegindatetime(), lyjRequirement.getLyjRequirementEnddatetime());

                LyjUser currentUser = new LyjUser();
                //2.再把这个东西放到用户上  先看有没有志愿者 再看uuid
                if (currentData.getLyjVolunteerId() != null) {
                    //找到该用户
                    currentUser = lyjUserService.getUserByInfo(lyjVolunteerMapper.selectByPrimaryKey(currentData.getLyjVolunteerId()).getLyjUserId());
                } else {
                    currentUser = lyjUserService.getUserByInfo(currentData.getLyjUserId());
                }
                //最后再更新
                currentUser.setAllDuration(currentUser.getAllDuration() + minutes);
                //这个是积分
                currentUser.setLyjUserRewards(currentUser.getLyjUserRewards()+lyjRequirement.getLyjRequirementReward());
                lyjUserService.updateUser(currentUser);
            }
        }

        //改变申请状态
        lyjRequirementApplyMapper.batchUpdateApplyState(datas);

        return true;
    }

    @Override
    public void delRequirementApply(Integer id) {
        lyjRequirementApplyMapper.deleteByPrimaryKey(id);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/8/19 19:53
     * description: 根据需求ID和状态码更改
     */
    @Override
    @Transactional
    public Integer updateRequirementApplyStatus(Integer applyId, Integer status) throws Exception {
        Integer resultStatus = 0;

        //1、更新需求人数
        if (status == 3) {
            //根据需求申请找到对应的需求
            LyjRequirement requirement=lyjRequirementMapper.selectByPrimaryKey(lyjRequirementApplyMapper.selectByPrimaryKey(applyId).getLyjRequirementApplyrequirementid());
            //需求当前人数
            Integer currentNum=requirement.getLyjRequirementApplyednum();
            //将申请的加上
            requirement.setLyjRequirementApplyednum(currentNum+1);
            //改变需求状态
            lyjRequirementMapper.updateByPrimaryKeyNormal(requirement);
        }

        //1.5完成时 需要将完成的时间加到用户身上 还有积分
        if (status == 5) {
            LyjRequirementApply currentData = lyjRequirementApplyMapper.selectByPrimaryKey(applyId);
            //1.先计算这个需求耗时多久
            LyjRequirement lyjRequirement = lyjRequirementService.getRequirementById(currentData.getLyjRequirementApplyrequirementid());
            Integer minutes = DataUtils.getMinutes(lyjRequirement.getLyjRequirementBegindatetime(), lyjRequirement.getLyjRequirementEnddatetime());

            LyjUser currentUser = new LyjUser();
            //2.再把这个东西放到用户上  先看有没有志愿者 再看uuid
            if (currentData.getLyjVolunteerId() != null) {
                //找到该用户
                currentUser = lyjUserService.getUserByInfo(lyjVolunteerMapper.selectByPrimaryKey(currentData.getLyjVolunteerId()).getLyjUserId());
            } else {
                currentUser = lyjUserService.getUserByInfo(currentData.getLyjUserId());
            }
            //最后再更新
            currentUser.setAllDuration(currentUser.getAllDuration() + minutes);
            //这个是积分
            currentUser.setLyjUserRewards(currentUser.getLyjUserRewards()+lyjRequirement.getLyjRequirementReward());
            lyjUserService.updateUser(currentUser);
        }

        //2、然后更新此状态
        lyjRequirementApplyMapper.updateRequirementApplyStatus(applyId, status);

        return resultStatus;
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/8/20 21:55
     * description: 评价 打分 输入持续时间 输入评价
     */
    @Override
    public void JudgeRequirementApply(Integer applyId, Integer star, String comment, Integer duration) {
        lyjRequirementApplyMapper.JudgeRequirementApply(applyId, star, comment, duration);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/24 21:57
     * description: 将除了某个申请ID外的其他同一申请需求的申请置为申请失败
     */
    @Override
    public void updateApplyFailed(Integer requirementId, Integer requirementApplyId) {
        Integer status = ApplyStatus.FAILED.getCode();
        lyjRequirementApplyMapper.updateApplyFailed(requirementId, requirementApplyId, status);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/28 16:37
     * description: 定时任务
     */
    @Override
    public void updateApplyFinish() {
        log.info("以下是定时任务处理的需求申请数据:"+JSON.toJSON(lyjRequirementApplyMapper.selectApplyFinish()));
        lyjRequirementApplyMapper.updateApplyFinish();
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/10/8 21:52
     * description: 检查当前用户是否能够申请该需求
     */
    @Override
    public Boolean checkIfBeApplied(Integer requirementId, String uuid) {

        //其实就判断以下两个条件

        // 1、需求申请中 是否已经有同样的需求iD 和 uuid
        Integer firstJudge=lyjRequirementApplyMapper.selectByRequirementAndUUID(requirementId,uuid);
        if(firstJudge>0){
            return false;
        }

        // 2、从已经申请了的需求中  状态等于1,3,4的  新申请的需求 开始时间和结束时间必须要么 同时大于 要么同时小于
        LyjRequirement currentData=lyjRequirementMapper.selectByPrimaryKey(requirementId);
        Integer secondJudge=lyjRequirementMapper.selectByDate(currentData.getLyjRequirementBegindatetime(),currentData.getLyjRequirementEnddatetime(),uuid);
        if(secondJudge>0){
            return false;
        }

        //3、这个人是否在黑名单之中
        if(lyjBlacklistMapper.selectByUUID(uuid)!=null){
            return false;
        }

        return true;
    }
}
