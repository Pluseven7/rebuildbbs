package com.rebuild.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rebuild.model.SysBoard;
import com.rebuild.model.SysLabel;
import com.rebuild.service.ISysBoardService;
import com.rebuild.service.ISysLabelService;
import com.rebuild.service.ISysModifyService;
import com.rebuild.utils.Code;
import com.rebuild.utils.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private ISysModifyService sysModifyService;



    @ApiOperation(value = "获取所有板块信息")
    @PostMapping("/getAllLabel")
    @ResponseBody
    public HttpResult getAllLabel() {
        return HttpResult.successResponse(sysLabelService.list(new QueryWrapper<>(null)));
    }


    @ApiOperation(value = "获取所选主板块的所有子板块信息")
    @PostMapping("/getThisAllBoard")
    @ApiImplicitParam(name = "lbId", value = "所选主板块id", paramType = "Integer")
    @ResponseBody
    public HttpResult getThisBoard(Integer lbId) {
        return HttpResult.successResponse(sysBoardService.list(new QueryWrapper<SysBoard>()
                .eq("bd_lb_id", lbId)
        ));
    }

    @ApiOperation(value = "新增主板块")
    @PostMapping("/newLabel")
    @ResponseBody
    @Transactional
    public HttpResult newLabel(@RequestBody SysLabel sysLabel) {
        sysLabel.setLbModifyId(sysModifyService.newModifition(sysLabel.getLbAdminId()).getMfId());
        sysLabelService.newLabel(sysLabel);
        return HttpResult.successResponse(sysLabel);
    }

    @ApiOperation(value = "修改主板块")
    @PostMapping("/changeLabel")
    @ResponseBody
    @Transactional
    public HttpResult changeLabel(@RequestBody SysLabel sysLabel) {
        boolean result = sysLabelService.updateById(sysLabel);
        List ls = sysModifyService.auto(sysLabel);
        if (result&& ls!= null) {
            return HttpResult.successResponse(sysLabel);
        } else {
            return HttpResult.failResponse(Code.ERROR);
        }
    }
}
