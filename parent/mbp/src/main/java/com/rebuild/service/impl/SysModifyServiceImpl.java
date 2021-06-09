package com.rebuild.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rebuild.model.SysModify;
import com.rebuild.mapper.SysModifyMapper;
import com.rebuild.service.ISysModifyService;
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
public class SysModifyServiceImpl extends ServiceImpl<SysModifyMapper, SysModify> implements ISysModifyService {

    public SysModify newModifition(Integer id) {
        SysModify sysModify = new SysModify() ;
        sysModify.setMfId(id);
        baseMapper.insert(sysModify);
        sysModify = baseMapper.selectOne(new QueryWrapper<SysModify>().select("max(mf_id)"));
        return sysModify;
    }
}
