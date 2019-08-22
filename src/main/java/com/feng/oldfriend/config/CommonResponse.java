package com.feng.oldfriend.config;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/8/13 23:03
 * @description：
 */
public class CommonResponse {

    /**
     * create by: yangchenxiao
     * create time: 2019/8/13 23:04
     * description: 200成功；500失败
     */
    private Integer statusCode;

    private Object data;

    private Integer listCount;

    public Integer getListCount() {
        return listCount;
    }

    public void setListCount(Integer listCount) {
        this.listCount = listCount;
    }

    public CommonResponse(Object data,Integer statusCode, Integer listCount) {
        this.statusCode = statusCode;
        this.data = data;
        this.listCount = listCount;
    }

    public CommonResponse(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public CommonResponse( Object data,Integer statusCode) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
