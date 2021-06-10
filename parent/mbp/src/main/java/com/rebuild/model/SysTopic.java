package com.rebuild.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.annotations.SelectKey;

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
@ApiModel(value="SysTopic对象", description="")
public class SysTopic extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "帖子主键")
    private String tpId;

    @ApiModelProperty(value = "帖子名称")
    private String tpName;

    @ApiModelProperty(value = "楼主id")
    private Integer tpManagerId;

    @ApiModelProperty(value = "帖子所属子版块id")
    private Integer tpBdId;

    @ApiModelProperty(value = "帖子活动id")
    private Integer tpModifyId;

    @ApiModelProperty(value = "删除标识")
    private Integer tpDelete;

    @ApiModelProperty(value = "预留字段")
    private String remake;


}
