package com.feng.oldfriend.controller;

import com.feng.oldfriend.config.CommonResponse;
import com.feng.oldfriend.entity.LyjBlacklist;
import com.feng.oldfriend.entity.LyjUser;
import com.feng.oldfriend.service.LyjBlacklistService;
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
 * @date ：Created in 2019/10/15 10:23
 * @description：黑名单api接口
 */
@RestController
@RequestMapping("/Blacklist")
@Api(value = "Blacklist", description = "黑名单")
public class LyjBlacklistController {

    @Autowired
    private LyjBlacklistService lyjBlacklistService;

    @ApiOperation(value = "根据可选参数用户名称查询的用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "pageNo", dataType = "Integer", value = "页码", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Integer", value = "每页数量", defaultValue = "10"),
            @ApiImplicitParam(paramType = "query", name = "searchText", dataType = "String", value = "用户名称", required = false),
    })
    @GetMapping()
    public CommonResponse getUserBySearch(@RequestParam(value = "pageNo", required = false) Integer pageNo,
                                          @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                          @RequestParam(value = "searchText", required = false) String searchText) {
        try {
            pageNo = pageNo == null ? 1 : pageNo;
            pageSize = pageSize == null ? 10 : pageSize;

            PageHelper.startPage(pageNo, pageSize);

            //判断是否需要根据需求类型ID进行查询
            PageInfo pageInfo = new PageInfo(lyjBlacklistService.getDatas(searchText));

            return new CommonResponse(pageInfo, 200);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看", 500);
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/10/15 11:23
     * description: 将用户加入黑名单
     */
    @ApiOperation(value = "将用户加入黑名单")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "uuid", dataType = "String", value = "用户的UUID", required = true)
    })
    @PostMapping()
    public CommonResponse addBlack(@RequestBody LyjBlacklist lyjBlacklist){
        try{
            lyjBlacklistService.saveBlack(lyjBlacklist);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }

    /**
     * create by: yangchenxiao
     * create time: 2019/10/15 11:23
     * description: 将用户移出黑名单
     */
    @ApiOperation(value = "将用户移出黑名单")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "body", name = "uuid", dataType = "String", value = "用户的UUID")
    })
    @DeleteMapping("/{uuid}")
    public CommonResponse removefromBlack(@PathVariable("uuid") String uuid){
        try{
            lyjBlacklistService.removeBlack(uuid);
            return new CommonResponse(200);
        }catch (Exception e){
            e.printStackTrace();
            return new CommonResponse("后台程序出错，请联系管理员查看",500);
        }
    }


}
