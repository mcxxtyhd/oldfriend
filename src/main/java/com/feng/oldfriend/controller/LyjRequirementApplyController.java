package com.feng.oldfriend.controller;

import com.feng.oldfriend.entity.LyjRequirement;
import com.feng.oldfriend.entity.LyjRequirementApply;
import com.feng.oldfriend.service.LyjRequirementApplyService;
import com.feng.oldfriend.service.impl.LyjRequirementApplyServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/7/21 10:23
 * @description：需求申请的api接口
 */
@RestController
@RequestMapping("/RequirementApply")
@Api(value = "RequirementApply", description = "需求申请")
public class LyjRequirementApplyController {

    @Autowired
    private LyjRequirementApplyService lyjRequirementApplyService;

    @ApiOperation(value = "根据需求ID查询所有的申请")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "Integer", value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Integer", value = "每页数量", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "requirementId", dataType = "Integer", value = "需求ID", required = true)
    })
    @GetMapping("/{requirementId}")
    public ResponseEntity getRequirementApplys(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                         @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                         @RequestParam(value = "requirementId", required = true) Integer requirementId) {

        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;

        PageHelper.startPage(pageNo, pageSize);

        //判断是否需要根据需求类型ID进行查询
        PageInfo pageInfo = new PageInfo(lyjRequirementApplyService.getRequirementApplys(requirementId));
        return new ResponseEntity(pageInfo, HttpStatus.OK);

    }

    @ApiOperation(value = "新增需求申请")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "requirementApply", dataType = "RequirementApply", value = "新增的需求申请", required = true)
    })
    @PostMapping()
    public ResponseEntity addRequirementApply(@RequestBody LyjRequirementApply lyjRequirementApply) {
        try{
            lyjRequirementApplyService.saveRequirementApply(lyjRequirementApply);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("后台程序出错，请联系管理员查看",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "更新需求")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "requirementApply", dataType = "RequirementApply", value = "更新的需求申请", required = true)
    })
    @PutMapping()
    public ResponseEntity updateRequirementApply(@RequestBody LyjRequirementApply lyjRequirementApply) {

        lyjRequirementApplyService.updateRequirementApply(lyjRequirementApply);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "将除了某个申请ID外的其他同一申请需求的申请置为申请失败")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "requirementId", dataType = "Integer", value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "requirementApplyId", dataType = "Integer", value = "每页数量", defaultValue = "10")
    })
    @PutMapping("/updatefail")
    public ResponseEntity updateApplyFailed(@RequestParam(value = "requirementId", required = false) Integer requirementId,
                                            @RequestParam(value = "requirementApplyId", required = false) Integer requirementApplyId) {

        lyjRequirementApplyService.updateApplyFailed(requirementId,requirementApplyId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
