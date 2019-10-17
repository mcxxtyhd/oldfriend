package com.feng.oldfriend.controller;

import com.feng.oldfriend.config.CommonResponse;
import com.feng.oldfriend.entity.LyjAdvertisement;
import com.feng.oldfriend.entity.LyjCompany;
import com.feng.oldfriend.entity.LyjCompanyrequirementRelation;
import com.feng.oldfriend.entity.LyjCompanyuserRelation;
import com.feng.oldfriend.service.LyjCompanyService;
import com.feng.oldfriend.service.LyjRequirementService;
import com.feng.oldfriend.service.LyjUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：yangchenxiao
 * @date ：Created in 2019/9/8 17:10
 * @description：机构的接口
 */
@RestController
@RequestMapping("/Company")
@Api(value = "Company", description = "机构")
public class LyjCompanyController {

    @Autowired
    private LyjCompanyService lyjCompanyService;

    @Autowired
    private LyjUserService lyjUserService;

    @Autowired
    private LyjRequirementService lyjRequirementService;

    @ApiOperation(value = "根据搜索内容查询所有的机构")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "Integer", value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Integer", value = "每页数量", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "searchText", dataType = "String", value = "搜索内容", required = false),
    })
    @GetMapping()
    public CommonResponse getCompanyBySearch(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                          @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                          @RequestParam(value = "searchText", required = false) String searchText) {
        try {
            pageNo = pageNo == null ? 1 : pageNo;
            pageSize = pageSize == null ? 10 : pageSize;

            PageHelper.startPage(pageNo, pageSize);

            //判断是否需要根据需求类型ID进行查询
            PageInfo pageInfo = new PageInfo(lyjCompanyService.getCompanies(searchText));

            return new CommonResponse(pageInfo, 200, lyjCompanyService.getCompaniesCount(searchText));
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }
    }


    /**
     * create by: yangchenxiao
     * create time: 2019/9/8 17:28
     * description: 新增机构
     */
    @ApiOperation(value = "新增机构")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "LyjCompany", dataType = "LyjCompany", value = "新增的机构", required = true)
    })
    @PostMapping()
    public CommonResponse addAdvertisement(@RequestBody LyjCompany lyjCompany){
        try{
            lyjCompanyService.saveCompany(lyjCompany);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/8 17:28
     * description: 更新机构信息
     */
    @ApiOperation(value = "更新机构信息")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "user", dataType = "LyjUser", value = "更新的机构信息", required = true)
    })
    @PutMapping()
    public CommonResponse updateAdvertisement(@RequestBody LyjCompany lyjCompany) {

        try{
            lyjCompanyService.updateCompany(lyjCompany);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }

    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/8 17:28
     * description: 删除机构
     */
    @ApiOperation(value = "删除机构")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "lyjCompanyId", dataType = "Integer", value = "需要删除的机构ID", required = true)
    })
    @DeleteMapping("/{lyjCompanyId}")
    public CommonResponse removeAdvertisement(@PathVariable(value = "lyjCompanyId",required = true) Integer lyjCompanyId) {
        try{
            lyjCompanyService.removeCompany(lyjCompanyId);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }

    }


    /**
     * create by: yangchenxiao
     * create time: 2019/9/8 17:28
     * description: 新增机构需求关系
     */
    @ApiOperation(value = "新增机构需求关系")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "LyjCompanyrequirementRelation", dataType = "LyjCompanyrequirementRelation", value = "新增的机构需求关系", required = true)
    })
    @PostMapping("/CR")
    public CommonResponse addRelationCR(@RequestBody LyjCompanyrequirementRelation lyjCompanyrequirementRelation){
        try{
            lyjCompanyService.saveRelationCR(lyjCompanyrequirementRelation);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/8 17:28
     * description: 删除机构需求关系
     */
    @ApiOperation(value = "删除机构需求关系")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "LyjCompanyrequirementRelation", dataType = "LyjCompanyrequirementRelation", value = "新增的机构需求关系", required = true)
    })
    @PostMapping("/DCR")
    public CommonResponse removeRelationCR(@RequestBody LyjCompanyrequirementRelation lyjCompanyrequirementRelation) {
        try{
            lyjCompanyService.removeRelationCR(lyjCompanyrequirementRelation);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }


    /**
     * create by: yangchenxiao
     * create time: 2019/9/9 21:30
     * description: 根据机构查询所有需求
     */
    @ApiOperation(value = "根据机构查询所有需求")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "Integer", value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Integer", value = "每页数量", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "companyId", dataType = "Integer", value = "机构id", required = false),
            @ApiImplicitParam(paramType = "query", name = "state", dataType = "Integer", value = "状态", required = false),
            @ApiImplicitParam(paramType = "query", name = "searchText", dataType = "String", value = "搜索内容", required = false),
    })
    @GetMapping(value = "/Requirements")
    public CommonResponse getRequirementsByCompany(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                                   @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                   @RequestParam(value = "companyId", required = false) Integer companyId,
                                                   @RequestParam(value = "state", required = false) Integer state,
                                                   @RequestParam(value = "searchText", required = false) String searchText) {
        try {
            pageNo = pageNo == null ? 1 : pageNo;
            pageSize = pageSize == null ? 10 : pageSize;

            PageHelper.startPage(pageNo, pageSize);

            //判断是否需要根据需求类型ID进行查询
            PageInfo pageInfo = new PageInfo(lyjRequirementService.getRequirementsByCompany(state,companyId,searchText));

            return new CommonResponse(pageInfo, 200, lyjRequirementService.getRequirementsCount(state,companyId,searchText));
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }
    }


    /**
     * create by: yangchenxiao
     * create time: 2019/9/8 17:28
     * description: 新增机构用户关系
     */
    @ApiOperation(value = "新增机构用户关系")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "LyjCompanyrequirementRelation", dataType = "LyjCompanyrequirementRelation", value = "新增机构用户关系", required = true)
    })
    @PostMapping("/CU")
    public CommonResponse addRelationCU(@RequestBody LyjCompanyuserRelation lyjCompanyuserRelation){
        try{
            lyjCompanyService.saveRelationCU(lyjCompanyuserRelation);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/8 17:28
     * description: 删除机构用户关系
     */
    @ApiOperation(value = "删除机构用户关系")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "LyjCompanyrequirementRelation", dataType = "LyjCompanyrequirementRelation", value = "新增机构用户关系", required = true)
    })
    @PostMapping("/DCU")
    public CommonResponse removeRelationCU(@RequestBody LyjCompanyuserRelation lyjCompanyuserRelation) {
        try{
            lyjCompanyService.removeRelationCU(lyjCompanyuserRelation);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/9/9 21:30
     * description: 根据机构查询所有的用户
     */
    @ApiOperation(value = "根据机构查询所有的用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "Integer", value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Integer", value = "每页数量", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "companyId", dataType = "Integer", value = "机构id", required = false),
            @ApiImplicitParam(paramType = "query", name = "state", dataType = "Integer", value = "状态", required = false),
            @ApiImplicitParam(paramType = "query", name = "searchText", dataType = "String", value = "搜索内容", required = false),
    })
    @GetMapping(value = "/Users")
    public CommonResponse getUsersByCompany(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                            @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                            @RequestParam(value = "companyId", required = false) Integer companyId,
                                            @RequestParam(value = "state", required = false) Integer state,
                                            @RequestParam(value = "searchText", required = false) String searchText) {
        try {
            pageNo = pageNo == null ? 1 : pageNo;
            pageSize = pageSize == null ? 10 : pageSize;

            PageHelper.startPage(pageNo, pageSize);

            //判断是否需要根据需求类型ID进行查询
            PageInfo pageInfo = new PageInfo(lyjUserService.getUsersByCompany(state,companyId,searchText));

            return new CommonResponse(pageInfo, 200, lyjUserService.getUsersByCompanyCount(state,companyId,searchText));
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }
    }
}
