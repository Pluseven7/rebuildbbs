package com.rebuild.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.rebuild.model.SysContent;
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
@ApiModel(value="SysContentVo", description="")
public class SysContentVo extends SysContent {

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

    @ApiModelProperty(value = "所属话题id")
    private String tpId;

    @ApiModelProperty(value = "用户id")
    private Integer id;

}
