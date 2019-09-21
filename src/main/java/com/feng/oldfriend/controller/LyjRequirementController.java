package com.feng.oldfriend.controller;

import com.feng.oldfriend.VO.BatchUserState;
import com.feng.oldfriend.config.CommonResponse;
import com.feng.oldfriend.entity.LyjRequirement;
import com.feng.oldfriend.entity.LyjRequirementType;
import com.feng.oldfriend.entity.LyjRequirementVO;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            @ApiImplicitParam(paramType = "query", name = "searchText", dataType = "String", value = "查询关键字", required = true),
            @ApiImplicitParam(paramType = "query", name = "typeId", dataType = "Integer", value = "需求类型ID", required = false)
    })
    @GetMapping()
    public CommonResponse getRequirement(@RequestParam(value = "pageNo", required = true) Integer pageNo,
                                            @RequestParam(value = "pageSize", required = true) Integer pageSize,
                                            @RequestParam(value = "searchText", required = true) String searchText,
                                            @RequestParam(value = "typeId", required = false) Integer typeId) {
        try{
            pageNo = pageNo == null ? 1 : pageNo;
            pageSize = pageSize == null ? 10 : pageSize;

            PageHelper.startPage(pageNo, pageSize);

            //判断是否需要根据需求类型ID进行查询
            PageInfo pageInfo = new PageInfo(lyjRequirementService.getRequirements(searchText,typeId));
            return new CommonResponse(pageInfo, 200,lyjRequirementService.getRequirementCount(searchText,typeId));
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }

    }

    @ApiOperation(value = "根据需求ID查询需求类型")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "requirementId", dataType = "Integer", value = "需求ID", required = true),
    })
    @GetMapping("/type/{requirementId}")
    public CommonResponse getTypesById(@PathVariable("requirementId") Integer requirementId) {
        try{
            List<LyjRequirementType> types=lyjRequirementService.getTypesById(requirementId);
            return new CommonResponse(types,200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    @ApiOperation(value = "根据需求ID查询详情")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "requirementId", dataType = "Integer", value = "需求ID", required = true),
    })
    @GetMapping("/{requirementId}")
    public CommonResponse getRequirementById(@PathVariable("requirementId") Integer requirementId) {
        try{
            LyjRequirement lyjRequirement=lyjRequirementService.getRequirementById(requirementId);
            return new CommonResponse(lyjRequirement,200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }


    @ApiOperation(value = "查询我创建的需求")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "uuid", dataType = "String", value = "用户唯一标识", required = true),
    })
    @GetMapping("/Mine/{uuid}")
    public CommonResponse getMyRequirement(@PathVariable("uuid") String uuid) {
        try{
            return new CommonResponse(lyjRequirementService.getMyRequirement(uuid),200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    @ApiOperation(value = "查询我中标的需求")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "requirementId", dataType = "Integer", value = "需求ID", required = true),
    })
    @GetMapping("/MineAplly/{uuid}")
    public CommonResponse getMyApplyRequirement(@PathVariable("uuid") String uuid) {
        try{
            return new CommonResponse(lyjRequirementService.getMyApplyRequirement(uuid),200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    @ApiOperation(value = "新增需求包括需求类型(单独)")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "typeId", dataType = "Integer", value = "该新增需求的类型ID", required = true),
            @ApiImplicitParam(paramType = "body", name = "requirement", dataType = "Requirement", value = "新增的需求信息", required = true)
    })
    @PostMapping("/{typeId}")
    public CommonResponse addRequirement(@PathVariable("typeId") Integer typeId,@RequestBody LyjRequirement lyjRequirement) {
        try{
            lyjRequirementService.saveRequirement(typeId,lyjRequirement);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    @ApiOperation(value = "新增需求(包含多个需求类型(非必填))")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "requirement", dataType = "Requirement", value = "新增的需求信息", required = true)
    })
    @PostMapping()
    public CommonResponse addRequirementAdvanced(@RequestBody LyjRequirementVO lyjRequirementVO) {
        try{
            lyjRequirementService.saveRequirementAdvanced(lyjRequirementVO);
            return new CommonResponse(lyjRequirementVO,200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    @ApiOperation(value = "更新需求")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "requirement", dataType = "Requirement", value = "更新的需求信息", required = true)
    })
    @PutMapping()
    public CommonResponse updateRequirement(@RequestBody LyjRequirementVO lyjRequirement) {

        lyjRequirementService.updateRequirement(lyjRequirement);
        return new CommonResponse(200);
    }

    @ApiOperation(value = "删除需求")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "requirementId", dataType = "Integer", value = "需要删除的需求ID", required = true)
    })
    @DeleteMapping("/{requirementId}")
    public CommonResponse removeRequirement(@PathVariable("requirementId") Integer requirementId) {
        try{
            lyjRequirementService.removeRequirement(requirementId);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }

    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/11 22:07
     * description: 批量更新需求的状态
     */
    @ApiOperation(value = "更新需求审批状态")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "state", dataType = "Integer", value = "所要更改的状态", required = true),
            @ApiImplicitParam(paramType = "query", name = "ids", dataType = "List<Integer>", value = "需求ID集合", required = true)
    })
    @PutMapping("/Batch")
    public CommonResponse batchUpdateRequirementState(@RequestBody BatchUserState datas) {
        try {
            lyjRequirementService.batchUpdateRequirementState(datas);
            return new CommonResponse(200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }
    }

    @ApiOperation(value = "更新需求流程状态")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "state", dataType = "Integer", value = "所要更改的状态", required = true),
            @ApiImplicitParam(paramType = "query", name = "ids", dataType = "List<Integer>", value = "需求ID集合", required = true)
    })
    @PutMapping("/BatchProcess")
    public CommonResponse batchUpdateRequirementProcess(@RequestBody BatchUserState datas) {
        try {
            lyjRequirementService.batchUpdateRequirementProcess(datas);
            return new CommonResponse(200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }
    }
}
