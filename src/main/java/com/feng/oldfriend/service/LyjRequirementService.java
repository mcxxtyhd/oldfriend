package com.feng.oldfriend.service;

import com.feng.oldfriend.VO.BatchUserState;
import com.feng.oldfriend.entity.*;
import org.springframework.web.bind.annotation.RequestBody;

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

    /**
     * create by: yangchenxiao
     * create time: 2019/8/23 22:01
     * description: 只能增加一个需求类型
     */
    void saveRequirement(Integer typeId,LyjRequirement lyjRequirement);

    /**
     * create by: yangchenxiao
     * create time: 2019/8/23 22:02
     * description: 可以增加多个需求类型
     */
    void saveRequirementAdvanced(LyjRequirementVO lyjRequirementVO);

    void updateRequirement(LyjRequirementVO lyjRequirement);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/11 22:07
     * description: 批量更新需求的状态
     */
    void batchUpdateRequirementState(@RequestBody BatchUserState datas);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/11 22:07
     * description: 批量更新需求流程的状态
     */
    void batchUpdateRequirementProcess(@RequestBody BatchUserState datas);

    void removeRequirement(Integer id);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/9 21:34
     * description: 根据机构查询需求
     */
    List<LyjRequirement> getRequirementsByCompany(Integer state,Integer companyId,String searchText);

    Integer getRequirementsCount(Integer state,Integer companyId,String searchText);
}
