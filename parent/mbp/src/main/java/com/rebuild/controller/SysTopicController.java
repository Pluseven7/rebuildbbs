package com.rebuild.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rebuild.model.*;
import com.rebuild.qo.SysTopicQo;
import com.rebuild.service.ISysContentService;
import com.rebuild.service.ISysModifyService;
import com.rebuild.service.ISysTopicService;
import com.rebuild.utils.HttpResult;
import com.rebuild.vo.SysTopicVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
        Integer tpmId = sysTopicVo.getTpManagerId();
        //生成活动
        SysModify sysModify = sysModifyService.newTopic(tpmId);
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
        List ls = new ArrayList();
        ls.add(sysTopic);
        ls.add(sysTopicVo.getSysContentVo());
        //更新活动
        ls.add(sysModifyService.auto(sysTopic));
        return HttpResult.successResponse(ls);
    }

    @ApiOperation(value = "打开帖子，分页显示")
    @PostMapping("/pageOpenThis")
    @ResponseBody
    public HttpResult pageOpenThis(@RequestBody SysTopicQo sysTopicQo){

        IPage<SysTopic> page = sysTopicService.page(new Page<>(sysTopicQo.getPage().getCurrent(),sysTopicQo.getPage().getSize()),new QueryWrapper<SysTopic>()
                .eq("tp_id",sysTopicQo.getTpId()));
        return HttpResult.successResponse(page);
    }

}
