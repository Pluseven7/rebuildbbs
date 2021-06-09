package com.rebuild.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rebuild.model.SysLabel;
import com.rebuild.service.ISysLabelService;
import com.rebuild.service.impl.SysLabelServiceImpl;
import com.rebuild.utils.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
@Api(tags = "板块")
@RestController
@RequestMapping("/sys-label")
public class SysLabelController {

    @Resource
    private ISysLabelService service;

    @ApiOperation(value = "获取所有板块信息")
    @PostMapping("/getAllLabel")
    @ResponseBody
    public HttpResult getAllLabel(){
        return HttpResult.successResponse(service.list(new QueryWrapper<>(null)));
    }

}
