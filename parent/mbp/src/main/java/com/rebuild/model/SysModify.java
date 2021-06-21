package com.rebuild.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@ApiModel(value="SysModify对象", description="")
public class SysModify extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "活动主键")
    private Integer mfId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime mfCreatetime;

    @ApiModelProperty(value = "创建人id")
    private Integer mfCreaterId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后活动时间")
    private LocalDateTime mfLastevent;

    @ApiModelProperty(value = "最后活动人id")
    private Integer mfLasteventId;

    @ApiModelProperty(value = "删除时间")
    private LocalDateTime mfDeletetime;

    @ApiModelProperty(value = "删除人id")
    private Integer mfDeleterId;

    @ApiModelProperty(value = "点击数")
    private Integer mfOptimes;

    @ApiModelProperty(value = "回复数")
    private Integer mfRtnum;

    @ApiModelProperty(value = "预留字段")
    private String remake;

}
