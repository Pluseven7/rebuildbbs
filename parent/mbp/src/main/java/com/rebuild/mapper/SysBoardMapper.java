package com.rebuild.mapper;

import com.rebuild.model.SysBoard;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rebuild.model.SysLabel;
import org.apache.ibatis.annotations.Insert;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hjq
 * @since 2021-06-09
 */
public interface SysBoardMapper extends BaseMapper<SysBoard> {

    @Insert("Insert INTO sys_board (bd_id,bd_name,bd_lb_id,bd_admin_id,bd_topicnum,bd_modify_id,bd_premission)" +
            "VALUES (#{bdId,jdbcType=INTEGER},#{bdName,jdbcType=VARCHAR},#{bdLbId,jdbcType=INTEGER}," +
            "#{bdAdminId,jdbcType=INTEGER},#{bdTopicnum,jdbcType=INTEGER},#{bdModifyId,jdbcType=INTEGER}),#{bdPremission,jdbcType=INTEGER}"
    )
    int insertAndID(SysBoard sysBoard);
}
