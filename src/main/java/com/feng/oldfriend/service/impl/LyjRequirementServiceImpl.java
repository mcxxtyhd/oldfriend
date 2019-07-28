package com.feng.oldfriend.service.impl;

import com.feng.oldfriend.dao.LyjRequirementMapper;
import com.feng.oldfriend.dao.LyjRequirementtypeRelationMapper;
import com.feng.oldfriend.entity.LyjRequirement;
import com.feng.oldfriend.entity.LyjRequirementtypeRelation;
import com.feng.oldfriend.service.LyjRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("LyjRequirementService")
public class LyjRequirementServiceImpl implements LyjRequirementService {

    @Autowired
    private LyjRequirementMapper lyjRequirementMapper;
    @Autowired
    private LyjRequirementtypeRelationMapper lyjRequirementtypeRelationMapper;

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 11:25
     * description: 根据搜索条件获取需求数据
     */
    @Override
    public List<LyjRequirement> getRequirements(String searchText,Integer typeId) {

        //判断需求类型ID是否为空，根据是否为空来提出两个不同的解决方案
        if(null==typeId){
            return lyjRequirementMapper.getLyjRequirements(searchText);
        }else{
            return lyjRequirementMapper.getLyjRequirementsByTypeId(searchText,typeId);
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/28 14:46
     * description: 根据需求ID查找到详情
     */
    @Override
    public LyjRequirement getRequirementById(Integer requirementId) {
        return lyjRequirementMapper.selectByPrimaryKey(requirementId);
    }

    @Override
    @Transactional
    public void saveRequirement(Integer typeId,LyjRequirement lyjRequirement) {
        //1、先增加需求
        lyjRequirement.setLyjRequirementCreatedatetime(new Date());
        lyjRequirementMapper.insert(lyjRequirement);
        Integer requirementId=lyjRequirement.getLyjRequirementId();
        //2、再增加需求和类型关系表的数据
        lyjRequirementtypeRelationMapper.insert(new LyjRequirementtypeRelation(requirementId,typeId));
    }

    @Override
    public void updateRequirement(LyjRequirement lyjRequirement) {
        lyjRequirementMapper.updateByPrimaryKey(lyjRequirement);
    }

    @Override
    @Transactional
    public void removeRequirement(Integer id) {
        //1、删除所有的类型关系表中的数据
        lyjRequirementtypeRelationMapper.deleteByRequirementId(id);

        //2、删除该需求数据
        lyjRequirementMapper.deleteByPrimaryKey(id);
    }
}
