package com.rebuild.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rebuild.model.SysModify;
import com.rebuild.service.ISysModifyService;
import com.rebuild.utils.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "活动")
@RestController
@RequestMapping("/sys-modify")
public class SysModifyController {

    @Resource
    private ISysModifyService sysModifyService;
/*
    @ApiOperation(value = "自动更新")
    @PostMapping("/autoUpdateModify")
    @ResponseBody
    public HttpResult autoUpdateModify(){

        return null;
    }*/
    @ApiOperation(value = "测试回复数")
    @PostMapping("/testReturn")
    @ApiImplicitParam(name = "mfId",value = "活动id",dataType = "Integer")
    @ResponseBody
    public HttpResult testRtNumUp(Integer mfId){
        sysModifyService.rtNumUp(mfId);
        return HttpResult.successResponse(sysModifyService.getOne(new QueryWrapper<SysModify>().eq("mf_id",mfId)));
    }

    @ApiOperation(value = "测试点击数")
    @PostMapping("/testCheck")
    @ApiImplicitParam(name = "mfId",value = "活动id",dataType = "Integer")
    @ResponseBody
    public HttpResult testoptimesUp(Integer mfId){
        sysModifyService.optimesUp(mfId);
        return HttpResult.successResponse(sysModifyService.getOne(new QueryWrapper<SysModify>().eq("mf_id",mfId)));
    }
}
