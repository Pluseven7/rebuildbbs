package com.rebuild.mapper;

import com.rebuild.model.SysLabel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rebuild.model.SysModify;
import org.apache.ibatis.annotations.Insert;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hjq
 * @since 2021-06-09
 */
public interface SysLabelMapper extends BaseMapper<SysLabel> {

    @Insert("Insert INTO sys_Label (lb_id,lb_name,lb_chilnum,lb_admin_id,lb_permission,lb_modify_id)" +
             "VALUES (#{lbId,jdbcType=INTEGER},#{lbName,jdbcType=VARCHAR},#{lbChilnum,jdbcType=INTEGER}," +
            "#{lbAdminId,jdbcType=INTEGER},#{lbPermission,jdbcType=INTEGER},#{lbModifyId,jdbcType=INTEGER})"
     )
    int insertAndID(SysLabel sysLabel);
}
