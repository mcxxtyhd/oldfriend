package com.feng.oldfriend.service.impl;

import com.feng.oldfriend.dao.LyjRequirementMapper;
import com.feng.oldfriend.dao.LyjRequirementtypeRelationMapper;
import com.feng.oldfriend.entity.LyjRequirement;
import com.feng.oldfriend.entity.LyjRequirementType;
import com.feng.oldfriend.entity.LyjRequirementVO;
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

    @Override
    public Integer getRequirementCount(String searchText, Integer typeId) {
        //判断需求类型ID是否为空，根据是否为空来提出两个不同的解决方案
        if(null==typeId){
            return lyjRequirementMapper.getLyjRequirementsCount(searchText);
        }else{
            return lyjRequirementMapper.getLyjRequirementsByTypeIdCount(searchText,typeId);
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

    /**
     * create by: yangchenxiao
     * create time: 2019/8/10 14:55
     * description: 根据需求ID查询到所有的需求类型
     */
    @Override
    public List<LyjRequirementType> getTypesById(Integer requirementId) {
        return lyjRequirementMapper.getTypesById(requirementId);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/8/18 11:21
     * description: 我创建的需求
     */
    @Override
    public List<LyjRequirement> getMyRequirement(String uuid) {
        return lyjRequirementMapper.getMyRequirement(uuid);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/8/18 11:21
     * description: 我申请中标了的请求
     */
    @Override
    public List<LyjRequirement> getMyApplyRequirement(String uuid) {
        return lyjRequirementMapper.getMyApplyRequirement(uuid);
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

    /**
     * create by: yangchenxiao
     * create time: 2019/8/23 22:02
     * description: 可以增加多个需求类型
     */
    @Override
    @Transactional
    public void saveRequirementAdvanced(LyjRequirementVO lyjRequirementVO) {
        //1、先增加需求
        lyjRequirementVO.setLyjRequirementCreatedatetime(new Date());
        lyjRequirementMapper.insertAdvanced(lyjRequirementVO);
        Integer requirementId=lyjRequirementVO.getLyjRequirementId();

        if(null!=lyjRequirementVO.getAllTypeIds()){
            for(Integer single:lyjRequirementVO.getAllTypeIds()){
                //2、再增加需求和类型关系表的数据
                lyjRequirementtypeRelationMapper.insert(new LyjRequirementtypeRelation(requirementId,single));
            }
        }
    }

    @Override
    @Transactional
    public void updateRequirement(LyjRequirementVO lyjRequirement) {
        //1、删除所有的类型关系表中的数据
        lyjRequirementtypeRelationMapper.deleteByRequirementId(lyjRequirement.getLyjRequirementId());

        //2、再更新
        lyjRequirementMapper.updateByPrimaryKey(lyjRequirement);

        //3、再增加关系数据
        if(null!=lyjRequirement.getAllTypeIds()){
            for(Integer single:lyjRequirement.getAllTypeIds()){
                //2、再增加需求和类型关系表的数据
                lyjRequirementtypeRelationMapper.insert(new LyjRequirementtypeRelation(lyjRequirement.getLyjRequirementId(),single));
            }
        }
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
