package com.feng.oldfriend.service;


import com.feng.oldfriend.entity.LyjRequirement;
import com.feng.oldfriend.entity.LyjRequirementType;

import java.util.List;

public interface LyjRquirementTypeService {

    /**
     * create by: yangchenxiao
     * create time: 2019/7/24 21:05
     * description: 根据搜索条件进行查找
     */
    List<LyjRequirementType> getLyjRequirementTypes(String searchText);

    Integer getLyjRequirementTypesCount(String searchText);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/24 20:48
     * description: 新增需求类型
     */
    void saveRquirementType(LyjRequirementType lyjRequirementType);

    void updateRquirementType(LyjRequirementType lyjRequirementType);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/24 20:48
     * description: 删除需求类型
     */
    void removeRquirementType(Integer id);

    /**
     * create by: yangchenxiao
     * create time: 2019/8/9 21:11
     * description: 根据父ID查询所有的子需求类型
     */
    List<LyjRequirementType> getSonRequirementTypes(Integer parentID);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/22 14:35
     * description: 根据需求状态查询所有的需求类型
     */
    List<LyjRequirementType> getRequirementTypeByStatus(Integer state);
}
