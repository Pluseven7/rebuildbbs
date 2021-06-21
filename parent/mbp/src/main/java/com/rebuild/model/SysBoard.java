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
@ApiModel(value="SysBoard对象", description="")
public class SysBoard extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "子版块id")
    @TableId(value = "bd_id", type = IdType.AUTO)
    private Integer bdId;

    @ApiModelProperty(value = "所属主板块id")
    private Integer bdLbId;

    @ApiModelProperty(value = "子版块名称")
    private String bdName;

    @ApiModelProperty(value = "版主id")
    private Integer bdAdminId;

    @ApiModelProperty(value = "讨论数")
    private Integer bdTopicnum;

    @ApiModelProperty(value = "子版块活动id")
    private Integer bdModifyId;

    @ApiModelProperty(value = "权限标识")
    private Integer bdPremission;

    @ApiModelProperty(value = "预留字段")
    private String remakes;


}
