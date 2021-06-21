package com.rebuild.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rebuild.mapper.SysBoardMapper;
import com.rebuild.mapper.SysLabelMapper;
import com.rebuild.mapper.SysTopicMapper;
import com.rebuild.model.*;
import com.rebuild.mapper.SysModifyMapper;
import com.rebuild.service.ISysModifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hjq
 * @since 2021-06-09
 */
@Service
public class SysModifyServiceImpl<T> extends ServiceImpl<SysModifyMapper, SysModify> implements ISysModifyService {
    protected T model;

    @Resource
    private SysModifyMapper sysModifyMapper;

    @Resource
    private SysBoardMapper sysBoardMapper;

    @Resource
    private SysLabelMapper sysLabelMapper;
    @Resource
    private SysTopicMapper sysTopicMapper;

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
        Integer tpmfid = sysTopicMapper.selectById(tpid).getTpModifyId();
        autoUpdate(tpmfid, id);
        rtNumUp(tpmfid);
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

    public List<SysModify> auto(Object model) {
        this.model = (T) model;
        SysModify sysModify;
        List ls = new ArrayList();
//            this.getId(model);
        if (model instanceof SysLabel){
            sysModify = autoUpdate(((SysLabel) model).getLbModifyId(),((SysLabel) model).getLbAdminId());
            ls.add(sysModify);
            return ls;
        }
        if (model instanceof SysBoard){
            Integer mfId = sysLabelMapper.selectById(((SysBoard) model).getBdLbId()).getLbModifyId();
            Integer leId = ((SysBoard) model).getBdAdminId();
            sysModify = autoUpdate(mfId, leId);
            baseMapper.updateById(sysModify);
            ls.add(sysModify);

            sysModify = baseMapper.selectById(((SysBoard) model).getBdModifyId());
            autoUpdate(sysModify.getMfId(),leId);
            baseMapper.updateById(sysModify);
            ls.add(sysModify);

            return ls;
        }
        if (model instanceof SysTopic){
            Integer leId = ((SysTopic) model).getTpManagerId();

            SysLabel sysLabel = sysLabelMapper.selectById(((SysTopic) model).getTpBdId());
            sysModify = autoUpdate(sysLabel.getLbModifyId(), leId);
            ls.add(sysModify);
            baseMapper.updateById(sysModify);

            sysModify = baseMapper.selectById(sysBoardMapper.selectById(((SysTopic) model).getTpBdId()).getBdModifyId());
            sysModify = autoUpdate(sysModify.getMfId(),leId);
            autoUpdate(sysModify.getMfId(),leId);
            ls.add(sysModify);
            baseMapper.updateById(sysModify);

            sysModify = baseMapper.selectById(((SysTopic) model).getTpModifyId());
            sysModify = autoUpdate(sysModify.getMfId(),leId);
            ls.add(sysModify);
            baseMapper.updateById(sysModify);

            return ls;
        }
        return null;
    }
}
