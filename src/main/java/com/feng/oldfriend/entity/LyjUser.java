package com.feng.oldfriend.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class LyjUser implements Serializable {

    //所属机构
    private List<Integer> companyIds;

    public List<Integer> getCompanyIds() {
        return companyIds;
    }

    public void setCompanyIds(List<Integer> companyIds) {
        this.companyIds = companyIds;
    }

    private String lyjUserApplystate;

    private Integer lyjUserAllduration;

    public String getLyjUserApplystate() {
        return lyjUserApplystate;
    }

    public void setLyjUserApplystate(String lyjUserApplystate) {
        this.lyjUserApplystate = lyjUserApplystate;
    }

    public Integer getLyjUserAllduration() {
        return lyjUserAllduration;
    }

    public void setLyjUserAllduration(Integer lyjUserAllduration) {
        this.lyjUserAllduration = lyjUserAllduration;
    }

    private Set<String> permissions;

    private String personalStar;

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    private Integer allDuration;

    public String getPersonalStar() {
        return personalStar;
    }

    public void setPersonalStar(String personalStar) {
        this.personalStar = personalStar;
    }

    public Integer getAllDuration() {
        return allDuration;
    }

    public void setAllDuration(Integer allDuration) {
        this.allDuration = allDuration;
    }

    private Integer lyjVolunteerId;

    public Integer getLyjVolunteerId() {
        return lyjVolunteerId;
    }

    public void setLyjVolunteerId(Integer lyjVolunteerId) {
        this.lyjVolunteerId = lyjVolunteerId;
    }

    private String lyjUserPassword;

    private String lyjUserUuid;

    public String getLyjUserPassword() {
        return lyjUserPassword;
    }

    public void setLyjUserPassword(String lyjUserPassword) {
        this.lyjUserPassword = lyjUserPassword;
    }

    public String getLyjUserUuid() {
        return lyjUserUuid;
    }

    public void setLyjUserUuid(String lyjUserUuid) {
        this.lyjUserUuid = lyjUserUuid;
    }

    private Date lyjUserBirthday;

    public Date getLyjUserBirthday() {
        return lyjUserBirthday;
    }

    public void setLyjUserBirthday(Date lyjUserBirthday) {
        this.lyjUserBirthday = lyjUserBirthday;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_user.lyj_user_id
     *
     * @mbggenerated
     */
    private Integer lyjUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_user.lyj_user_openid
     *
     * @mbggenerated
     */
    private String lyjUserOpenid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_user.lyj_user_name
     *
     * @mbggenerated
     */
    private String lyjUserName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_user.lyj_user_gender
     *
     * @mbggenerated
     */
    private Integer lyjUserGender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_user.lyj_user_location
     *
     * @mbggenerated
     */
    private String lyjUserLocation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_user.lyj_user_age
     *
     * @mbggenerated
     */
    private Integer lyjUserAge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_user.lyj_user_country
     *
     * @mbggenerated
     */
    private String lyjUserCountry;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_user.lyj_user_creditid
     *
     * @mbggenerated
     */
    private String lyjUserCreditid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_user.lyj_user_phone
     *
     * @mbggenerated
     */
    private String lyjUserPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_user.lyj_user_livingplace
     *
     * @mbggenerated
     */
    private String lyjUserLivingplace;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_user.lyj_user_workplace
     *
     * @mbggenerated
     */
    private String lyjUserWorkplace;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_user.lyj_user_creditpositive
     *
     * @mbggenerated
     */
    private String lyjUserCreditpositive;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lyj_user.lyj_user_creditnegative
     *
     * @mbggenerated
     */
    private String lyjUserCreditnegative;

    private Integer lyjUserRewards;

    public Integer getLyjUserRewards() {
        return lyjUserRewards;
    }

    public void setLyjUserRewards(Integer lyjUserRewards) {
        this.lyjUserRewards = lyjUserRewards;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table lyj_user
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_user.lyj_user_id
     *
     * @return the value of lyj_user.lyj_user_id
     *
     * @mbggenerated
     */
    public Integer getLyjUserId() {
        return lyjUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_user.lyj_user_id
     *
     * @param lyjUserId the value for lyj_user.lyj_user_id
     *
     * @mbggenerated
     */
    public void setLyjUserId(Integer lyjUserId) {
        this.lyjUserId = lyjUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_user.lyj_user_openid
     *
     * @return the value of lyj_user.lyj_user_openid
     *
     * @mbggenerated
     */
    public String getLyjUserOpenid() {
        return lyjUserOpenid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_user.lyj_user_openid
     *
     * @param lyjUserOpenid the value for lyj_user.lyj_user_openid
     *
     * @mbggenerated
     */
    public void setLyjUserOpenid(String lyjUserOpenid) {
        this.lyjUserOpenid = lyjUserOpenid == null ? null : lyjUserOpenid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_user.lyj_user_name
     *
     * @return the value of lyj_user.lyj_user_name
     *
     * @mbggenerated
     */
    public String getLyjUserName() {
        return lyjUserName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_user.lyj_user_name
     *
     * @param lyjUserName the value for lyj_user.lyj_user_name
     *
     * @mbggenerated
     */
    public void setLyjUserName(String lyjUserName) {
        this.lyjUserName = lyjUserName == null ? null : lyjUserName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_user.lyj_user_gender
     *
     * @return the value of lyj_user.lyj_user_gender
     *
     * @mbggenerated
     */
    public Integer getLyjUserGender() {
        return lyjUserGender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_user.lyj_user_gender
     *
     * @param lyjUserGender the value for lyj_user.lyj_user_gender
     *
     * @mbggenerated
     */
    public void setLyjUserGender(Integer lyjUserGender) {
        this.lyjUserGender = lyjUserGender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_user.lyj_user_location
     *
     * @return the value of lyj_user.lyj_user_location
     *
     * @mbggenerated
     */
    public String getLyjUserLocation() {
        return lyjUserLocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_user.lyj_user_location
     *
     * @param lyjUserLocation the value for lyj_user.lyj_user_location
     *
     * @mbggenerated
     */
    public void setLyjUserLocation(String lyjUserLocation) {
        this.lyjUserLocation = lyjUserLocation == null ? null : lyjUserLocation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_user.lyj_user_age
     *
     * @return the value of lyj_user.lyj_user_age
     *
     * @mbggenerated
     */
    public Integer getLyjUserAge() {
        return lyjUserAge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_user.lyj_user_age
     *
     * @param lyjUserAge the value for lyj_user.lyj_user_age
     *
     * @mbggenerated
     */
    public void setLyjUserAge(Integer lyjUserAge) {
        this.lyjUserAge = lyjUserAge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_user.lyj_user_country
     *
     * @return the value of lyj_user.lyj_user_country
     *
     * @mbggenerated
     */
    public String getLyjUserCountry() {
        return lyjUserCountry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_user.lyj_user_country
     *
     * @param lyjUserCountry the value for lyj_user.lyj_user_country
     *
     * @mbggenerated
     */
    public void setLyjUserCountry(String lyjUserCountry) {
        this.lyjUserCountry = lyjUserCountry == null ? null : lyjUserCountry.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_user.lyj_user_creditid
     *
     * @return the value of lyj_user.lyj_user_creditid
     *
     * @mbggenerated
     */
    public String getLyjUserCreditid() {
        return lyjUserCreditid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_user.lyj_user_creditid
     *
     * @param lyjUserCreditid the value for lyj_user.lyj_user_creditid
     *
     * @mbggenerated
     */
    public void setLyjUserCreditid(String lyjUserCreditid) {
        this.lyjUserCreditid = lyjUserCreditid == null ? null : lyjUserCreditid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_user.lyj_user_phone
     *
     * @return the value of lyj_user.lyj_user_phone
     *
     * @mbggenerated
     */
    public String getLyjUserPhone() {
        return lyjUserPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_user.lyj_user_phone
     *
     * @param lyjUserPhone the value for lyj_user.lyj_user_phone
     *
     * @mbggenerated
     */
    public void setLyjUserPhone(String lyjUserPhone) {
        this.lyjUserPhone = lyjUserPhone == null ? null : lyjUserPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_user.lyj_user_livingplace
     *
     * @return the value of lyj_user.lyj_user_livingplace
     *
     * @mbggenerated
     */
    public String getLyjUserLivingplace() {
        return lyjUserLivingplace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_user.lyj_user_livingplace
     *
     * @param lyjUserLivingplace the value for lyj_user.lyj_user_livingplace
     *
     * @mbggenerated
     */
    public void setLyjUserLivingplace(String lyjUserLivingplace) {
        this.lyjUserLivingplace = lyjUserLivingplace == null ? null : lyjUserLivingplace.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_user.lyj_user_workplace
     *
     * @return the value of lyj_user.lyj_user_workplace
     *
     * @mbggenerated
     */
    public String getLyjUserWorkplace() {
        return lyjUserWorkplace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_user.lyj_user_workplace
     *
     * @param lyjUserWorkplace the value for lyj_user.lyj_user_workplace
     *
     * @mbggenerated
     */
    public void setLyjUserWorkplace(String lyjUserWorkplace) {
        this.lyjUserWorkplace = lyjUserWorkplace == null ? null : lyjUserWorkplace.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_user.lyj_user_creditpositive
     *
     * @return the value of lyj_user.lyj_user_creditpositive
     *
     * @mbggenerated
     */
    public String getLyjUserCreditpositive() {
        return lyjUserCreditpositive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_user.lyj_user_creditpositive
     *
     * @param lyjUserCreditpositive the value for lyj_user.lyj_user_creditpositive
     *
     * @mbggenerated
     */
    public void setLyjUserCreditpositive(String lyjUserCreditpositive) {
        this.lyjUserCreditpositive = lyjUserCreditpositive == null ? null : lyjUserCreditpositive.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lyj_user.lyj_user_creditnegative
     *
     * @return the value of lyj_user.lyj_user_creditnegative
     *
     * @mbggenerated
     */
    public String getLyjUserCreditnegative() {
        return lyjUserCreditnegative;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lyj_user.lyj_user_creditnegative
     *
     * @param lyjUserCreditnegative the value for lyj_user.lyj_user_creditnegative
     *
     * @mbggenerated
     */
    public void setLyjUserCreditnegative(String lyjUserCreditnegative) {
        this.lyjUserCreditnegative = lyjUserCreditnegative == null ? null : lyjUserCreditnegative.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lyj_user
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lyjUserId=").append(lyjUserId);
        sb.append(", lyjUserOpenid=").append(lyjUserOpenid);
        sb.append(", lyjUserName=").append(lyjUserName);
        sb.append(", lyjUserGender=").append(lyjUserGender);
        sb.append(", lyjUserLocation=").append(lyjUserLocation);
        sb.append(", lyjUserAge=").append(lyjUserAge);
        sb.append(", lyjUserCountry=").append(lyjUserCountry);
        sb.append(", lyjUserCreditid=").append(lyjUserCreditid);
        sb.append(", lyjUserPhone=").append(lyjUserPhone);
        sb.append(", lyjUserLivingplace=").append(lyjUserLivingplace);
        sb.append(", lyjUserWorkplace=").append(lyjUserWorkplace);
        sb.append(", lyjUserCreditpositive=").append(lyjUserCreditpositive);
        sb.append(", lyjUserCreditnegative=").append(lyjUserCreditnegative);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
