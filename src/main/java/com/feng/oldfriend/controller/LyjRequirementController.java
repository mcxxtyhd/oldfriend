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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
            @ApiImplicitParam(paramType = "query", name = "typeId", dataType = "Integer", value = "需求类型ID", required = false),
            @ApiImplicitParam(paramType = "query", name = "state", dataType = "Integer", value = "需求审批状态", required = false)

    })
    @GetMapping()
    public CommonResponse getRequirement(@RequestParam(value = "pageNo", required = true) Integer pageNo,
                                         @RequestParam(value = "pageSize", required = true) Integer pageSize,
                                         @RequestParam(value = "searchText", required = true) String searchText,
                                         @RequestParam(value = "typeId", required = false) Integer typeId,
                                         @RequestParam(value = "state", required = false) Integer state) {
        try {
            pageNo = pageNo == null ? 1 : pageNo;
            pageSize = pageSize == null ? 10 : pageSize;

            PageHelper.startPage(pageNo, pageSize);

            //判断是否需要根据需求类型ID进行查询
            PageInfo pageInfo = new PageInfo(lyjRequirementService.getRequirements(searchText, typeId,state));
            return new CommonResponse(pageInfo, 200, lyjRequirementService.getRequirementCount(searchText, typeId,state));
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }

    }

    @ApiOperation(value = "根据类别 城市 街道 开始时间 查询需求")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "Integer", value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Integer", value = "每页数量", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "searchText", dataType = "String", value = "查询关键字", required = false),
            @ApiImplicitParam(paramType = "query", name = "typeId", dataType = "Integer", value = "需求类型ID", required = false),
            @ApiImplicitParam(paramType = "query", name = "city", dataType = "String", value = "需求类型ID", required = false),
            @ApiImplicitParam(paramType = "query", name = "street", dataType = "String", value = "需求类型ID", required = false),
            @ApiImplicitParam(paramType = "query", name = "firstDate", dataType = "String", value = "查询的时间前", required = false),
            @ApiImplicitParam(paramType = "query", name = "secondDate", dataType = "String", value = "查询的时间后", required = false),
            @ApiImplicitParam(paramType = "query", name = "dateType", dataType = "Integer", value = "时间排序顺序类型(1:正序 2:反序)", required = false)
    })
    @GetMapping("/ManyParams")
    public CommonResponse getRequirementByManyParameters(@RequestParam(value = "pageNo", required = true) Integer pageNo,
                                                         @RequestParam(value = "pageSize", required = true) Integer pageSize,
                                                         @RequestParam(value = "searchText", required = false) String searchText,
                                                         @RequestParam(value = "typeId", required = false) Integer typeId,
                                                         @RequestParam(value = "city", required = false) String city,
                                                         @RequestParam(value = "street", required = false) String street,
                                                         @RequestParam(value = "firstDate", required = false) String firstDate,
                                                         @RequestParam(value = "secondDate", required = false) String secondDate,
                                                         @RequestParam(value = "dateType", required = false) Integer dateType) {
        try {
            pageNo = pageNo == null ? 1 : pageNo;
            pageSize = pageSize == null ? 10 : pageSize;

            PageHelper.startPage(pageNo, pageSize);

            //判断是否需要根据需求类型ID进行查询
            PageInfo pageInfo = new PageInfo(lyjRequirementService.getRequirementByManyParameters(searchText, typeId, city, street, firstDate, secondDate, dateType));
            return new CommonResponse(pageInfo, 200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }

    }

    @ApiOperation(value = "根据需求ID查询需求类型")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "requirementId", dataType = "Integer", value = "需求ID", required = true),
    })
    @GetMapping("/type/{requirementId}")
    public CommonResponse getTypesById(@PathVariable("requirementId") Integer requirementId) {
        try {
            List<LyjRequirementType> types = lyjRequirementService.getTypesById(requirementId);
            return new CommonResponse(types, 200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }
    }

    @ApiOperation(value = "根据需求ID查询详情")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "requirementId", dataType = "Integer", value = "需求ID", required = true)
    })
    @GetMapping("/{requirementId}")
    public CommonResponse getRequirementById(@PathVariable("requirementId") Integer requirementId) {
        try {
            LyjRequirement lyjRequirement = lyjRequirementService.getRequirementById(requirementId);
            return new CommonResponse(lyjRequirement, 200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }
    }


    @ApiOperation(value = "查询我创建的需求")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "uuid", dataType = "String", value = "用户唯一标识", required = true),
    })
    @GetMapping("/Mine/{uuid}")
    public CommonResponse getMyRequirement(@PathVariable("uuid") String uuid) {
        try {
            return new CommonResponse(lyjRequirementService.getMyRequirement(uuid), 200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }
    }

    @ApiOperation(value = "查询我中标的需求")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "requirementId", dataType = "Integer", value = "需求ID", required = true),
    })
    @GetMapping("/MineAplly/{uuid}")
    public CommonResponse getMyApplyRequirement(@PathVariable("uuid") String uuid) {
        try {
            return new CommonResponse(lyjRequirementService.getMyApplyRequirement(uuid), 200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }
    }

    @ApiOperation(value = "新增需求包括需求类型(单独)")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "typeId", dataType = "Integer", value = "该新增需求的类型ID", required = true),
            @ApiImplicitParam(paramType = "body", name = "requirement", dataType = "Requirement", value = "新增的需求信息", required = true)
    })
    @PostMapping("/{typeId}")
    public CommonResponse addRequirement(@PathVariable("typeId") Integer typeId, @RequestBody LyjRequirement lyjRequirement) {
        try {
            lyjRequirementService.saveRequirement(typeId, lyjRequirement);
            return new CommonResponse(200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }
    }

    @ApiOperation(value = "新增需求(包含多个需求类型(非必填))")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "requirement", dataType = "Requirement", value = "新增的需求信息", required = true)
    })
    @PostMapping()
    public CommonResponse addRequirementAdvanced(@RequestBody LyjRequirementVO lyjRequirementVO) {
        try {
            lyjRequirementService.saveRequirementAdvanced(lyjRequirementVO);
            return new CommonResponse(lyjRequirementVO, 200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
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
        try {
            lyjRequirementService.removeRequirement(requirementId);
            return new CommonResponse(200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
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


    @ApiOperation(value = "根据需求状态查询城市")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "status", dataType = "Integer", value = "需求的状态", required = false)
    })
    @GetMapping("/City")
    public CommonResponse getRequirementCityByStatus(@RequestParam(value = "status", required = false) Integer status) {
        try {
            List<Map> datas = new ArrayList<>();
            List<String> cities = lyjRequirementService.getRequirementCityByStatus(status);
            for (String single : cities) {
                Map nvdata = new HashMap();
                nvdata.put("label", single);
                nvdata.put("value", single);
                datas.add(nvdata);
            }
            //判断是否需要根据需求类型ID进行查询
            return new CommonResponse(datas, 200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }

    }

    @ApiOperation(value = "根据需求状态查询街道")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "status", dataType = "Integer", value = "需求的状态", required = false)
    })
    @GetMapping("/Street")
    public CommonResponse getRequirementStreetByStatus(@RequestParam(value = "status", required = false) Integer status) {
        try {
            List<Map> datas = new ArrayList<>();
            List<String> streets = lyjRequirementService.getRequirementStreetByStatus(status);
            for (String single : streets) {
                Map nvdata = new HashMap();
                nvdata.put("label", single);
                nvdata.put("value", single);
                datas.add(nvdata);
            }
            //判断是否需要根据需求类型ID进行查询
            return new CommonResponse(datas, 200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }

    }
}
