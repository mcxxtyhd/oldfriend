package com.feng.oldfriend.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class LyjRequirement implements Serializable {

    private String lyjCompanyName;

    public String getLyjCompanyName() {
        return lyjCompanyName;
    }

    public void setLyjCompanyName(String lyjCompanyName) {
        this.lyjCompanyName = lyjCompanyName;
    }

    private Integer lyjRequirementApplyednum;

    public Integer getLyjRequirementApplyednum() {
        return lyjRequirementApplyednum;
    }

    public void setLyjRequirementApplyednum(Integer lyjRequirementApplyednum) {
        this.lyjRequirementApplyednum = lyjRequirementApplyednum;
    }

    private Integer lyjRequirementProcess;

    public Integer getLyjRequirementProcess() {
        return lyjRequirementProcess;
    }

    public void setLyjRequirementProcess(Integer lyjRequirementProcess) {
        this.lyjRequirementProcess = lyjRequirementProcess;
    }

    private Integer lyjRequirementNum;

    public Integer getLyjRequirementNum() {
        return lyjRequirementNum;
    }

    public void setLyjRequirementNum(Integer lyjRequirementNum) {
        this.lyjRequirementNum = lyjRequirementNum;
    }

    private Integer lyjRequirementState;

    public Integer getLyjRequirementState() {
        return lyjRequirementState;
    }

    public void setLyjRequirementState(Integer lyjRequirementState) {
        this.lyjRequirementState = lyjRequirementState;
    }

    private String lyjRequirementDetailadd;

    public String getLyjRequirementDetailadd() {
        return lyjRequirementDetailadd;
    }

    public void setLyjRequirementDetailadd(String lyjRequirementDetailadd) {
        this.lyjRequirementDetailadd = lyjRequirementDetailadd;
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/8/10 18:46
     * description: 所有的类型
     */
    private List<LyjRequirementType> allTypes;

    public List<LyjRequirementType> getAllTypes() {
        return allTypes;
    }

    public void setAllTypes(List<LyjRequirementType> allTypes) {
        this.allTypes = allTypes;
    }

    private List<Integer> allTypeIds;

    public List<Integer> getAllTypeIds() {
        return allTypeIds;
    }

    public void setAllTypeIds(List<Integer> allTypeIds) {
        this.allTypeIds = allTypeIds;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_requirement.lyj_requirement_id
     *
     * @mbggenerated
     */
    private Integer lyjRequirementId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_requirement.lyj_requirement_name
     *
     * @mbggenerated
     */
    private String lyjRequirementName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_requirement.lyj_requirement_description
     *
     * @mbggenerated
     */
    private String lyjRequirementDescription;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_requirement.lyj_requirement_createuser
     *
     * @mbggenerated
     */
    private String lyjRequirementCreateuser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_requirement.lyj_requirement_applyuser
     *
     * @mbggenerated
     */
    private String lyjRequirementApplyuser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_requirement.lyj_requirement_isvolunteer
     *
     * @mbggenerated
     */
    private Integer lyjRequirementIsvolunteer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_requirement.lyj_requirement_city
     *
     * @mbggenerated
     */
    private String lyjRequirementCity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_requirement.lyj_requirement_area
     *
     * @mbggenerated
     */
    private String lyjRequirementArea;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_requirement.lyj_requirement_street
     *
     * @mbggenerated
     */
    private String lyjRequirementStreet;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_requirement.lyj_requirement_createdatetime
     *
     * @mbggenerated
     */
    private Date lyjRequirementCreatedatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_requirement.lyj_requirement_begindatetime
     *
     * @mbggenerated
     */
    private Date lyjRequirementBegindatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_requirement.lyj_requirement_enddatetime
     *
     * @mbggenerated
     */
    private Date lyjRequirementEnddatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_requirement.lyj_requirement_rawaddress
     *
     * @mbggenerated
     */
    private String lyjRequirementRawaddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_requirement.lyj_requirement_maplocation
     *
     * @mbggenerated
     */
    private String lyjRequirementMaplocation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_requirement.lyj_requirement_reward
     *
     * @mbggenerated
     */
    private Integer lyjRequirementReward;

    private Integer lyjRequirementVolunteerperfer;

    public Integer getLyjRequirementVolunteerperfer() {
        return lyjRequirementVolunteerperfer;
    }

    public void setLyjRequirementVolunteerperfer(Integer lyjRequirementVolunteerperfer) {
        this.lyjRequirementVolunteerperfer = lyjRequirementVolunteerperfer;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table lyj_requirement
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_requirement.lyj_requirement_id
     *
     * @return the value of lyj_requirement.lyj_requirement_id
     *
     * @mbggenerated
     */
    public Integer getLyjRequirementId() {
        return lyjRequirementId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_requirement.lyj_requirement_id
     *
     * @param lyjRequirementId the value for lyj_requirement.lyj_requirement_id
     *
     * @mbggenerated
     */
    public void setLyjRequirementId(Integer lyjRequirementId) {
        this.lyjRequirementId = lyjRequirementId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_requirement.lyj_requirement_name
     *
     * @return the value of lyj_requirement.lyj_requirement_name
     *
     * @mbggenerated
     */
    public String getLyjRequirementName() {
        return lyjRequirementName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_requirement.lyj_requirement_name
     *
     * @param lyjRequirementName the value for lyj_requirement.lyj_requirement_name
     *
     * @mbggenerated
     */
    public void setLyjRequirementName(String lyjRequirementName) {
        this.lyjRequirementName = lyjRequirementName == null ? null : lyjRequirementName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_requirement.lyj_requirement_description
     *
     * @return the value of lyj_requirement.lyj_requirement_description
     *
     * @mbggenerated
     */
    public String getLyjRequirementDescription() {
        return lyjRequirementDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_requirement.lyj_requirement_description
     *
     * @param lyjRequirementDescription the value for lyj_requirement.lyj_requirement_description
     *
     * @mbggenerated
     */
    public void setLyjRequirementDescription(String lyjRequirementDescription) {
        this.lyjRequirementDescription = lyjRequirementDescription == null ? null : lyjRequirementDescription.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_requirement.lyj_requirement_createuser
     *
     * @return the value of lyj_requirement.lyj_requirement_createuser
     *
     * @mbggenerated
     */
    public String getLyjRequirementCreateuser() {
        return lyjRequirementCreateuser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_requirement.lyj_requirement_createuser
     *
     * @param lyjRequirementCreateuser the value for lyj_requirement.lyj_requirement_createuser
     *
     * @mbggenerated
     */
    public void setLyjRequirementCreateuser(String lyjRequirementCreateuser) {
        this.lyjRequirementCreateuser = lyjRequirementCreateuser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_requirement.lyj_requirement_applyuser
     *
     * @return the value of lyj_requirement.lyj_requirement_applyuser
     *
     * @mbggenerated
     */
    public String getLyjRequirementApplyuser() {
        return lyjRequirementApplyuser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_requirement.lyj_requirement_applyuser
     *
     * @param lyjRequirementApplyuser the value for lyj_requirement.lyj_requirement_applyuser
     *
     * @mbggenerated
     */
    public void setLyjRequirementApplyuser(String lyjRequirementApplyuser) {
        this.lyjRequirementApplyuser = lyjRequirementApplyuser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_requirement.lyj_requirement_isvolunteer
     *
     * @return the value of lyj_requirement.lyj_requirement_isvolunteer
     *
     * @mbggenerated
     */
    public Integer getLyjRequirementIsvolunteer() {
        return lyjRequirementIsvolunteer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_requirement.lyj_requirement_isvolunteer
     *
     * @param lyjRequirementIsvolunteer the value for lyj_requirement.lyj_requirement_isvolunteer
     *
     * @mbggenerated
     */
    public void setLyjRequirementIsvolunteer(Integer lyjRequirementIsvolunteer) {
        this.lyjRequirementIsvolunteer = lyjRequirementIsvolunteer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_requirement.lyj_requirement_city
     *
     * @return the value of lyj_requirement.lyj_requirement_city
     *
     * @mbggenerated
     */
    public String getLyjRequirementCity() {
        return lyjRequirementCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_requirement.lyj_requirement_city
     *
     * @param lyjRequirementCity the value for lyj_requirement.lyj_requirement_city
     *
     * @mbggenerated
     */
    public void setLyjRequirementCity(String lyjRequirementCity) {
        this.lyjRequirementCity = lyjRequirementCity == null ? null : lyjRequirementCity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_requirement.lyj_requirement_area
     *
     * @return the value of lyj_requirement.lyj_requirement_area
     *
     * @mbggenerated
     */
    public String getLyjRequirementArea() {
        return lyjRequirementArea;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_requirement.lyj_requirement_area
     *
     * @param lyjRequirementArea the value for lyj_requirement.lyj_requirement_area
     *
     * @mbggenerated
     */
    public void setLyjRequirementArea(String lyjRequirementArea) {
        this.lyjRequirementArea = lyjRequirementArea == null ? null : lyjRequirementArea.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_requirement.lyj_requirement_street
     *
     * @return the value of lyj_requirement.lyj_requirement_street
     *
     * @mbggenerated
     */
    public String getLyjRequirementStreet() {
        return lyjRequirementStreet;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_requirement.lyj_requirement_street
     *
     * @param lyjRequirementStreet the value for lyj_requirement.lyj_requirement_street
     *
     * @mbggenerated
     */
    public void setLyjRequirementStreet(String lyjRequirementStreet) {
        this.lyjRequirementStreet = lyjRequirementStreet == null ? null : lyjRequirementStreet.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_requirement.lyj_requirement_createdatetime
     *
     * @return the value of lyj_requirement.lyj_requirement_createdatetime
     *
     * @mbggenerated
     */
    public Date getLyjRequirementCreatedatetime() {
        return lyjRequirementCreatedatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_requirement.lyj_requirement_createdatetime
     *
     * @param lyjRequirementCreatedatetime the value for lyj_requirement.lyj_requirement_createdatetime
     *
     * @mbggenerated
     */
    public void setLyjRequirementCreatedatetime(Date lyjRequirementCreatedatetime) {
        this.lyjRequirementCreatedatetime = lyjRequirementCreatedatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_requirement.lyj_requirement_begindatetime
     *
     * @return the value of lyj_requirement.lyj_requirement_begindatetime
     *
     * @mbggenerated
     */
    public Date getLyjRequirementBegindatetime() {
        return lyjRequirementBegindatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_requirement.lyj_requirement_begindatetime
     *
     * @param lyjRequirementBegindatetime the value for lyj_requirement.lyj_requirement_begindatetime
     *
     * @mbggenerated
     */
    public void setLyjRequirementBegindatetime(Date lyjRequirementBegindatetime) {
        this.lyjRequirementBegindatetime = lyjRequirementBegindatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_requirement.lyj_requirement_enddatetime
     *
     * @return the value of lyj_requirement.lyj_requirement_enddatetime
     *
     * @mbggenerated
     */
    public Date getLyjRequirementEnddatetime() {
        return lyjRequirementEnddatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_requirement.lyj_requirement_enddatetime
     *
     * @param lyjRequirementEnddatetime the value for lyj_requirement.lyj_requirement_enddatetime
     *
     * @mbggenerated
     */
    public void setLyjRequirementEnddatetime(Date lyjRequirementEnddatetime) {
        this.lyjRequirementEnddatetime = lyjRequirementEnddatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_requirement.lyj_requirement_rawaddress
     *
     * @return the value of lyj_requirement.lyj_requirement_rawaddress
     *
     * @mbggenerated
     */
    public String getLyjRequirementRawaddress() {
        return lyjRequirementRawaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_requirement.lyj_requirement_rawaddress
     *
     * @param lyjRequirementRawaddress the value for lyj_requirement.lyj_requirement_rawaddress
     *
     * @mbggenerated
     */
    public void setLyjRequirementRawaddress(String lyjRequirementRawaddress) {
        this.lyjRequirementRawaddress = lyjRequirementRawaddress == null ? null : lyjRequirementRawaddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_requirement.lyj_requirement_maplocation
     *
     * @return the value of lyj_requirement.lyj_requirement_maplocation
     *
     * @mbggenerated
     */
    public String getLyjRequirementMaplocation() {
        return lyjRequirementMaplocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_requirement.lyj_requirement_maplocation
     *
     * @param lyjRequirementMaplocation the value for lyj_requirement.lyj_requirement_maplocation
     *
     * @mbggenerated
     */
    public void setLyjRequirementMaplocation(String lyjRequirementMaplocation) {
        this.lyjRequirementMaplocation = lyjRequirementMaplocation == null ? null : lyjRequirementMaplocation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_requirement.lyj_requirement_reward
     *
     * @return the value of lyj_requirement.lyj_requirement_reward
     *
     * @mbggenerated
     */
    public Integer getLyjRequirementReward() {
        return lyjRequirementReward;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_requirement.lyj_requirement_reward
     *
     * @param lyjRequirementReward the value for lyj_requirement.lyj_requirement_reward
     *
     * @mbggenerated
     */
    public void setLyjRequirementReward(Integer lyjRequirementReward) {
        this.lyjRequirementReward = lyjRequirementReward;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_requirement
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lyjRequirementId=").append(lyjRequirementId);
        sb.append(", lyjRequirementName=").append(lyjRequirementName);
        sb.append(", lyjRequirementDescription=").append(lyjRequirementDescription);
        sb.append(", lyjRequirementCreateuser=").append(lyjRequirementCreateuser);
        sb.append(", lyjRequirementApplyuser=").append(lyjRequirementApplyuser);
        sb.append(", lyjRequirementIsvolunteer=").append(lyjRequirementIsvolunteer);
        sb.append(", lyjRequirementCity=").append(lyjRequirementCity);
        sb.append(", lyjRequirementArea=").append(lyjRequirementArea);
        sb.append(", lyjRequirementStreet=").append(lyjRequirementStreet);
        sb.append(", lyjRequirementCreatedatetime=").append(lyjRequirementCreatedatetime);
        sb.append(", lyjRequirementBegindatetime=").append(lyjRequirementBegindatetime);
        sb.append(", lyjRequirementEnddatetime=").append(lyjRequirementEnddatetime);
        sb.append(", lyjRequirementRawaddress=").append(lyjRequirementRawaddress);
        sb.append(", lyjRequirementMaplocation=").append(lyjRequirementMaplocation);
        sb.append(", lyjRequirementReward=").append(lyjRequirementReward);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
