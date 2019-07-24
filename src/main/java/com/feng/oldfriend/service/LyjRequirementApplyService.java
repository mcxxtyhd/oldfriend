package com.feng.oldfriend.service;

import com.feng.oldfriend.entity.LyjRequirementApply;

import java.util.List;

public interface LyjRequirementApplyService {

    /**
     * create by: yangchenxiao
     * create time: 2019/7/24 21:53
     * description: 根据需求ID查询所有的申请
     */
    List<LyjRequirementApply> getRequirementApplys(Integer requirementId);

    void saveRequirementApply(LyjRequirementApply lyjRequirementApply);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/24 21:57
     * description: 更新某个需求的内容
     */
    void updateRequirementApply(LyjRequirementApply LyjRequirementApply);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/24 21:57
     * description: 将除了某个申请ID外的其他同一申请需求的申请置为申请失败
     */
    void updateApplyFailed(Integer requirementId,Integer requirementApplyId);
    
    
}
