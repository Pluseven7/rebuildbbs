package com.rebuild.model;

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


@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysModify对象", description="")
public class SysModify extends Model {

    private static final long serialVersionUID = 1L;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getMfId() {
        return mfId;
    }

    public void setMfId(Integer mfId) {
        this.mfId = mfId;
    }

    public LocalDateTime getMfCreatetime() {
        return mfCreatetime;
    }

    public void setMfCreatetime(LocalDateTime mfCreatetime) {
        this.mfCreatetime = mfCreatetime;
    }

    public Integer getMfCreaterId() {
        return mfCreaterId;
    }

    public void setMfCreaterId(Integer mfCreaterId) {
        this.mfCreaterId = mfCreaterId;
    }

    public LocalDateTime getMfLastevent() {
        return mfLastevent;
    }

    public void setMfLastevent(LocalDateTime mfLastevent) {
        this.mfLastevent = mfLastevent;
    }

    public Integer getMfLasteventId() {
        return mfLasteventId;
    }

    public void setMfLasteventId(Integer mfLasteventId) {
        this.mfLasteventId = mfLasteventId;
    }

    public LocalDateTime getMfDeletetime() {
        return mfDeletetime;
    }

    public void setMfDeletetime(LocalDateTime mfDeletetime) {
        this.mfDeletetime = mfDeletetime;
    }

    public Integer getMfDeleterId() {
        return mfDeleterId;
    }

    public void setMfDeleterId(Integer mfDeleterId) {
        this.mfDeleterId = mfDeleterId;
    }

    public Integer getMfOptimes() {
        return mfOptimes;
    }

    public void setMfOptimes(Integer mfOptimes) {
        this.mfOptimes = mfOptimes;
    }

    public Integer getMfRtnum() {
        return mfRtnum;
    }

    public void setMfRtnum(Integer mfRtnum) {
        this.mfRtnum = mfRtnum;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }
}
