package com.rebuild.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rebuild.model.SysBoard;
import com.rebuild.model.SysContent;
import com.rebuild.model.SysLabel;
import com.rebuild.model.SysTopic;
import com.rebuild.service.*;
import com.rebuild.utils.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
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
    private ISysTopicService iSysTopicService;
    @Resource
    private ISysBoardService iSysBoardService;
    @Resource
    private ISysLabelService iSysLabelService;
    @Resource
    private ISysModifyService iSysModifyService;
    @Resource
    private ISysContentService iSysContentService;


    //lb_id+bd_id+tp_id+id+mf_id=ct_id
    @ApiOperation(value = "新增内容")
    @PostMapping("/newOne")
    @ApiImplicitParam(name = "sys_content", value = "内容", paramType = "body")
    @ResponseBody
    public HttpResult newOne(@RequestBody Integer tpId, Integer id, SysContent sysContent){
        Integer tpbdId = iSysTopicService.getOne(new QueryWrapper<SysTopic>().eq("tp_id",tpId)).getTpBdId();
        Integer bdlbId = iSysBoardService.getOne(new QueryWrapper<SysBoard>().eq("bd_id",tpbdId)).getBdLbId();
        Integer lbId = iSysLabelService.getOne(new QueryWrapper<SysLabel>().eq("lb_id",bdlbId)).getLbId();
        Integer mfId = iSysModifyService.newModifition(id).getMfId();
        sysContent.setCtId(Integer.toString(lbId+bdlbId+tpbdId+id+mfId));
        iSysContentService.save(sysContent);
        return HttpResult.successResponse(sysContent);
    }
}
