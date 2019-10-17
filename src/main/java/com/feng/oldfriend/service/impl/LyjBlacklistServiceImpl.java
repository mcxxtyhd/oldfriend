package com.feng.oldfriend.service.impl;

import com.feng.oldfriend.dao.LyjBlacklistMapper;
import com.feng.oldfriend.entity.LyjBlacklist;
import com.feng.oldfriend.service.LyjBlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/10/15 21:12
 * @description：黑名单的相关接口方法
 */
@Service("LyjBlacklistService")
public class LyjBlacklistServiceImpl implements LyjBlacklistService {

    @Autowired
    private LyjBlacklistMapper lyjBlacklistMapper;

    @Override
    public List<LyjBlacklist> getDatas(String searchText) {
        return lyjBlacklistMapper.getDatasByUsername(searchText);
    }

    @Override
    public void saveBlack(LyjBlacklist data) {
        //设置创建时间
        data.setLyjBlacklistCreatetime(new Date());
        data.setLyjBlacklistIsdel(1);
        lyjBlacklistMapper.insert(data);
    }

    @Override
    public void removeBlack(String uuid) {
        lyjBlacklistMapper.deleteByPrimaryKey(uuid);
    }
}
