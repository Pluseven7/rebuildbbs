package com.rebuild.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author hjq
 * @since 2021-06-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysLabel对象", description="")
public class SysLabel extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "lb_id", type = IdType.AUTO)
    private Integer lbId;

    @ApiModelProperty(value = "板块名称")
    private String lbName;

    @ApiModelProperty(value = "子版块数量")
    private Integer lbChilnum;

    @ApiModelProperty(value = "管理员id")
    private Integer lbAdminId;

    @ApiModelProperty(value = "权限标识")
    private Integer lbPermission;

    @ApiModelProperty(value = "活动id")
    private Integer lbModifyId;


}
