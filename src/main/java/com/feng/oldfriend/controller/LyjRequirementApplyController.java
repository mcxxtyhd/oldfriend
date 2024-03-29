package com.feng.oldfriend.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.feng.oldfriend.VO.BatchUserState;
import com.feng.oldfriend.config.CommonResponse;
import com.feng.oldfriend.entity.LyjApplyChange;
import com.feng.oldfriend.entity.LyjRequirementApply;
import com.feng.oldfriend.service.LyjRequirementApplyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            @ApiImplicitParam(paramType = "query", name = "requirementId", dataType = "Integer", value = "需求ID", required = false)
    })
    @GetMapping()
    public CommonResponse getRequirementApplys(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                         @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                         @RequestParam(value = "requirementId", required = false) Integer requirementId) {
        try{
            pageNo = pageNo == null ? 1 : pageNo;
            pageSize = pageSize == null ? 10 : pageSize;

            PageHelper.startPage(pageNo, pageSize);

            //判断是否需要根据需求类型ID进行查询
            PageInfo pageInfo = new PageInfo(lyjRequirementApplyService.getRequirementApplys(requirementId));
            return new CommonResponse(pageInfo, 200,lyjRequirementApplyService.getRequirementApplysCount(requirementId));

        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }


    @ApiOperation(value = "根据参数(搜索内容,UUID)进行查找")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "Integer", value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Integer", value = "每页数量", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "searchText", dataType = "String", value = "查询关键字", required = false),
            @ApiImplicitParam(paramType = "query", name = "uuid", dataType = "String", value = "用户唯一标识ID", required = false),
            @ApiImplicitParam(paramType = "query", name = "status", dataType = "Integer", value = "需求状态", required = false)
    })
    @GetMapping("/Params")
    public CommonResponse getRequirementByParams(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                                 @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                 @RequestParam(value = "searchText", required = false) String searchText,
                                                 @RequestParam(value = "uuid", required = false) String uuid,
                                                 @RequestParam(value = "status", required = false) Integer[] status){
        try{
            pageNo = pageNo == null ? 1 : pageNo;
            pageSize = pageSize == null ? 10 : pageSize;

            PageHelper.startPage(pageNo, pageSize);

            PageInfo pageInfo = new PageInfo(lyjRequirementApplyService.getRequirementByParams(searchText,uuid,status));
            return new CommonResponse(pageInfo, 200,lyjRequirementApplyService.getRequirementByParamsCount(searchText,uuid,status));
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }

    }

