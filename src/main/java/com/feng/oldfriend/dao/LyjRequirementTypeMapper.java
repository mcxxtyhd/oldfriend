package com.feng.oldfriend.dao;

import com.feng.oldfriend.entity.LyjRequirementType;
import java.util.List;

public interface LyjRequirementTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_requirement_type
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer lyjRequirementTypeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_requirement_type
     *
     * @mbggenerated
     */
    int insert(LyjRequirementType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_requirement_type
     *
     * @mbggenerated
     */
    LyjRequirementType selectByPrimaryKey(Integer lyjRequirementTypeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_requirement_type
     *
     * @mbggenerated
     */
    List<LyjRequirementType> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_requirement_type
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LyjRequirementType record);
}