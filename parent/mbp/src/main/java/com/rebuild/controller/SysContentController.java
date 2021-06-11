package com.rebuild.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rebuild.model.SysBoard;
import com.rebuild.model.SysContent;
import com.rebuild.model.SysLabel;
import com.rebuild.model.SysTopic;
import com.rebuild.service.*;
import com.rebuild.utils.HttpResult;
import com.rebuild.vo.SysContentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Wrapper;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hjq
 * @since 2021-06-09
 */
@Api(tags = "内容")
@RestController
@RequestMapping("/sys-content")
public class SysContentController {

    @Resource
    private ISysContentService sysContentService;

    @Resource
    private ISysModifyService sysModifyService;

    private static Integer lbIdLength = 5;

    private static Integer bdIdLength = 5;

    private static Integer tpIdLength = 5;
    //lb_id+bd_id+tp_id+id+mf_id=ct_id
    @Transactional
    @ApiOperation(value = "新增回复",notes = "将lbid+bdid拼接后在ctId中返回")
    @PostMapping("/newContent")
    @ResponseBody
    public HttpResult newContent(@RequestBody SysContentVo sysContentVo){
        String lbId = sysContentVo.getCtId().substring(0,lbIdLength);
        String bdId = sysContentVo.getCtId().substring(lbIdLength,lbIdLength+bdIdLength);
        sysContentVo = sysContentService.newContent(sysContentVo,lbId,bdId);
        sysContentVo.setCtModifyId(sysModifyService.newTopic(sysContentVo.getCtOwnerId()).getMfId());
        return HttpResult.successResponse(sysContentVo);
    }
}
