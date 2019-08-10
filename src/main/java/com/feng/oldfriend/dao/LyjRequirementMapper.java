package com.feng.oldfriend.dao;

import com.feng.oldfriend.entity.LyjRequirement;
import com.feng.oldfriend.entity.LyjRequirementType;
import com.feng.oldfriend.entity.LyjRequirementtypeRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LyjRequirementMapper {

    /**
     * create by: yangchenxiao
     * create time: 2019/8/10 14:55
     * description: 根据需求ID查询到所有的需求类型
     */
    List<LyjRequirementType> getTypesById(@Param("requirenmentId") Integer requirenmentId);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 11:19
     * description: 根据搜索内容进行查询
     */
    List<LyjRequirement> getLyjRequirements(@Param("searchText") String searchText);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 11:19
     * description: 根据搜索内容或者需求类型ID进行查询
     */
    List<LyjRequirement> getLyjRequirementsByTypeId(@Param("searchText") String searchText,@Param("typeId") Integer typeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_requirement
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer lyjRequirementId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_requirement
     *
     * @mbggenerated
     */
    int insert(LyjRequirement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_requirement
     *
     * @mbggenerated
     */
    LyjRequirement selectByPrimaryKey(Integer lyjRequirementId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_requirement
     *
     * @mbggenerated
     */
    List<LyjRequirement> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_requirement
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LyjRequirement record);
}