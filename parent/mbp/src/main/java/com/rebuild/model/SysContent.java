package com.rebuild.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
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
@ApiModel(value="SysContent对象", description="")
public class SysContent extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "内容主键id")
    private String ctId;

    @ApiModelProperty(value = "内容文本")
    private String ctText;

    @ApiModelProperty(value = "内容图片url")
    private String ctPic;

    @ApiModelProperty(value = "内容其他附件url")
    private String ctAnnex;

    @ApiModelProperty(value = "内容发布者id")
    private Integer ctOwnerId;

    @ApiModelProperty(value = "删除标识")
    private Integer ctDelete;

    @ApiModelProperty(value = "内容活动id")
    private Integer ctModifyId;

    @ApiModelProperty(value = "预留字段")
    private String remake;


}
