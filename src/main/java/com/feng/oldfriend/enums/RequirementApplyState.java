package com.feng.oldfriend.enums;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/9/11 21:35
 * @description：
 */
public enum RequirementApplyState {

    //1:未审批，2:已审批，3:已发布，4:审批不通过

    NOT(1, "未审批"),
    YES(2, "已审批"),
    PUBLISHED(3, "已发布"),
    NOTApprove(4, "审批不通过");

    private Integer code;

    private String name;

    RequirementApplyState(Integer code, String name) {
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
