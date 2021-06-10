package com.rebuild.service;

import com.rebuild.model.SysContent;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rebuild.vo.SysContentVo;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjq
 * @since 2021-06-09
 */
public interface ISysContentService extends IService<SysContent> {

    SysContentVo newContent(SysContentVo sysContentVo, Integer lbId, Integer bdId);
}
