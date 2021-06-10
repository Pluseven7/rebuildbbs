package com.rebuild.mapper;

import com.rebuild.model.SysLabel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rebuild.model.SysModify;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hjq
 * @since 2021-06-09
 */
public interface SysLabelMapper extends BaseMapper<SysLabel> {

    int insertAndID(SysModify sysModify);
}
