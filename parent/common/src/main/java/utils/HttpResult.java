package utils;

import lombok.Data;

/**
 *
 * 普通响应数据
 */

@Data
public class HttpResult {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 数据
     */
    private Object data;

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

    /**
     * 请求成功
     * @param code
     */
    public HttpResult(Integer code){this.code = code;}

    /**
     * 请求成功并返回数据
     * @param code
     * @param data
     */
    public HttpResult(Integer code, Object data){
        this.code = code;
        this.data = data;
    }

    /**
     * 请求成功并返回数据及分页信息
     */
    public HttpResult(Integer code, Object data,long pageSize, Integer total){
        this.code = code;
        this.data = data;
        this.pageSize = pageSize;
        this.total = total;
    }

    /**
     * 请求失败
     */
    public HttpResult(Integer code, Object data, String error){
        this.code = code;
        this.data = data;
        this.error = error;
    }
}
