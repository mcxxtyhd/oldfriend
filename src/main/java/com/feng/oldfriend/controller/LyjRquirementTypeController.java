package com.feng.oldfriend.controller;

import com.feng.oldfriend.config.CommonResponse;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Integer", value = "每页数量", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "searchText", dataType = "String", value = "查询关键字", required = false),})
    @GetMapping()
    public CommonResponse getRequirement(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                         @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                         @RequestParam(value = "searchText", required = false) String searchText)
    {

        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;

        PageHelper.startPage(pageNo, pageSize);

        PageInfo pageInfo = new PageInfo(lyjRquirementTypeService.getLyjRequirementTypes(searchText));
        return new CommonResponse(pageInfo, 200);

    }

    @ApiOperation(value = "查询需求类型(Count)")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "searchText", dataType = "String", value = "查询关键字", required = false),})
    @GetMapping("/Count")
    public CommonResponse getRequirementCount(@RequestParam(value = "searchText", required = false) String searchText)
    {
        return new CommonResponse(lyjRquirementTypeService.getLyjRequirementTypes(searchText), 200,lyjRquirementTypeService.getLyjRequirementTypesCount(searchText));

    }

    @ApiOperation(value = "根据父ID查询需求类型")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "parentID", dataType = "Integer", value = "父ID")})
    @GetMapping("/Sons")
    public CommonResponse getRequirement(@RequestParam(value = "parentId", required = false) Integer parentId)
    {
        try{
            List<LyjRequirementType> lyjRequirementTypes = lyjRquirementTypeService.getSonRequirementTypes(parentId);
            return new CommonResponse(lyjRequirementTypes, 200);
        }
        catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }

    }

    @ApiOperation(value = "返回所有的父需求类型")
    @GetMapping("/Father")
    public CommonResponse getFatherRequirement()
    {
        try{
            List<LyjRequirementType> lyjRequirementTypes = lyjRquirementTypeService.getSonRequirementTypes(null);
            return new CommonResponse(lyjRequirementTypes, 200);
        }
        catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }

    }

    @ApiOperation(value = "新增需求类型")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "rquirementType", dataType = "RquirementType", value = "需求类型", required = true)
    })
    @PostMapping()
    public CommonResponse addRequirementType(@RequestBody LyjRequirementType lyjRequirementType) {
        try{
            lyjRquirementTypeService.saveRquirementType(lyjRequirementType);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    @ApiOperation(value = "编辑需求类型")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "rquirementType", dataType = "RquirementType", value = "需求类型", required = true)
    })
    @PutMapping()
    public CommonResponse updateRequirementType(@RequestBody LyjRequirementType lyjRequirementType) {
        try{
            lyjRquirementTypeService.updateRquirementType(lyjRequirementType);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }


    @ApiOperation(value = "删除需求类型")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "rquirementTypeId", dataType = "Integer", value = "需要删除的需求类型ID", required = true)
    })
    @DeleteMapping("/{rquirementTypeId}")
    public CommonResponse removeRequirementType(@PathVariable("rquirementTypeId") Integer rquirementTypeId) {
        try{
            lyjRquirementTypeService.removeRquirementType(rquirementTypeId);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }

    }

    @ApiOperation(value = "根据需求状态查询所有的需求类型")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "status", dataType = "Integer", value = "需求的状态", required = false)
    })
    @GetMapping("/Status")
    public CommonResponse getRequirementTypeByStatus(@RequestParam(value = "status", required = false) Integer status) {
        try{
            //判断是否需要根据需求类型ID进行查询
            return new CommonResponse(lyjRquirementTypeService.getRequirementTypeByStatus(status), 200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }

    }
}
