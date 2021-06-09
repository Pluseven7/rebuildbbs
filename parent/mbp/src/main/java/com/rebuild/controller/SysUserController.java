package com.rebuild.controller;


import com.rebuild.model.SysUser;
import com.rebuild.service.ISysUserService;
import com.rebuild.utils.Code;
import com.rebuild.utils.HttpResult;
import com.rebuild.utils.SysException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hjq
 * @since 2021-06-03
 */
@Api(tags = "用户")
@RestController
@RequestMapping("/sys-user")
public class SysUserController {
    @Resource
    private ISysUserService userService;

    @ApiOperation(value = "测试")
    @GetMapping("/getUser")
    public SysUser getUser(){
        return userService.getById(1);
    }

//    /**
//     * 登录请求转发
//     *
//     * @return
//     */
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public void login(HttpServletResponse response) throws IOException {
//        response.sendRedirect("/user/loginin");
//    }

    /**
     * 用户登录
     * @return
     */
    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uname",value = "用户名",paramType = "String"),
            @ApiImplicitParam(name = "pwd",value = "密码",paramType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/loginin",method = RequestMethod.POST)
    public HttpResult login(String uname,String pwd) {
        SysUser user = new SysUser().setUsername(uname).setPassword(pwd);
        if (StringUtils.isEmpty(user.getUsername())||StringUtils.isEmpty(user.getPassword())){
            return HttpResult.failResponse(Code.USER_LOGIN_PARAMS_FAIL.getCode(),Code.USER_LOGIN_PARAMS_FAIL.getMsg());
        }
        try {
            userService.check(user.getUsername(),user.getPassword());
            return HttpResult.successResponse(Code.SUCCESS.getCode(), "登录成功", "id:"+userService.findByUserName(user.getUsername()).getId());
        }catch (SysException e) {
            return HttpResult.failResponse(Code.USER_LOGIN_ERROR.getCode(),Code.USER_LOGIN_ERROR.getMsg());
        }
    }


}
