package com.feng.oldfriend.service;

import com.feng.oldfriend.entity.LyjRequirement;

import java.util.List;

public interface LyjRequirementService {

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 11:05
     * description: 根据搜索条件进行查找
     */
    List<LyjRequirement> getRequirements(String searchText,Integer typeId);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/28 14:46
     * description: 根据需求ID查找到详情
     */
    LyjRequirement getRequirementById(Integer requirementId);

    void saveRequirement(Integer typeId,LyjRequirement lyjRequirement);

    void updateRequirement(LyjRequirement lyjRequirement);

    void removeRequirement(Integer id);
}
