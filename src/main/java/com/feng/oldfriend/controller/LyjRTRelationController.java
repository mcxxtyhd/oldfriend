package com.feng.oldfriend.controller;

import com.feng.oldfriend.config.CommonResponse;
import com.feng.oldfriend.service.LyjRTRelationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/7/21 10:23
 * @description：需求和需求类型的关系 api接口
 */
@RestController
@RequestMapping("/RTRelation")
@Api(value = "RTRelation", description = "需求和类型的关系表")
public class LyjRTRelationController {

    @Autowired
    private LyjRTRelationService lyjRTRelationService;

    @ApiOperation(value = "新增关系数据")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "requirementId", dataType = "Integer", value = "需求ID", required = true),
            @ApiImplicitParam(paramType = "body", name = "typeIds", dataType = "List<Integer>", value = "类型ID组", required = true)
    })
    @PostMapping("/{requirementId}")
    public CommonResponse addRTRelation(@PathVariable("requirementId") Integer requirementId, @RequestBody Integer[] typeIds) {
        lyjRTRelationService.addRTRelation(requirementId,typeIds);
        return new CommonResponse(200);

    }

    @ApiOperation(value = "高级新增关系数据(先删除再新增)")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "requirementId", dataType = "Integer", value = "需求ID", required = true),
            @ApiImplicitParam(paramType = "body", name = "typeIds", dataType = "List<Integer>", value = "类型ID组", required = true)
    })
    @PostMapping("/advanced/{requirementId}")
    public CommonResponse addRTRelationAdvanced(@PathVariable("requirementId") Integer requirementId, @RequestBody Integer[] typeIds) {
        try{
            lyjRTRelationService.addRTRelationAdvanced(requirementId,typeIds);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    @ApiOperation(value = "删除需求下所有的关系数据")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "requirementId", dataType = "Integer", value = "需要删除关系数据的需求ID", required = true)
    })
    @DeleteMapping("/{requirementId}")
    public CommonResponse removeRequirement(@PathVariable("requirementId") Integer requirementId) {
        lyjRTRelationService.removeRTRelationByRid(requirementId);
        return new CommonResponse(200);

    }

}
