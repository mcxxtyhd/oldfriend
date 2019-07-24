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

    void saveRequirement(Integer typeId,LyjRequirement lyjRequirement);

    void updateRequirement(LyjRequirement lyjRequirement);

    void removeRequirement(Integer id);
}
