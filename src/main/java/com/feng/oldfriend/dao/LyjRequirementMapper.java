package com.feng.oldfriend.dao;

import com.feng.oldfriend.VO.BatchUserState;
import com.feng.oldfriend.entity.LyjRequirement;
import com.feng.oldfriend.entity.LyjRequirementType;
import com.feng.oldfriend.entity.LyjRequirementVO;
import com.feng.oldfriend.entity.LyjRequirementtypeRelation;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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
    List<LyjRequirement> getLyjRequirements(@Param("searchText") String searchText,@Param("state")Integer state);

    Integer getLyjRequirementsCount(@Param("searchText") String searchText,@Param("state")Integer state);

    /**
     * create by: yangchenxiao
     * create time: 2019/7/21 11:19
     * description: 根据搜索内容或者需求类型ID进行查询
     */
    List<LyjRequirement> getLyjRequirementsByTypeId(@Param("searchText") String searchText, @Param("typeId") Integer typeId,@Param("state")Integer state);

    Integer getLyjRequirementsByTypeIdCount(@Param("searchText") String searchText, @Param("typeId") Integer typeId,@Param("state")Integer state);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/22 15:48
     * description: 根据 城市 街道 开始时间 时间排序类型查询需求
     */
    List<LyjRequirement> getLyjRequirementsNoType(@Param("searchText") String searchText,
                                                  @Param("city") String city,
                                                  @Param("street") String street,
                                                  @Param("firstDate") String firstDate,
                                                  @Param("secondDate") String secondDate,
                                                  @Param("dateType") Integer dateType);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/22 15:48
     * description: 根据类别 城市 街道 开始时间 时间排序类型查询需求
     */
    List<LyjRequirement> getRequirementByManyParameters(@Param("searchText") String searchText,
                                                        @Param("typeId") Integer typeId,
                                                        @Param("city") String city,
                                                        @Param("street") String street,
                                                        @Param("firstDate") String firstDate,
                                                        @Param("secondDate") String secondDate,
                                                        @Param("dateType") Integer dateType);



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

    int insertAdvanced(LyjRequirementVO lyjRequirementVO);

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
    int updateByPrimaryKey(LyjRequirementVO record);

    int updateByPrimaryKeyNormal(LyjRequirement record);


    List<LyjRequirement> getMyRequirement(@Param("uuid") String uuid);

    List<LyjRequirement> getMyApplyRequirement(@Param("uuid") String uuid);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/11 22:07
     * description: 批量更新需求的状态
     */
    void batchUpdateRequirementState(BatchUserState datas);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/11 22:07
     * description: 批量更新需求流程的状态
     */
    void batchUpdateRequirementProcess(BatchUserState datas);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/9 21:34
     * description: 根据机构查询需求
     */
    List<LyjRequirement> getRequirementsByCompany(@Param(value = "state") Integer state, @Param(value = "companyId") Integer companyId, @Param(value = "searchText") String searchText);

    Integer getRequirementsByCompanyCount(@Param(value = "state") Integer state, @Param(value = "companyId") Integer companyId, @Param(value = "searchText") String searchText);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/22 15:16
     * description: 根据需求状态查询城市
     */
    List<String> getRequirementCityByStatus(@Param(value = "state") Integer state);

    /**
     * create by: yangchenxiao
     * create time: 2019/9/22 15:16
     * description: 根据需求状态查询城市
     */
    List<String> getRequirementStreetByStatus(@Param(value = "state") Integer state);

    /**
     * create by: yangchenxiao
     * create time: 2019/10/9 22:42
     * description: 根据需求的开始时间和结束时间进行筛选  查看是否有数据
     */
    Integer selectByDate(@Param("beginDate") Date beginDate,@Param("endDate") Date endDate,@Param("uuid")String uuid);
}
