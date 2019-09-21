package com.feng.oldfriend.enums;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/9/8 11:30
 * @description：用户审批的状态码
 */
public enum userApplystate {

    APPLYED(1, "初始状态"),
    FAILED(2, "待审批"),
    WAITED(3, "审批通过"),
    NOTFINISHED(4, "审批驳回");


    private Integer code;
    private String description;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    userApplystate(Integer code, String description) {
        this.code = code;
        this.description = description;
    }}
