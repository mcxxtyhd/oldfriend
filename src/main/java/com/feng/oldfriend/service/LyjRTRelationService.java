package com.feng.oldfriend.service;

import com.feng.oldfriend.entity.LyjRequirement;

import java.util.List;

public interface LyjRTRelationService {

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 14:36
     * description: 根据需求类型ID找到所有的需求ID
     */
    List<Integer> getRequirementsByTypeid(Integer typeId);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 17:37
     * description: 根据需求ID和类型ID集合增加关系数据
     */
    void addRTRelation(Integer requirementId,Integer[] typeIds);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 17:37
     * description: 根据需求ID和类型ID集合增加关系数据(先删除再新增)
     */
    void addRTRelationAdvanced(Integer requirementId,Integer[] typeIds);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 16:56
     * description: 根据需求ID删除所有的关系数据
     */
    void removeRTRelationByRid(Integer id);


}
