package com.rebuild.service;

import com.rebuild.model.SysBoard;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rebuild.model.SysLabel;
import org.apache.ibatis.annotations.Insert;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjq
 * @since 2021-06-09
 */
public interface ISysBoardService extends IService<SysBoard> {

    SysBoard newBoard(SysBoard sysBoard);

    void updateTopicnum(Integer id);
}
