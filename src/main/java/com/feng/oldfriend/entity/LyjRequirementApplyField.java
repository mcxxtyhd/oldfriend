package com.feng.oldfriend.entity;

import java.util.Date;
import java.util.List;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/7/28 16:52
 * @description：
 */
public class LyjRequirementApplyField {

    private String lyj_user_name;
    private Integer lyj_requirement_applyid;
    private String lyj_user_id;
    private Integer lyj_volunteer_id;
    private Integer lyj_requirement_applystate;
    private String lyj_requirement_applycomment;
    private Integer lyj_requirement_applystar;
    private Integer lyj_requirement_applyrequirementid;
    private Integer lyj_requirement_applyduration;
    private Integer lyj_requirement_id;
    private String lyj_requirement_name;
    private String lyj_requirement_description;
    private String lyj_requirement_createuser;
    private String lyj_requirement_applyuser;
    private Integer lyj_requirement_isvolunteer;
    private String lyj_requirement_city;
    private String lyj_requirement_area;
    private String lyj_requirement_street;
    private Date lyj_requirement_createdatetime;
    private Date lyj_requirement_begindatetime;
    private Date lyj_requirement_enddatetime;
    private String lyj_requirement_rawaddress;
    private String lyj_requirement_maplocation;
    private Integer  lyj_requirement_reward;
    private Integer lyj_requirement_volunteerperfer;
    private List<LyjRequirementType> allTypes;
    private String lyj_user_phone;
    private Integer lyj_user_avestar;
    private Integer lyj_requirement_process;

    private Date lyj_requirement_apply_createdate;
    private Date lyj_requirement_apply_rejectdate;
    private Date lyj_requirement_apply_approvedate;
    private Date lyj_requirement_apply_servicedate;
    private Date lyj_requirement_apply_finishdate;
    private Date lyj_requirement_apply_faildate;

    public Date getLyj_requirement_apply_createdate() {
        return lyj_requirement_apply_createdate;
    }

    public void setLyj_requirement_apply_createdate(Date lyj_requirement_apply_createdate) {
        this.lyj_requirement_apply_createdate = lyj_requirement_apply_createdate;
    }

    public Date getLyj_requirement_apply_rejectdate() {
        return lyj_requirement_apply_rejectdate;
    }

    public void setLyj_requirement_apply_rejectdate(Date lyj_requirement_apply_rejectdate) {
        this.lyj_requirement_apply_rejectdate = lyj_requirement_apply_rejectdate;
    }

    public Date getLyj_requirement_apply_approvedate() {
        return lyj_requirement_apply_approvedate;
    }

    public void setLyj_requirement_apply_approvedate(Date lyj_requirement_apply_approvedate) {
        this.lyj_requirement_apply_approvedate = lyj_requirement_apply_approvedate;
    }

    public Date getLyj_requirement_apply_servicedate() {
        return lyj_requirement_apply_servicedate;
    }

    public void setLyj_requirement_apply_servicedate(Date lyj_requirement_apply_servicedate) {
        this.lyj_requirement_apply_servicedate = lyj_requirement_apply_servicedate;
    }

    public Date getLyj_requirement_apply_finishdate() {
        return lyj_requirement_apply_finishdate;
    }

    public void setLyj_requirement_apply_finishdate(Date lyj_requirement_apply_finishdate) {
        this.lyj_requirement_apply_finishdate = lyj_requirement_apply_finishdate;
    }

    public Date getLyj_requirement_apply_faildate() {
        return lyj_requirement_apply_faildate;
    }

    public void setLyj_requirement_apply_faildate(Date lyj_requirement_apply_faildate) {
        this.lyj_requirement_apply_faildate = lyj_requirement_apply_faildate;
    }

    public Integer getLyj_requirement_process() {
        return lyj_requirement_process;
    }

    public void setLyj_requirement_process(Integer lyj_requirement_process) {
        this.lyj_requirement_process = lyj_requirement_process;
    }

    public Integer getLyj_user_avestar() {
        return lyj_user_avestar;
    }

    public void setLyj_user_avestar(Integer lyj_user_avestar) {
        this.lyj_user_avestar = lyj_user_avestar;
    }

    public String getLyj_user_phone() {
        return lyj_user_phone;
    }

    public void setLyj_user_phone(String lyj_user_phone) {
        this.lyj_user_phone = lyj_user_phone;
    }

    public List<LyjRequirementType> getAllTypes() {
        return allTypes;
    }

    public void setAllTypes(List<LyjRequirementType> allTypes) {
        this.allTypes = allTypes;
    }

    public String getLyj_user_name() {
        return lyj_user_name;
    }

    public void setLyj_user_name(String lyj_user_name) {
        this.lyj_user_name = lyj_user_name;
    }

    public Integer getLyj_requirement_volunteerperfer() {
        return lyj_requirement_volunteerperfer;
    }

    public void setLyj_requirement_volunteerperfer(Integer lyj_requirement_volunteerperfer) {
        this.lyj_requirement_volunteerperfer = lyj_requirement_volunteerperfer;
    }

    public Integer getLyj_requirement_applyid() {
        return lyj_requirement_applyid;
    }

    public void setLyj_requirement_applyid(Integer lyj_requirement_applyid) {
        this.lyj_requirement_applyid = lyj_requirement_applyid;
    }

    public String getLyj_user_id() {
        return lyj_user_id;
    }

    public void setLyj_user_id(String lyj_user_id) {
        this.lyj_user_id = lyj_user_id;
    }

