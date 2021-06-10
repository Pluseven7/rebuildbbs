package com.rebuild.service;

import com.rebuild.model.SysModify;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjq
 * @since 2021-06-09
 */
public interface ISysModifyService extends IService<SysModify> {
    SysModify newModifition(Integer id);

    SysModify newTopic(Integer id);
}
