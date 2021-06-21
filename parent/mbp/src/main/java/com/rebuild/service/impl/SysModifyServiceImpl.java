package com.rebuild.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rebuild.mapper.SysBoardMapper;
import com.rebuild.mapper.SysLabelMapper;
import com.rebuild.model.*;
import com.rebuild.mapper.SysModifyMapper;
import com.rebuild.service.ISysModifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.lang.reflect.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hjq
 * @since 2021-06-09
 */
@Service
public class SysModifyServiceImpl extends ServiceImpl<SysModifyMapper, SysModify> implements ISysModifyService {

    @Resource
    private SysModifyMapper sysModifyMapper;

    @Resource
    private SysBoardMapper sysBoardMapper;

    @Resource
    private SysLabelMapper sysLabelMapper;

    @Override
    public SysModify newModifition(Integer id) {
        SysModify sysModify = new SysModify();
        sysModify.setMfCreaterId(id);
        sysModify.setMfLasteventId(id);
        sysModify.setMfLastevent(getNow());
        sysModify.setMfCreatetime(getNow());
        sysModifyMapper.insertAndID(sysModify);
//        sysModify = baseMapper.selectOne(new QueryWrapper<>(sysModify));
        return sysModify;
    }

    //话题首楼
    @Override
    public SysModify newTopic(Integer id) {
        SysModify sysModify = newModifition(id);
        sysModify.setMfRtnum(1);
        sysModify.setMfOptimes(1);
        baseMapper.updateById(sysModify);
        return sysModify;
    }

    @Override
    public SysModify newContent(Integer id, String tpid) {
        Integer tpmfid = baseMapper.selectById(tpid).getMfId();
        autoUpdate(tpmfid, id);
        SysModify sysModify = newModifition(id);
        sysModify.setMfRtnum(0);
        sysModify.setMfOptimes(1);
        baseMapper.updateById(sysModify);
        return sysModify;
    }


    @Override
    public void rtNumUp(Integer mfId) {
        baseMapper.rtNumUp(mfId);
    }

    @Override
    public void optimesUp(Integer mfId) {
        baseMapper.optimesUp(mfId);
    }

    @Override
    public SysModify autoUpdate(Integer mfid, Integer leid) {
        SysModify sysModify = new SysModify();
        sysModify.setMfId(mfid);
        sysModify.setMfLasteventId(leid);
        sysModify.setMfLastevent(getNow());
        baseMapper.updateById(sysModify);
        return baseMapper.selectOne(new QueryWrapper<>(sysModify));
    }

    private LocalDateTime getNow() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        LocalDateTime ldt = LocalDateTime.parse(localTime, df);
        return ldt;
    }


}