    public Integer getLyj_volunteer_id() {
        return lyj_volunteer_id;
    }

    public void setLyj_volunteer_id(Integer lyj_volunteer_id) {
        this.lyj_volunteer_id = lyj_volunteer_id;
    }

    public Integer getLyj_requirement_applystate() {
        return lyj_requirement_applystate;
    }

    public void setLyj_requirement_applystate(Integer lyj_requirement_applystate) {
        this.lyj_requirement_applystate = lyj_requirement_applystate;
    }

    public String getLyj_requirement_applycomment() {
        return lyj_requirement_applycomment;
    }

    public void setLyj_requirement_applycomment(String lyj_requirement_applycomment) {
        this.lyj_requirement_applycomment = lyj_requirement_applycomment;
    }

    public Integer getLyj_requirement_applystar() {
        return lyj_requirement_applystar;
    }

    public void setLyj_requirement_applystar(Integer lyj_requirement_applystar) {
        this.lyj_requirement_applystar = lyj_requirement_applystar;
    }

    public Integer getLyj_requirement_applyrequirementid() {
        return lyj_requirement_applyrequirementid;
    }

    public void setLyj_requirement_applyrequirementid(Integer lyj_requirement_applyrequirementid) {
        this.lyj_requirement_applyrequirementid = lyj_requirement_applyrequirementid;
    }

    public Integer getLyj_requirement_applyduration() {
        return lyj_requirement_applyduration;
    }

    public void setLyj_requirement_applyduration(Integer lyj_requirement_applyduration) {
        this.lyj_requirement_applyduration = lyj_requirement_applyduration;
    }

    public Integer getLyj_requirement_id() {
        return lyj_requirement_id;
    }

    public void setLyj_requirement_id(Integer lyj_requirement_id) {
        this.lyj_requirement_id = lyj_requirement_id;
    }

    public String getLyj_requirement_name() {
        return lyj_requirement_name;
    }

    public void setLyj_requirement_name(String lyj_requirement_name) {
        this.lyj_requirement_name = lyj_requirement_name;
    }

    public String getLyj_requirement_description() {
        return lyj_requirement_description;
    }

    public void setLyj_requirement_description(String lyj_requirement_description) {
        this.lyj_requirement_description = lyj_requirement_description;
    }

    public String getLyj_requirement_createuser() {
        return lyj_requirement_createuser;
    }

    public void setLyj_requirement_createuser(String lyj_requirement_createuser) {
        this.lyj_requirement_createuser = lyj_requirement_createuser;
    }

    public String getLyj_requirement_applyuser() {
        return lyj_requirement_applyuser;
    }

    public void setLyj_requirement_applyuser(String lyj_requirement_applyuser) {
        this.lyj_requirement_applyuser = lyj_requirement_applyuser;
    }

    public Integer getLyj_requirement_isvolunteer() {
        return lyj_requirement_isvolunteer;
    }

    public void setLyj_requirement_isvolunteer(Integer lyj_requirement_isvolunteer) {
        this.lyj_requirement_isvolunteer = lyj_requirement_isvolunteer;
    }

    public String getLyj_requirement_city() {
        return lyj_requirement_city;
    }

    public void setLyj_requirement_city(String lyj_requirement_city) {
        this.lyj_requirement_city = lyj_requirement_city;
    }

    public String getLyj_requirement_area() {
        return lyj_requirement_area;
    }

    public void setLyj_requirement_area(String lyj_requirement_area) {
        this.lyj_requirement_area = lyj_requirement_area;
    }

    public String getLyj_requirement_street() {
        return lyj_requirement_street;
    }

    public void setLyj_requirement_street(String lyj_requirement_street) {
        this.lyj_requirement_street = lyj_requirement_street;
    }

    public Date getLyj_requirement_createdatetime() {
        return lyj_requirement_createdatetime;
    }

    public void setLyj_requirement_createdatetime(Date lyj_requirement_createdatetime) {
        this.lyj_requirement_createdatetime = lyj_requirement_createdatetime;
    }

    public Date getLyj_requirement_begindatetime() {
        return lyj_requirement_begindatetime;
    }

    public void setLyj_requirement_begindatetime(Date lyj_requirement_begindatetime) {
        this.lyj_requirement_begindatetime = lyj_requirement_begindatetime;
    }

    public Date getLyj_requirement_enddatetime() {
        return lyj_requirement_enddatetime;
    }

    public void setLyj_requirement_enddatetime(Date lyj_requirement_enddatetime) {
        this.lyj_requirement_enddatetime = lyj_requirement_enddatetime;
    }

    public String getLyj_requirement_rawaddress() {
        return lyj_requirement_rawaddress;
    }

    public void setLyj_requirement_rawaddress(String lyj_requirement_rawaddress) {
        this.lyj_requirement_rawaddress = lyj_requirement_rawaddress;
    }

    public String getLyj_requirement_maplocation() {
        return lyj_requirement_maplocation;
    }

    public void setLyj_requirement_maplocation(String lyj_requirement_maplocation) {
        this.lyj_requirement_maplocation = lyj_requirement_maplocation;
    }

    public Integer getLyj_requirement_reward() {
        return lyj_requirement_reward;
    }

    public void setLyj_requirement_reward(Integer lyj_requirement_reward) {
        this.lyj_requirement_reward = lyj_requirement_reward;
    }

    private static final long serialVersionUID = 1L;

}
