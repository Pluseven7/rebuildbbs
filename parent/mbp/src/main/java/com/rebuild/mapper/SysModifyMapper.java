package com.rebuild.mapper;

import com.rebuild.model.SysModify;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hjq
 * @since 2021-06-09
 */
public interface SysModifyMapper extends BaseMapper<SysModify> {

     int insertAndID(SysModify sysModify);
}
