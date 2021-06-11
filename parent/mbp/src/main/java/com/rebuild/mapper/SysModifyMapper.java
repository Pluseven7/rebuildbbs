package com.rebuild.mapper;

import com.rebuild.model.SysModify;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hjq
 * @since 2021-06-09
 */
public interface SysModifyMapper extends BaseMapper<SysModify> {

//     @Insert("Insert INTO sys_modify (mf_id,mf_createtime,mf_createrId,mf_lastevent,mf_lasteventId,mf_deletetime,mf_deleterId,mf_optimes,mf_rtnum,remake)" +
//             "(#{mf_id,jdbcType=Integer},#{mf_createtime,jdbcType=TIMESTAMP},#{mf_createrId,jdbcType=INTEGER},#{mf_lastevent,jdbcType=TIMESTAMP},#{mf_lasteventId,jdbcType=INTEGER}," +
//             "#{mf_deletetime,jdbcType=TIMESTAMP},#{mf_deleterId,jdbcType=INTEGER},#{mf_optimes,jdbcType=INTEGER},#{mf_rtnum,jdbcType=INTEGER},#{remake,jdbcType=VARCHAR})"
//     )
//     @SelectKey(statement = {"SELECT LAST_INSERT_ID()"}, keyProperty = "mf_id", before = false, resultType = null)
     int insertAndID(SysModify sysModify);

     @Update("UPDATE sys_modify SET mf_optimes = 1+mf_optimes WHERE mf_id = #{mfId,jdbcType=INTEGER}")
     void optimesUp(Integer mfId);

     @Update("UPDATE sys_modify SET mf_rtnum = 1+mf_rtnum WHERE mf_id = #{mfId,jdbcType=INTEGER}")
     void rtNumUp(Integer mfId);
}
