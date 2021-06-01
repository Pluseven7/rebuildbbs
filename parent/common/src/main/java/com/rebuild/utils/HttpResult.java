package com.rebuild.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 普通响应数据
 */

@Data
public class HttpResult<D> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 数据
     */
    private D data;

    /**
     * 错误信息
     */
    private String error;

    /**
     * 返回总页数
     */
    private long pageSize;

    /**
     * 本页返回条数
     */
    private Integer total;


    public HttpResult(){this(Code.SUCCESS.getCode(), Code.SUCCESS.getMsg());}

    /**
     * 请求成功并返回数据
     * @param code
     * @param data
     */
    public HttpResult(Integer code, D data){
        this.code = code;
        this.data = data;
    }

    /**
     * 请求成功并返回数据及分页信息
     */
    public HttpResult(Integer code, D data,long pageSize, Integer total){
        this.code = code;
        this.data = data;
        this.pageSize = pageSize;
        this.total = total;
    }

    /**
     * 请求失败
     */
    public HttpResult(Integer code, String error){
        this.code = code;
        this.error = error;
    }

    /**
     * 请求失败并返回数据
     */
    public HttpResult(Integer code, String error, D data){
        this.code = code;
        this.data = data;
        this.error = error;
    }

    public static HttpResult successResponse(String message) {
        return new HttpResult(Code.SUCCESS.getCode(), message);
    }

    public static HttpResult successResponse() {
        return new HttpResult(Code.SUCCESS.getCode(), Code.SUCCESS.getMsg());
    }

    public static <D> HttpResult<D> successResponse(D singleData) {
        return new HttpResult(Code.SUCCESS.getCode(), Code.SUCCESS.getMsg(), singleData);
    }

    public static <D> HttpResult<D> successResponse(D singleData, long pageSize, Integer total) {
        return new HttpResult(Code.SUCCESS.getCode(), singleData, pageSize, total);
    }

    public static <D> HttpResult<D> successResponse(String message, D singleData) {
        return new HttpResult<>(Code.SUCCESS.getCode(), message, singleData);
    }

    public static HttpResult failResponse(int code, String message) {
        return new HttpResult(code, message);
    }

    public static HttpResult failResponse(String message) {
        return new HttpResult(Code.ERROR.getCode(), message);
    }

    public static HttpResult failResponse(Code code) {
        return new HttpResult(code.getCode(), code.getMsg());
    }

    /**
     *  异常输出
     * @param e 异常栈
     * @return HttpResult
     * @author hjq
     */
    public static HttpResult failResponse(Throwable e) {
        if (e instanceof SysException) {
            int code = Code.ERROR.getCode();
            String delimiter = SysException.resCodeSplitFlat;
            String errMessage = e.getMessage();
            if (e.getCause() instanceof SysException) {
                return failResponse(e.getCause());
            } else if (errMessage.contains(delimiter)) {
                String[] split = errMessage.split(delimiter);
                errMessage = split[1];
                code = Integer.valueOf(split[0]);
            }
            //把异常消息的小尾巴去掉(后面那一截英文)
            if (errMessage != null) {
                //切了之后长这样：此手机号码已经被注册\n
                errMessage = errMessage.split("com.rebuild.utils")[0].trim();
            }
            return new HttpResult(code, errMessage);
        } else if (e.getCause() instanceof SysException) {
            return failResponse(e.getCause());
        } else {
            //针对activiti报错
            String message = e.getMessage();
            Pattern pattern = Pattern.compile("\\d+~(.+)\\r\\n");
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()) {
                return new HttpResult(Code.ERROR.getCode(), matcher.group(1));
            }
        }
        return new HttpResult(Code.ERROR.getCode(), Code.ERROR.getMsg());
    }
}
