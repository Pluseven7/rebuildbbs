package com.rebuild.utils;


/**
 * API接口的错误码说明</b><br>
 *
 * @author hjq
 * @version 1.0
 */
public enum Code {

    /**
     * <pre>
     *     1.错误码暂定都是5位数字，并配有相应的中英文解释
     *     2.错误码为 0 表示成功，其他都表示错误
     *     3.错误码按模块按功能场景分级分段，前三位错误码表示模块，第四位表示模块下的功能。
     *     4.错误码按需分配，逐步增加，灵活扩展
     *
     *     模块：
     *        数字 01 表示登录模块
     *
     *
     *
     *     功能：
     *        数字 1 表示新增
     *        数字 2 表示修改
     *        数字 3 表示列表查询
     *        数字 4 表示查询详情
     *        数字 5 表示修改状态
     *        数字 6 表示删除
     *        数字 7 表示批量操作
     *        ......
     *
     *      统一格式：A-BB-CCC
     *          A:错误级别，如1代表系统级错误，4代表API参数校验失败，5代表后台业务校验失败；
     *          B:项目或模块名称，一般公司不会超过99个项目；
     *          C:具体错误编号，自增即可，一个项目999种错误应该够用；
     * </pre>
     */

    //系统级别错误码
    SUCCESS(0, "执行成功"),
    NOT_DATA(1001, "没有数据或记录"),
    ERROR(1002, "服务器异常，请稍后再试！"),
    FORBIDDEN(1003, "非法访问，请求被禁止"),
    AUTHENTICATION_PARAMS_FAIL(1004, "鉴权参数不能为空"),
    NAME_SPERCIAL_CHARACTERS(1005, "姓名不能包含非法字符"),
    NOT_LOGIN(1006, "未登录或者登录超时"),
    NOT_ACCESS_DENIED(1007, "没有操作权限"),
    REQUEST_TIMEOUT(1008, "请求超时"),
    IP_FALL(1009, "登陆ip与访问ip不相同,请重新登陆"),
    IP_AUTHORIZATION_FALL(1010, "IP鉴权失败"),
    SIGNATURE_ERROR(1011, "签名错误"),


    //业务层面错误
    USER_LOGIN_PARAMS_FAIL(50111, "用户名密码不能为空"),
    USER_LOGIN_ERROR(50112, "账号或密码错误"),
    USER_LOGIN_USED(50113, "用户已禁用，请联系管理员"),
    USER_LOGIN_ERROR_UPPER(50114, "密码错误次数过多，账号已被锁定"),
    USER_LOGIN_NAME_EXIST(50115, "账号已经注册"),
    USER_LOGIN_NO_ID(50117, "用户ID不能为空"),
    USER_LOGIN_NO_MOBLIE(50121, "用户手机号不能为空"),
    USER_LOGIN_ERROR_MOBILE(50122, "输入的手机号未注册用户或已禁用"),
    USER_LOGIN_NO_PWD(50118, "密码不能为空"),
    USER_LOGIN_PWD_WEAK(50119, "密码设置需含字母加数字"),
    USER_LOGIN_PWD_LENGTH(50120, "请输入8至32位长度密码"),
    USER_LOGIN_ISLOGIN(50121, "用户已经登录，请勿重复登录"),
    SYS_ADMIN_OPERATION(41013, "此操作仅限管理员"),
    USER_TELEPHONE_IS_DIFFERENT(41014, "手机号与登录账号不一致"),
    USER_ISCREATED(50211, "用户已存在,无法新增"),
    ;




    private int code;

    private String msg;

    Code(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
