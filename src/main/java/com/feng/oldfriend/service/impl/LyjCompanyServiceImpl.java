package com.feng.oldfriend.service.impl;

import com.feng.oldfriend.dao.*;
import com.feng.oldfriend.entity.LyjCompany;
import com.feng.oldfriend.entity.LyjCompanyrequirementRelation;
import com.feng.oldfriend.entity.LyjCompanyuserRelation;
import com.feng.oldfriend.service.LyjCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/9/8 17:12
 * @description：
 */
@Service("LyjCompanyService")
public class LyjCompanyServiceImpl implements LyjCompanyService {

    @Autowired
    private LyjCompanyMapper lyjCompanyMapper;

    @Autowired
    private LyjCompanyrequirementRelationMapper lyjCompanyrequirementRelationMapper;

    @Autowired
    private LyjCompanyuserRelationMapper lyjCompanyuserRelationMapper;

    @Autowired
    private LyjUserMapper lyjUserMapper;

    @Autowired
    private LyjRequirementMapper lyjRequirementMapper;

    @Override
    public List<LyjCompany> getCompanies(String searchText) {
        return lyjCompanyMapper.selectCompany(searchText);
    }

    @Override
    public Integer getCompaniesCount(String searchText) {
        return null;
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/10 21:53
     * description: 根据UUID找到机构IDs
     */
    @Override
    public List<Integer> getCompanyIdsByUUID(String uuid) {
        return lyjCompanyuserRelationMapper.selectAllByUUID(uuid);
    }

    @Override
    public void saveCompany(LyjCompany lyjCompany) {
        lyjCompanyMapper.insert(lyjCompany);
    }

    @Override
    public void updateCompany(LyjCompany lyjCompany) {
        lyjCompanyMapper.updateByPrimaryKey(lyjCompany);
    }

    @Override
    public void removeCompany(Integer id) {
        lyjCompanyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveRelationCR(LyjCompanyrequirementRelation lyjCompanyrequirementRelation) {
        lyjCompanyrequirementRelationMapper.insert(lyjCompanyrequirementRelation);
    }

    @Override
    public void removeRelationCR(LyjCompanyrequirementRelation lyjCompanyrequirementRelation) {
        //1、先删除关系数据
        LyjCompanyrequirementRelation data=new LyjCompanyrequirementRelation();
        lyjCompanyrequirementRelationMapper.deleteByPrimaryKey(lyjCompanyrequirementRelation.getLyjCrRelationCompanyid(),lyjCompanyrequirementRelation.getLyjCrRelationRequirementid());

        //2、再删除需求
        lyjRequirementMapper.deleteByPrimaryKey(lyjCompanyrequirementRelation.getLyjCrRelationRequirementid());
    }

    @Override
    public void saveRelationCU(LyjCompanyuserRelation lyjCompanyuserRelation) {
        lyjCompanyuserRelationMapper.insert(lyjCompanyuserRelation);
    }

    @Override
    public void removeRelationCU(LyjCompanyuserRelation lyjCompanyuserRelation) {
        //1、先删除关系数据
        lyjCompanyuserRelationMapper.deleteByPrimaryKey(lyjCompanyuserRelation.getLyjCuRelationCompanyid(),lyjCompanyuserRelation.getLyjCuRelationUuid());

        //2、再删除用户数据
        lyjUserMapper.deleteByUUID(lyjCompanyuserRelation.getLyjCuRelationUuid());
    }
}
