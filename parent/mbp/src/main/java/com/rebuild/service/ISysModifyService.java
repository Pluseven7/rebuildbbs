package com.rebuild.service;

import com.rebuild.model.SysBoard;
import com.rebuild.model.SysModify;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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

    void rtNumUp(Integer mfId);

    void optimesUp(Integer mfId);

    SysModify autoUpdate(Integer mfid, Integer leid);

    SysModify newContent(Integer id, String tpid);

    List<SysModify> auto(Object model);

}
