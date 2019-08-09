package com.feng.oldfriend.controller;

import com.feng.oldfriend.entity.LyjRequirement;
import com.feng.oldfriend.entity.LyjRequirementType;
import com.feng.oldfriend.service.LyjRquirementTypeService;
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

import java.util.List;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/7/21 10:23
 * @description：需求类型的api接口
 */
@RestController
@RequestMapping("/RquirementType")
@Api(value = "RquirementType", description = "需求类型")
public class LyjRquirementTypeController {

    @Autowired
    private LyjRquirementTypeService lyjRquirementTypeService;

    @ApiOperation(value = "查询需求类型")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "Integer", value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Integer", value = "每页数量", defaultValue = "10")})
    @GetMapping()
    public ResponseEntity getRequirement(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                         @RequestParam(value = "pageSize", required = false) Integer pageSize)
    {

        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;

        PageHelper.startPage(pageNo, pageSize);

        PageInfo pageInfo = new PageInfo(lyjRquirementTypeService.getLyjRequirementTypes());
        return new ResponseEntity(pageInfo, HttpStatus.OK);

    }

    @ApiOperation(value = "根据父ID查询需求类型")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "parentID", dataType = "Integer", value = "父ID")})
    @GetMapping("/Sons")
    public ResponseEntity getRequirement(@RequestParam(value = "parentId", required = false) Integer parentId)
    {
//        try{
            List<LyjRequirementType> lyjRequirementTypes = lyjRquirementTypeService.getSonRequirementTypes(parentId);
            return new ResponseEntity(lyjRequirementTypes, HttpStatus.OK);
//        }
//        catch (Exception e){
//            System.out.println(e.toString());
//            return new ResponseEntity("后台程序出错，请联系管理员查看",HttpStatus.INTERNAL_SERVER_ERROR);
//        }

    }

    @ApiOperation(value = "新增需求类型")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "rquirementType", dataType = "RquirementType", value = "需求类型", required = true)
    })
    @PostMapping()
    public ResponseEntity addRequirement(@RequestBody LyjRequirementType lyjRequirementType) {
        try{
            lyjRquirementTypeService.saveRquirementType(lyjRequirementType);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("后台程序出错，请联系管理员查看",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @ApiOperation(value = "删除需求类型")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "rquirementTypeId", dataType = "Integer", value = "需要删除的需求类型ID", required = true)
    })
    @DeleteMapping("/{rquirementTypeId}")
    public ResponseEntity removeRequirement(@PathVariable("rquirementTypeId") Integer rquirementTypeId) {
        try{
            lyjRquirementTypeService.removeRquirementType(rquirementTypeId);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("后台程序出错，请联系管理员查看",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
