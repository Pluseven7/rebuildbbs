package com.rebuild.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.rebuild.model.SysTopic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "帖子Vo")
@Data
public class SysTopicVo extends SysTopic {

    @ApiModelProperty(value = "板块id")
    private Integer lbId;

    @ApiModelProperty(value = "内容主键id,新增帖子时该值传“”,在内容入库后自动生成")
    private String ctId;

    @ApiModelProperty(value = "帖子主键,新增帖子时该值传“”,在内容入库后自动生成")
    private String tpId;

    @ApiModelProperty(value = "帖子名称")
    private String tpName;

    @ApiModelProperty(value = "楼主id")
    private Integer tpManagerId;

    @ApiModelProperty(value = "帖子所属子版块id")
    private Integer tpBdId;

    @ApiModelProperty(value = "帖子活动id,新增帖子时该值不需要传,自动生成")
    private Integer tpModifyId;

    @ApiModelProperty(value = "删除标识,默认传0，未删除")
    private Integer tpDelete;

    private SysContentVo sysContentVo;
}