//    这个接口还有点问题  0925  2239  pagehelper  无法翻页
    @ApiOperation(value = "根据参数(搜索内容,uuid，需求的状态)进行查找 ")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "Integer", value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Integer", value = "每页数量", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "searchText", dataType = "String", value = "查询关键字", required = false),
            @ApiImplicitParam(paramType = "query", name = "uuid", dataType = "String", value = "用户唯一标识ID", required = false),
            @ApiImplicitParam(paramType = "query", name = "status", dataType = "Integer", value = "需求状态", required = false),
            @ApiImplicitParam(paramType = "query", name = "typeid", dataType = "Integer", value = "需求类型ID", required = false)
    })
    @GetMapping("/ParamsType")
    public CommonResponse getRequirementByParamsType(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                                 @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                 @RequestParam(value = "searchText", required = false) String searchText,
                                                 @RequestParam(value = "uuid", required = false) String uuid,
                                                 @RequestParam(value = "status", required = false) Integer[] status,
                                                 @RequestParam(value = "typeid", required = false) Integer typeid){
        try{
            pageNo = pageNo == null ? 1 : pageNo;
            pageSize = pageSize == null ? 10 : pageSize;

            PageHelper.startPage(pageNo, pageSize);

            PageInfo pageInfo = new PageInfo(lyjRequirementApplyService.getRequirementByParamsType(searchText,uuid,status,typeid));
            return new CommonResponse(pageInfo, 200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }

    }


    @ApiOperation(value = "根据需求ID查询需求申请的数据")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "Integer", value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Integer", value = "每页数量", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "requirementid", dataType = "Integer", value = "需求ID", required = true)}
            )
    @GetMapping("/Id")
    public CommonResponse getRequirementById(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                                 @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                 @RequestParam(value = "requirementid", required = true) Integer requirementid){
        try{
            pageNo = pageNo == null ? 1 : pageNo;
            pageSize = pageSize == null ? 10 : pageSize;

            PageHelper.startPage(pageNo, pageSize);

            //判断是否需要根据需求类型ID进行查询
            PageInfo pageInfo = new PageInfo(lyjRequirementApplyService.getRequirementByIdStatus(requirementid,null));
            return new CommonResponse(pageInfo, 200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }

    }

    @ApiOperation(value = "根据需求状态查询需求申请的数据")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "Integer", value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Integer", value = "每页数量", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "status", dataType = "Integer", value = "需求状态", required = true)
    })
    @GetMapping("/Status")
    public CommonResponse getRequirementByStatus(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                                   @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                   @RequestParam(value = "status", required = true) Integer status){
        try{
            pageNo = pageNo == null ? 1 : pageNo;
            pageSize = pageSize == null ? 10 : pageSize;

            PageHelper.startPage(pageNo, pageSize);

            //判断是否需要根据需求类型ID进行查询
            PageInfo pageInfo = new PageInfo(lyjRequirementApplyService.getRequirementByIdStatus(null,status));
            return new CommonResponse(pageInfo, 200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }

    }


    @ApiOperation(value = "新增需求申请")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "requirementApply", dataType = "RequirementApply", value = "新增的需求申请", required = true)
    })
    @PostMapping()
    public CommonResponse addRequirementApply(@RequestBody LyjRequirementApply lyjRequirementApply) {
        try{
            lyjRequirementApplyService.saveRequirementApply(lyjRequirementApply);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    @ApiOperation(value = "更新需求")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "requirementApply", dataType = "RequirementApply", value = "更新的需求申请", required = true)
    })
    @PutMapping()
    public CommonResponse updateRequirementApply(@RequestBody LyjRequirementApply lyjRequirementApply) {
        try{
            lyjRequirementApplyService.updateRequirementApply(lyjRequirementApply);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/11 22:07
     * description: 批量更新需求申请的状态
     */
    @ApiOperation(value = "批量更新需求申请的状态")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "state", dataType = "Integer", value = "所要更改的状态", required = true),
            @ApiImplicitParam(paramType = "query", name = "ids", dataType = "List<Integer>", value = "需求ID集合", required = true)
    })
    @PutMapping("/Batch")
    public CommonResponse batchUpdateApplyState(@RequestBody BatchUserState datas) {
        try {
            return new CommonResponse(lyjRequirementApplyService.batchUpdateApplyState(datas),200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }
    }

    @ApiOperation(value = "删除需求申请")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "Id", dataType = "Integer", value = "需要删除的申请ID", required = true)
    })
    @DeleteMapping("/{Id}")
    public CommonResponse removeRequirementApply(@PathVariable("Id") Integer Id) {
        try{
            lyjRequirementApplyService.delRequirementApply(Id);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }

    }

    @ApiOperation(value = "更新需求申请的状态")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "LyjRequirementApplyid", dataType = "Integer", value = "需求申请的ID", required = true),
            @ApiImplicitParam(paramType = "query", name = "LyjRequirementApplystate", dataType = "Integer", value = "更新的状态码", required = true)
    })
    @PostMapping("/applyStatus")
    public CommonResponse updateRequirementApplyStatus(@RequestBody LyjRequirementApply lyjRequirementApply){

        try{
            lyjRequirementApplyService.updateRequirementApplyStatus(lyjRequirementApply.getLyjRequirementApplyid(),lyjRequirementApply.getLyjRequirementApplystate());
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    @ApiOperation(value = "更新需求的状态(更新解决无法调用的问题)")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "lyjApplyChange", dataType = "LyjApplyChange", value = "更新的状态码和申请ID的body", required = true)
    })
    @PostMapping("/NewStatusApplyID")
    public CommonResponse updateRequirementApplyStatusNew(@RequestBody LyjApplyChange lyjApplyChange) {

        try{
            int result=lyjRequirementApplyService.updateRequirementApplyStatus(Integer.valueOf(lyjApplyChange.getApplyId()),Integer.valueOf(lyjApplyChange.getStatus()));
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    @ApiOperation(value = "评价 打分 输入持续时间 输入评价")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "applyId", dataType = "Integer", value = "需求申请的ID", required = true),
            @ApiImplicitParam(paramType = "query", name = "star", dataType = "Integer", value = "评价星级", required = false),
            @ApiImplicitParam(paramType = "query", name = "comment", dataType = "String", value = "评价", required = false),
            @ApiImplicitParam(paramType = "query", name = "duration", dataType = "Integer", value = "持续时间(min)", required = false)
    })
    @GetMapping("/Judge")
    public CommonResponse JudgeRequirementApply(@RequestParam(value = "applyId",required = true) Integer applyId,
                                                @RequestParam(value = "star",required = true) Integer star,
                                                @RequestParam(value = "comment" ,required = false) String comment,
                                                @RequestParam(value = "duration",required = false) Integer duration) {

        try{
            lyjRequirementApplyService.JudgeRequirementApply( applyId, star, comment, duration);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    @ApiOperation(value = "评价 打分 输入持续时间 输入评价新")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "lyjRequirementApply", dataType = "lyjRequirementApply", value = "评价封装的对象", required = false)
    })
    @PostMapping("/JudgeNew")
    public CommonResponse JudgeRequirementApply(@RequestBody LyjRequirementApply lyjRequirementApply) {

        try{
            lyjRequirementApplyService.JudgeRequirementApply( lyjRequirementApply.getLyjRequirementApplyid(),
                    lyjRequirementApply.getLyjRequirementApplystar(),
                    lyjRequirementApply.getLyjRequirementApplycomment(),
                    lyjRequirementApply.getLyjRequirementApplyduration());
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    @ApiOperation(value = "将除了某个申请ID外的其他同一申请需求的申请置为申请失败")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "requirementId", dataType = "Integer", value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "requirementApplyId", dataType = "Integer", value = "每页数量", defaultValue = "10")
    })
    @PutMapping("/updatefail")
    public CommonResponse updateApplyFailed(@RequestParam(value = "requirementId", required = false) Integer requirementId,
                                            @RequestParam(value = "requirementApplyId", required = false) Integer requirementApplyId) {
        try{
            lyjRequirementApplyService.updateApplyFailed(requirementId,requirementApplyId);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }

    }

    @ApiOperation(value = "判断该用户是否能够申请当前的需求")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "requirementId", dataType = "Integer", value = "需求ID"),
            @ApiImplicitParam(paramType = "query", name = "uuid", dataType = "String", value = "用户的uuid")
    })
    @GetMapping("/CurrentApply")
    public CommonResponse checkIfBeApplied(@RequestParam(value = "requirementId", required = false) Integer requirementId,
                                            @RequestParam(value = "uuid", required = false) String uuid) {
        try{
            return new CommonResponse(lyjRequirementApplyService.checkIfBeApplied(requirementId,uuid),200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }

    }
}
