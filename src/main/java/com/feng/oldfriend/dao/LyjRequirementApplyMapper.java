package com.feng.oldfriend.dao;

import com.feng.oldfriend.entity.LyjRequirementApply;
import java.util.List;

public interface LyjRequirementApplyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_requirement_apply
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer lyjRequirementApplyid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_requirement_apply
     *
     * @mbggenerated
     */
    int insert(LyjRequirementApply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_requirement_apply
     *
     * @mbggenerated
     */
    LyjRequirementApply selectByPrimaryKey(Integer lyjRequirementApplyid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_requirement_apply
     *
     * @mbggenerated
     */
    List<LyjRequirementApply> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_requirement_apply
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LyjRequirementApply record);
}