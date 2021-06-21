package com.rebuild.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rebuild.model.SysBoard;
import com.rebuild.model.SysTopic;
import com.rebuild.service.ISysBoardService;
import com.rebuild.service.ISysLabelService;
import com.rebuild.service.ISysModifyService;
import com.rebuild.service.ISysTopicService;

import com.rebuild.utils.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hjq
 * @since 2021-06-09
 */
@Api(tags = "子版块")
@RestController
@RequestMapping("/sys-board")
public class SysBoardController {

    @Resource
    private ISysBoardService sysBoardService;

    @Resource
    private ISysTopicService sysTopicService;

    @Resource
    private ISysModifyService sysModifyService;

    @Resource
    private ISysLabelService sysLabelService;

    @ApiOperation(value = "获取所有子板块信息")
    @PostMapping("/getAllBoard")
    @ResponseBody
    public HttpResult getAllLabel(){
        return HttpResult.successResponse(sysBoardService.list(new QueryWrapper<>(null)));
    }

    @ApiOperation(value = "获取所选子版块的所有话题信息")
    @PostMapping("/getThisAllTopic")
    @ApiImplicitParam(name = "bdId",value = "所选子板块id",paramType = "Integer")
    @ResponseBody
    public HttpResult getThisBoard(Integer bdId){
        return HttpResult.successResponse(sysTopicService.list(new QueryWrapper<SysTopic>()
                .eq("tp_bd_id",bdId)
        ));
    }

    @ApiOperation(value = "分页获取所选子版块的帖子信息")
    @PostMapping("/pageThisTopic")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "bdId",value = "所选子板块id",required = true,paramType = "Integer"),
        @ApiImplicitParam(name = "pageNo",value = "当前页数",required = true,paramType = "Integer"),
        @ApiImplicitParam(name = "pageSize",value = "每页长度",required = true,paramType = "Integer")
    })
    @ResponseBody
    public HttpResult pageThisTopic(Integer bdId,Integer pageNo,Integer pageSize){
        return HttpResult.successResponse(sysTopicService.page(new Page<>(pageNo,pageSize),new QueryWrapper<SysTopic>()
                .eq("tp_bd_id",bdId)
        ));
    }

    @ApiOperation(value = "新增子板块")
    @PostMapping("/newBoard")
    @ResponseBody
    @Transactional
    public HttpResult newBoard(@RequestBody SysBoard sysBoard) {
        sysBoard.setBdModifyId(sysModifyService.newModifition(sysBoard.getBdAdminId()).getMfId());
        sysBoardService.newBoard(sysBoard);
        sysModifyService.auto(sysBoard);
        sysLabelService.updateChilnum(sysBoard.getBdLbId());
        return HttpResult.successResponse(sysBoard);
    }
}
