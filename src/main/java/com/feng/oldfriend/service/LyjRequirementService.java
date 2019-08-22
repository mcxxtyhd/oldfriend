package com.feng.oldfriend.service;

import com.feng.oldfriend.entity.LyjRequirement;
import com.feng.oldfriend.entity.LyjRequirementType;
import com.feng.oldfriend.entity.LyjRequirementtypeRelation;

import java.util.List;

public interface LyjRequirementService {

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 11:05
     * description: 根据搜索条件进行查找
     */
    List<LyjRequirement> getRequirements(String searchText,Integer typeId);

    Integer getRequirementCount(String searchText,Integer typeId);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/28 14:46
     * description: 根据需求ID查找到详情
     */
    LyjRequirement getRequirementById(Integer requirementId);

    /**
     * create by: yangchenxiao
     * create time: 2019/8/10 14:55
     * description: 根据需求ID查询到所有的需求类型
     */
    List<LyjRequirementType> getTypesById(Integer requirementId);

    /**
     * create by: yangchenxiao
     * create time: 2019/8/18 11:21
     * description: 我创建的需求
     */
    List<LyjRequirement> getMyRequirement(String uuid);

    /**
     * create by: yangchenxiao
     * create time: 2019/8/18 11:21
     * description: 我申请中标了的请求
     */
    List<LyjRequirement> getMyApplyRequirement(String uuid);

    void saveRequirement(Integer typeId,LyjRequirement lyjRequirement);

    void updateRequirement(LyjRequirement lyjRequirement);

    void removeRequirement(Integer id);
}
