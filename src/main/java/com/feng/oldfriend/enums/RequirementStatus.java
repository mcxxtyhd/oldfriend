package com.feng.oldfriend.enums;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/9/11 22:51
 * @description：
 */
public enum  RequirementStatus {

    DRAFT(1, "草稿"),
    PUBLISHING(2, "发布中"),
    APPLING(3, "申请中"),
    PROCESSING(4, "进行中"),
    END(5, "任务结束"),
    FAIL(6, "任务失败");

    private Integer code;

    private String name;

    RequirementStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
