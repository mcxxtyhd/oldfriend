package com.feng.oldfriend.service.impl;

import com.feng.oldfriend.VO.BatchUserState;
import com.feng.oldfriend.dao.*;
import com.feng.oldfriend.entity.*;
import com.feng.oldfriend.service.LyjRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("LyjRequirementService")
public class LyjRequirementServiceImpl implements LyjRequirementService {

    @Autowired
    private LyjRequirementMapper lyjRequirementMapper;
    @Autowired
    private LyjRequirementtypeRelationMapper lyjRequirementtypeRelationMapper;
    @Autowired
    private LyjCompanyrequirementRelationMapper lyjCompanyrequirementRelationMapper;
    @Autowired
    private LyjRequirementApplyMapper lyjRequirementApplyMapper;
    @Autowired
    private LyjVolunteerMapper lyjVolunteerMapper;

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 11:25
     * description: 根据搜索条件获取需求数据
     */
    @Override
    public List<LyjRequirement> getRequirements(String searchText, Integer typeId, Integer state) {

        //判断需求类型ID是否为空，根据是否为空来提出两个不同的解决方案
        if (null == typeId) {
            return lyjRequirementMapper.getLyjRequirements(searchText, state);
        } else {
            return lyjRequirementMapper.getLyjRequirementsByTypeId(searchText, typeId, state);
        }
    }

    @Override
    public Integer getRequirementCount(String searchText, Integer typeId, Integer state) {
        //判断需求类型ID是否为空，根据是否为空来提出两个不同的解决方案
        if (null == typeId) {
            return lyjRequirementMapper.getLyjRequirementsCount(searchText, state);
        } else {
            return lyjRequirementMapper.getLyjRequirementsByTypeIdCount(searchText, typeId, state);
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/22 15:48
     * description: 根据类别 城市 街道 开始时间 时间排序类型查询需求
     */
    @Override
    public List<LyjRequirement> getRequirementByManyParameters(String searchText, Integer typeId, String city, String street, String firstDate, String secondDate, Integer dateType) {
        if (null == typeId) {
            return lyjRequirementMapper.getLyjRequirementsNoType(searchText, city, street, firstDate, secondDate, dateType);
        } else {
            return lyjRequirementMapper.getRequirementByManyParameters(searchText, typeId, city, street, firstDate, secondDate, dateType);
        }
    }


    /**
     * create by: yangchenxiao
     * create time: 2019/7/28 14:46
     * description: 根据需求ID查找到详情
     */
    @Override
    public LyjRequirement getRequirementById(Integer requirementId) {
        LyjRequirement data = lyjRequirementMapper.selectByPrimaryKey(requirementId);
        List<LyjRequirementType> currentdata = lyjRequirementMapper.getTypesById(data.getLyjRequirementId());
        data.setAllTypes(currentdata);
        return data;
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
    public void saveRequirement(Integer typeId, LyjRequirement lyjRequirement) {
        //1、先增加需求
        lyjRequirement.setLyjRequirementCreatedatetime(new Date());
        lyjRequirementMapper.insert(lyjRequirement);
        Integer requirementId = lyjRequirement.getLyjRequirementId();
        //2、再增加需求和类型关系表的数据
        lyjRequirementtypeRelationMapper.insert(new LyjRequirementtypeRelation(requirementId, typeId));
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
        Integer requirementId = lyjRequirementVO.getLyjRequirementId();

        if (null != lyjRequirementVO.getAllTypeIds()) {
            for (Integer single : lyjRequirementVO.getAllTypeIds()) {
                //2、再增加需求和类型关系表的数据
                lyjRequirementtypeRelationMapper.insert(new LyjRequirementtypeRelation(requirementId, single));
            }
        }

        //3、最后再增加机构关系表
        if(lyjRequirementVO.getLyjCompanyId()!=null){
            lyjCompanyrequirementRelationMapper.insert(new LyjCompanyrequirementRelation(lyjRequirementVO.getLyjCompanyId(), requirementId));
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
        if (null != lyjRequirement.getAllTypeIds()) {
            for (Integer single : lyjRequirement.getAllTypeIds()) {
                //2、再增加需求和类型关系表的数据
                lyjRequirementtypeRelationMapper.insert(new LyjRequirementtypeRelation(lyjRequirement.getLyjRequirementId(), single));
            }
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/11 22:07
     * description: 批量更新需求的状态
     */
    @Override
    public void batchUpdateRequirementState(BatchUserState datas) {
        lyjRequirementMapper.batchUpdateRequirementState(datas);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/11 22:07
     * description: 批量更新需求流程的状态
     */
    @Override
    public void batchUpdateRequirementProcess(BatchUserState datas) {
        lyjRequirementMapper.batchUpdateRequirementProcess(datas);
    }

    @Override
    @Transactional
    public void removeRequirement(Integer id) {
        //1、删除所有的类型关系表中的数据
        lyjRequirementtypeRelationMapper.deleteByRequirementId(id);

        //2、删除该需求数据
        lyjRequirementMapper.deleteByPrimaryKey(id);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/9 21:34
     * description: 根据机构查询需求
     */
    @Override
    public List<LyjRequirement> getRequirementsByCompany(Integer state, Integer companyId, String searchText) {
        List<LyjRequirement> datas = lyjRequirementMapper.getRequirementsByCompany(state, companyId, searchText);

        //将需求类型的id加入
        for (LyjRequirement single : datas) {
            List<Integer> typeids = new ArrayList<>();

            List<LyjRequirementType> currentdata = lyjRequirementMapper.getTypesById(single.getLyjRequirementId());
            for (LyjRequirementType onedata : currentdata) {
                typeids.add(onedata.getLyjRequirementTypeid());
            }
            single.setAllTypeIds(typeids);
            single.setAllTypes(currentdata);
        }
        return datas;
    }

    @Override
    public Integer getRequirementsCount(Integer state, Integer companyId, String searchText) {
        return lyjRequirementMapper.getRequirementsByCompanyCount(state, companyId, searchText);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/22 15:14
     * description: 根据需求状态查询城市
     */
    @Override
    public List<String> getRequirementCityByStatus(Integer state) {
        return lyjRequirementMapper.getRequirementCityByStatus(state);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/22 15:14
     * description: 根据状态查询街道
     */
    @Override
    public List<String> getRequirementStreetByStatus(Integer state) {
        return lyjRequirementMapper.getRequirementStreetByStatus(state);
    }


}
