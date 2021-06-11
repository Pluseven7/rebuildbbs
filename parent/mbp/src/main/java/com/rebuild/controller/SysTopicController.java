package com.rebuild.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.rebuild.model.*;
import com.rebuild.service.ISysContentService;
import com.rebuild.service.ISysModifyService;
import com.rebuild.service.ISysTopicService;
import com.rebuild.utils.HttpResult;
import com.rebuild.vo.SysContentVo;
import com.rebuild.vo.SysTopicVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hjq
 * @since 2021-06-09
 */
@Api(tags = "帖子")
@RestController
@RequestMapping("/sys-topic")
public class SysTopicController {

    @Resource
    private ISysModifyService sysModifyService;

    @Resource
    private ISysTopicService sysTopicService;

    @Resource
    private ISysContentService sysContentService;



    //lb_id+bd_id+id+mf_id+ct_id=tp_id
    @ApiOperation(value = "新增帖子")
    @PostMapping("/createTopic")
    @Transactional
    @ResponseBody
    public HttpResult createTopic(@RequestBody SysTopicVo sysTopicVo) {
        //生成活动
        SysModify sysModify = sysModifyService.newTopic(sysTopicVo.getTpManagerId());
        sysTopicVo.setTpModifyId(sysModify.getMfId());
        //生成帖子串号
        String tpId = sysTopicVo.getLbId().toString()
                +sysTopicVo.getTpBdId().toString()
                +sysTopicVo.getTpManagerId().toString()
                +sysTopicVo.getTpModifyId().toString();
//                +sysTopicVo.getSysContentVo().getCtId();
        sysTopicVo.setTpId(tpId);
        sysTopicVo.getSysContentVo().setCtTpId(tpId);
        //生成首楼回复
        sysTopicVo.setSysContentVo(sysContentService.newContent(sysTopicVo.getSysContentVo(),
                sysTopicVo.getLbId().toString(),sysTopicVo.getTpBdId().toString()));
        //将tpId转换为串号+首楼帖串号的数据字段
        tpId += sysTopicVo.getSysContentVo().getCtId();
        sysTopicVo.setTpId(tpId);
        sysTopicService.save(sysTopicVo);
        SysTopic sysTopic = new SysTopic();
        BeanUtils.copyProperties(sysTopicVo,sysTopic);
        sysTopic = sysTopicService.getOne(new QueryWrapper<>(sysTopic));
        return HttpResult.successResponse(sysTopic);
    }

    @ApiOperation(value = "打开帖子，分页回复")
    @PostMapping("/pageOpenThis")
    @ApiImplicitParam(name = "tpId",value = "所选帖子id",paramType = "Integer")
    @ResponseBody
    public HttpResult pageOpenThis(Integer tpId){
        sysTopicService.getById(tpId);
        return null;
    }

}