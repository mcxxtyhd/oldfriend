package com.feng.oldfriend.dao;

import com.feng.oldfriend.entity.LyjRequirementType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
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
    List<LyjRequirementType> selectAll(@Param("searchText") String searchText);

    /**
     * create by: yangchenxiao
     * create time: 2019/8/17 16:41
     * description: 查找总条数
     */
    Integer selectAllCount(@Param("searchText")String searchText);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_requirement_type
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LyjRequirementType record);

    /**
     * create by: yangchenxiao
     * create time: 2019/8/9 21:36
     * description: 根据父ID找到所有的子需求类型
     */
    List<LyjRequirementType> getSonRequirementTypes(@Param("parentID") Integer parentID);
}