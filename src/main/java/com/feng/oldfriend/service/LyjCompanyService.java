package com.feng.oldfriend.service;

import com.feng.oldfriend.entity.LyjCompany;
import com.feng.oldfriend.entity.LyjCompanyrequirementRelation;
import com.feng.oldfriend.entity.LyjCompanyuserRelation;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/9/8 17:11
 * @description：
 */
public interface LyjCompanyService {

    /**
     * create by: yangchenxiao
     * create time: 2019/9/8 17:17
     * description: 根据搜索内容找到对应的机构
     */
    List<LyjCompany> getCompanies(String searchText);

    Integer getCompaniesCount(String searchText);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/10 21:53
     * description: 根据UUID找到机构IDs
     */
    List<Integer> getCompanyIdsByUUID(String uuid);

    void saveCompany(LyjCompany lyjCompany);

    void updateCompany(LyjCompany lyjCompany);

    void removeCompany(Integer id);

    void saveRelationCR(LyjCompanyrequirementRelation lyjCompanyrequirementRelation);

    void removeRelationCR(LyjCompanyrequirementRelation lyjCompanyrequirementRelation);

    void saveRelationCU(LyjCompanyuserRelation lyjCompanyuserRelation);

    void removeRelationCU(LyjCompanyuserRelation lyjCompanyuserRelation);


}
