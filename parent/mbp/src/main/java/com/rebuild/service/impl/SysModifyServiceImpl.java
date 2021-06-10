package com.rebuild.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rebuild.model.SysModify;
import com.rebuild.mapper.SysModifyMapper;
import com.rebuild.service.ISysModifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    @Override
    public SysModify newModifition(Integer id) {
        SysModify sysModify = new SysModify() ;
        sysModify.setMfCreaterId(id);
        sysModify.setMfLasteventId(id);
        sysModify.setMfLastevent(getNow());
        sysModify.setMfCreatetime(getNow());
        sysModifyMapper.insertAndID(sysModify);
        sysModify = baseMapper.selectOne(new QueryWrapper<>(sysModify));
        return sysModify;
    }

    @Override
    public SysModify newTopic(Integer id) {
        SysModify sysModify = newModifition(id);
        sysModify.setMfRtnum(1);
        sysModify.setMfOptimes(1);
        return sysModify;
    }


    private LocalDateTime getNow(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        LocalDateTime ldt = LocalDateTime.parse(localTime,df);
        return ldt;
    }


}
