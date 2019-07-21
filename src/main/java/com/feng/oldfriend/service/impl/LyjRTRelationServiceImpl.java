package com.feng.oldfriend.service.impl;

import com.feng.oldfriend.dao.LyjRequirementtypeRelationMapper;
import com.feng.oldfriend.entity.LyjRequirement;
import com.feng.oldfriend.entity.LyjRequirementtypeRelation;
import com.feng.oldfriend.service.LyjRTRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("LyjRTRelationService")
public class LyjRTRelationServiceImpl implements LyjRTRelationService {

    @Autowired
    private LyjRequirementtypeRelationMapper lyjRequirementtypeRelationMapper;

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 14:36
     * description: 根据需求类型ID找到所有的需求ID
     */
    @Override
    public List<Integer> getRequirementsByTypeid(Integer typeId) {
        return lyjRequirementtypeRelationMapper.getRequirementidsByTypeid(typeId);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 17:37
     * description: 根据需求ID和类型ID集合增加关系数据
     */
    @Override
    @Transactional
    public void addRTRelation(Integer requirementId, Integer[] typeIds) {
        for(Integer single:typeIds){
            lyjRequirementtypeRelationMapper.insert(new LyjRequirementtypeRelation(requirementId,single));
        }
    }

    @Override
    @Transactional
    public void addRTRelationAdvanced(Integer requirementId, Integer[] typeIds) {
        //1、先删除
        lyjRequirementtypeRelationMapper.deleteByRequirementId(requirementId);
        //2、再新增
        for(Integer single:typeIds){
            lyjRequirementtypeRelationMapper.insert(new LyjRequirementtypeRelation(requirementId,single));
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 16:56
     * description: 根据需求ID删除所有的关系数据
     */
    @Override
    public void removeRTRelationByRid(Integer requirementId) {
        lyjRequirementtypeRelationMapper.deleteByRequirementId(requirementId);
    }
}
