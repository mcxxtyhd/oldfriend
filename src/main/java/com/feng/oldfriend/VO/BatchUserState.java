package com.feng.oldfriend.VO;

import java.util.List;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/9/11 21:14
 * @description：
 */
public class BatchUserState {

    private Integer state;

    private List<String> uuids;

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<String> getUuids() {
        return uuids;
    }

    public void setUuids(List<String> uuids) {
        this.uuids = uuids;
    }
}
