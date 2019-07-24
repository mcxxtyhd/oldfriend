package com.feng.oldfriend.service.impl;

import com.feng.oldfriend.dao.LyjRequirementTypeMapper;
import com.feng.oldfriend.entity.LyjRequirementType;
import com.feng.oldfriend.service.LyjRTRelationService;
import com.feng.oldfriend.service.LyjRquirementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("LyjRquirementTypeService")
public class LyjRquirementTypeServiceImpl implements LyjRquirementTypeService {

    @Autowired
    private LyjRequirementTypeMapper lyjRequirementTypeMapper;

    @Autowired
    private LyjRTRelationService lyjRTRelationService;

    /**
     * create by: yangchenxiao
     * create time: 2019/7/24 20:58
     * description: 获取所有的需求类型
     */
    @Override
    public List<LyjRequirementType> getLyjRequirementTypes() {
        return lyjRequirementTypeMapper.selectAll();
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/24 20:48
     * description: 新增需求类型
     */
    @Override
    public void saveRquirementType(LyjRequirementType lyjRequirementType) {
        lyjRequirementTypeMapper.insert(lyjRequirementType);
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/7/24 20:48
     * description: 新增需求类型
     */
    @Override
    public void removeRquirementType(Integer id) {
        //1、先检查在关系表中是否有数据
        List<Integer> allDatas=lyjRTRelationService.getRequirementsByTypeid(id);
        //如果有数据就抛出异常
        if(allDatas.size()>0){
            throw new RuntimeException();
        }

        //2、再删除需求类型
        lyjRequirementTypeMapper.deleteByPrimaryKey(id);
    }
}
