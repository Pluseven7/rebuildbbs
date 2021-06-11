package com.rebuild.service.impl;

import com.rebuild.model.SysContent;
import com.rebuild.mapper.SysContentMapper;
import com.rebuild.service.ISysContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rebuild.vo.SysContentVo;
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
public class SysContentServiceImpl extends ServiceImpl<SysContentMapper, SysContent> implements ISysContentService {

    @Override
    public SysContentVo newContent(SysContentVo sysContentVo,String lbId,String bdId){
        String ctId = lbId + bdId
                +sysContentVo.getCtTpId()
                +sysContentVo.getCtOwnerId().toString()
                +sysContentVo.getCtModifyId().toString();
        sysContentVo.setCtId(ctId);
        baseMapper.insert(sysContentVo);
        return sysContentVo;
    }


}
