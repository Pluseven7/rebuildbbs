package com.rebuild.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rebuild.model.SysBoard;
import com.rebuild.service.ISysBoardService;
import com.rebuild.service.ISysLabelService;
import com.rebuild.utils.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hjq
 * @since 2021-06-09
 */
@Api(tags = "主板块")
@RestController
@RequestMapping("/sys-label")
public class SysLabelController {
    @Resource
    private ISysLabelService sysLabelService;

    @Resource
    private ISysBoardService sysBoardService;

    @ApiOperation(value = "获取所有板块信息")
    @PostMapping("/getAllLabel")
    @ResponseBody
    public HttpResult getAllLabel(){
        return HttpResult.successResponse(sysLabelService.list(new QueryWrapper<>(null)));
    }



    @ApiOperation(value = "获取所选主板块的所有子板块信息")
    @PostMapping("/getThisAllBoard")
    @ApiImplicitParam(name = "lbId",value = "所选主板块id",paramType = "Integer")
    @ResponseBody
    public HttpResult getThisBoard(Integer lbId){
        return HttpResult.successResponse(sysBoardService.list(new QueryWrapper<SysBoard>()
                .eq("bd_lb_id",lbId)
        ));
    }
}
