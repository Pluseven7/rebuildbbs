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

    @ApiModelProperty(value = "内容主键id,新增帖子时该值传“”,在内容入库后自动生成")
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

    @ApiModelProperty(value = "内容活动id,新增帖子时该值传0,在内容入库后自动生成")
    private Integer ctModifyId;

    @ApiModelProperty(value = "预留字段")
    private String remake;

    @ApiModelProperty(value = "临时数据字段：所属帖子id,,新增帖子时该值传0,自动生成")
    private String ctTpId;
//
//    @ApiModelProperty(value = "所属子版块id")
//    private Integer bdId;
//
//    @ApiModelProperty(value = "所属主板块id")
//    private Integer lbId;

}
