package com.rebuild.service.impl;

import com.rebuild.model.SysLabel;
import com.rebuild.mapper.SysLabelMapper;
import com.rebuild.service.ISysLabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hjq
 * @since 2021-06-09
 */
@Service
public class SysLabelServiceImpl extends ServiceImpl<SysLabelMapper, SysLabel> implements ISysLabelService {

    @Override
    public SysLabel newLabel(SysLabel sysLabel) {
        baseMapper.insertAndID(sysLabel);
        return sysLabel;
    }

    @Override
    public void updateChilnum(Integer id){
        SysLabel sysLabel = baseMapper.selectById(id);
        sysLabel.setLbChilnum(sysLabel.getLbChilnum() +1);
        baseMapper.updateById(sysLabel);
    }
}
