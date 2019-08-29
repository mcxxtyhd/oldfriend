package com.feng.oldfriend.service.impl;

import com.feng.oldfriend.dao.LyjRequirementApplyMapper;
import com.feng.oldfriend.dao.LyjRequirementMapper;
import com.feng.oldfriend.entity.LyjRequirement;
import com.feng.oldfriend.entity.LyjRequirementApply;
import com.feng.oldfriend.entity.LyjRequirementApplyField;
import com.feng.oldfriend.entity.LyjRequirementType;
import com.feng.oldfriend.enums.ApplyStatus;
import com.feng.oldfriend.service.LyjRequirementApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("LyjRequirementApplyService")
public class LyjRequirementApplyServiceImpl implements LyjRequirementApplyService {

    @Autowired
    private LyjRequirementApplyMapper lyjRequirementApplyMapper;

    @Autowired
    private LyjRequirementMapper lyjRequirementMapper;

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
    public List<LyjRequirementApplyField> getRequirementByParams(String searchText, String uuid, Integer status) {

        //先拿到所有的数据
        List<LyjRequirementApplyField> Result=lyjRequirementApplyMapper.getRequirementByParams(searchText,uuid,status);

        List<LyjRequirementApplyField> newResult=new ArrayList<>();

        //再遍历  将需求类型加进去
        for(LyjRequirementApplyField single:Result){
            List<LyjRequirementType> singleAllTypes=lyjRequirementMapper.getTypesById(single.getLyj_requirement_id());
            single.setAllTypes(singleAllTypes);
            newResult.add(single);
        }

        return newResult;
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 11:05
     * description: 根据参数(搜索内容,唯一标识ID，需求的状态)进行查找
     */
    @Override
    public List<LyjRequirementApplyField> getRequirementByParamsType(String searchText, String uuid, Integer status,Integer typeid) {

        //先拿到所有的数据
        List<LyjRequirementApplyField> oldResult=lyjRequirementApplyMapper.getRequirementByParams(searchText,uuid,status);

        List<LyjRequirementApplyField> newResult=new ArrayList<>();

        //再遍历  将需求类型加进去
        for(LyjRequirementApplyField single:oldResult){
            boolean findFlag=false;
            List<LyjRequirementType> singleAllTypes=lyjRequirementMapper.getTypesById(single.getLyj_requirement_id());
            for(LyjRequirementType singleType:singleAllTypes){
                //如果找到了 跳出循环
                if(singleType.getLyjRequirementTypeid().equals(typeid)){
                    findFlag=true;
                    break;
                }
            }
            //如果找到了 就加入到集合之中
            if(findFlag==true){
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
    public List<LyjRequirementApplyField> getRequirementByIdStatus(Integer applyid, Integer status) {
        return lyjRequirementApplyMapper.getRequirementByIdStatus(applyid,status);
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

        //1、将除了某个申请ID外的其他同一申请需求的申请置为申请失败
        if(LyjRequirementApply.getLyjRequirementApplystate()==3){
            this.updateApplyFailed(LyjRequirementApply.getLyjRequirementApplyrequirementid(),LyjRequirementApply.getLyjRequirementApplyid());
        }

        //2、然后更新此状态
        lyjRequirementApplyMapper.updateByPrimaryKey(LyjRequirementApply);
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
    public void updateRequirementApplyStatus(Integer applyId, Integer status) {
        //1、将除了某个申请ID外的其他同一申请需求的申请置为申请失败
        if(status==3){
            this.updateApplyFailed(lyjRequirementApplyMapper.selectByPrimaryKey(applyId).getLyjRequirementApplyrequirementid()
                    ,applyId);
        }

        //2、然后更新此状态
        lyjRequirementApplyMapper.updateRequirementApplyStatus(applyId,status);
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
        Integer status=ApplyStatus.FAILED.getCode();
        lyjRequirementApplyMapper.updateApplyFailed(requirementId,requirementApplyId,status);
    }
}
