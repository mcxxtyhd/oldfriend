package com.feng.oldfriend.dao;

import com.feng.oldfriend.entity.LyjAdvertisement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LyjAdvertisementMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_advertisement
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer lyjAdvertisementId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_advertisement
     *
     * @mbggenerated
     */
    int insert(LyjAdvertisement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_advertisement
     *
     * @mbggenerated
     */
    LyjAdvertisement selectByPrimaryKey(Integer lyjAdvertisementId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_advertisement
     *
     * @mbggenerated
     */
    List<LyjAdvertisement> selectAll();

    /**
     * create by: yangchenxiao
     * create time: 2019/7/23 22:23
     * description: 根据广告页返回指定的广告信息
     */
    List<LyjAdvertisement> selectAdvertisementsByPagename(@Param("pageName") String pageName);

    Integer getAdvertisementByPageNameCount(@Param("pageName") String pageName);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_advertisement
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LyjAdvertisement record);
}