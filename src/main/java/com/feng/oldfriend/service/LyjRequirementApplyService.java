package com.feng.oldfriend.service;

import com.feng.oldfriend.VO.BatchUserState;
import com.feng.oldfriend.entity.LyjRequirement;
import com.feng.oldfriend.entity.LyjRequirementApply;
import com.feng.oldfriend.entity.LyjRequirementApplyField;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface LyjRequirementApplyService {

    /**
     * create by: yangchenxiao
     * create time: 2019/7/24 21:53
     * description: 根据需求ID查询所有的申请
     */
    List<LyjRequirementApply> getRequirementApplys(Integer requirementId);

    Integer getRequirementApplysCount(Integer requirementId);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 11:05
     * description: 根据参数(搜索内容,唯一标识ID)进行查找
     */
    List<LyjRequirementApplyField> getRequirementByParams(String searchText, String uuid, Integer[] status);

    Integer getRequirementByParamsCount(String searchText, String uuid, Integer[] status);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 11:05
     * description: 根据参数(搜索内容,唯一标识ID，需求的状态)进行查找
     */
    List<LyjRequirementApplyField> getRequirementByParamsType(String searchText, String uuid, Integer[] status,Integer typeid);

    /**
     * create by: yangchenxiao
     * create time: 2019/8/18 11:29
     * description: 根据需求ID或状态查询需求申请的数据
     */
    List<LyjRequirementApplyField> getRequirementByIdStatus(Integer applyid, Integer status) throws Exception;


    void saveRequirementApply(LyjRequirementApply lyjRequirementApply);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/24 21:57
     * description: 更新某个需求的内容
     */
    void updateRequirementApply(LyjRequirementApply LyjRequirementApply);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/11 22:07
     * description: 批量更新需求申请的状态
     */
    Boolean batchUpdateApplyState(BatchUserState datas) throws Exception;

    void delRequirementApply(Integer id);

    /**
     * create by: yangchenxiao
     * create time: 2019/8/19 19:53
     * description: 根据需求ID和状态码更改
     */
    Integer updateRequirementApplyStatus(Integer applyId,Integer status)  throws Exception;

    /**
     * create by: yangchenxiao
     * create time: 2019/8/20 21:55
     * description: 评价 打分 输入持续时间 输入评价
     */
    void JudgeRequirementApply(Integer applyId,Integer star,String comment,Integer duration);


    /**
     * create by: yangchenxiao
     * create time: 2019/7/24 21:57
     * description: 将除了某个申请ID外的其他同一申请需求的申请置为申请失败
     */
    void updateApplyFailed(Integer requirementId,Integer requirementApplyId);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/28 16:37
     * description: 定时任务
     */
    void updateApplyFinish();

    /**
     * create by: yangchenxiao
     * create time: 2019/10/8 21:52
     * description: 检查当前用户是否能够申请该需求
     */
    Boolean checkIfBeApplied(Integer requirementId,String uuid);
}
