package com.feng.oldfriend.service.impl;

import com.feng.oldfriend.dao.LyjRequirementApplyMapper;
import com.feng.oldfriend.entity.LyjRequirementApply;
import com.feng.oldfriend.enums.ApplyStatus;
import com.feng.oldfriend.service.LyjRequirementApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LyjRequirementApplyService")
public class LyjRequirementApplyServiceImpl implements LyjRequirementApplyService {

    @Autowired
    private LyjRequirementApplyMapper lyjRequirementApplyMapper;

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
    public void saveRequirementApply(LyjRequirementApply lyjRequirementApply) {
        lyjRequirementApplyMapper.insert(lyjRequirementApply);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/24 21:57
     * description: 更新某个需求的内容
     */
    @Override
    public void updateRequirementApply(LyjRequirementApply LyjRequirementApply) {
        lyjRequirementApplyMapper.updateByPrimaryKey(LyjRequirementApply);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/24 21:57
     * description: 将除了某个申请ID外的其他同一申请需求的申请置为申请失败
     */
    @Override
    public void updateApplyFailed(Integer requirementId, Integer requirementApplyId) {
        Integer status=ApplyStatus.END.getCode();
        lyjRequirementApplyMapper.updateApplyFailed(requirementId,requirementApplyId,status);
    }
}
