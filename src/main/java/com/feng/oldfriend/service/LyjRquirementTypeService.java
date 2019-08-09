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
    List<LyjRequirementType> getLyjRequirementTypes();

    /**
     * create by: yangchenxiao
     * create time: 2019/7/24 20:48
     * description: 新增需求类型
     */
    void saveRquirementType(LyjRequirementType lyjRequirementType);

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
}
