package com.feng.oldfriend.controller;

import com.feng.oldfriend.entity.LyjRequirement;
import com.feng.oldfriend.service.LyjRequirementService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
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
 * @description：需求的api接口
 */
@RestController
@RequestMapping("/Requirement")
@Api(value = "Requirement", description = "需求")
public class LyjRequirementController {

    @Autowired
    private LyjRequirementService lyjRequirementService;

    @ApiOperation(value = "查询需求")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "Integer", value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Integer", value = "每页数量", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "searchText", dataType = "String", value = "查询关键字", required = false),
            @ApiImplicitParam(paramType = "query", name = "typeId", dataType = "Integer", value = "需求类型ID", required = false)
    })
    @GetMapping()
    public ResponseEntity getRequirement(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                            @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                            @RequestParam(value = "searchText", required = false) String searchText,
                                            @RequestParam(value = "typeId", required = false) Integer typeId) {

        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;

        PageHelper.startPage(pageNo, pageSize);

        //判断是否需要根据需求类型ID进行查询
        PageInfo pageInfo = new PageInfo(lyjRequirementService.getRequirements(searchText,typeId));
        return new ResponseEntity(pageInfo, HttpStatus.OK);

    }

    @ApiOperation(value = "根据需求ID查询详情")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "requirementId", dataType = "Integer", value = "需求ID", required = true),
    })
    @GetMapping("/{requirementId}")
    public ResponseEntity getRequirementById(@PathVariable("requirementId") Integer requirementId) {
        try{
            LyjRequirement lyjRequirement=lyjRequirementService.getRequirementById(requirementId);
            return new ResponseEntity(lyjRequirement,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("后台程序出错，请联系管理员查看",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "新增需求")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "typeId", dataType = "Integer", value = "该新增需求的类型ID", required = true),
            @ApiImplicitParam(paramType = "body", name = "requirement", dataType = "Requirement", value = "新增的需求信息", required = true)
    })
    @PostMapping("/{typeId}")
    public ResponseEntity addRequirement(@PathVariable("typeId") Integer typeId,@RequestBody LyjRequirement lyjRequirement) {
        try{
            lyjRequirementService.saveRequirement(typeId,lyjRequirement);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("后台程序出错，请联系管理员查看",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "更新需求")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "requirement", dataType = "Requirement", value = "更新的需求信息", required = true)
    })
    @PutMapping()
    public ResponseEntity updateRequirement(@RequestBody LyjRequirement lyjRequirement) {

        lyjRequirementService.updateRequirement(lyjRequirement);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "删除需求")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "requirementId", dataType = "Integer", value = "需要删除的需求ID", required = true)
    })
    @DeleteMapping("/{requirementId}")
    public ResponseEntity removeRequirement(@PathVariable("requirementId") Integer requirementId) {
        try{
            lyjRequirementService.removeRequirement(requirementId);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("后台程序出错，请联系管理员查看",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
