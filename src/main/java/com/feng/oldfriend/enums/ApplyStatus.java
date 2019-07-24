package com.feng.oldfriend.enums;

/**
 * create by: yangchenxiao
 * create time: 2019/7/24 21:45
 * description: 申请状态
 */
public enum ApplyStatus {
    APPLYED(1, "申请中"),
    FAILED(2, "申请失败"),
    WAITED(3, "待完成"),
    NOTFINISHED(4, "未完成"),
    FINISHED(5, "已完成"),
    JUDGED(6, "已评价"),
    END(99, "任务结束");

    private Integer code;

    private String name;

    ApplyStatus(Integer code, String name) {
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
