package com.rebuild.controller;


import com.rebuild.model.SysUser;
import com.rebuild.service.ISysUserService;
import com.rebuild.utils.Code;
import com.rebuild.utils.HttpResult;
import com.rebuild.utils.SysException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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
     * @param response
     * @param user
     * @return
     */
    @ApiOperation(value = "用户登录")
    @ResponseBody
    @RequestMapping(value = "/loginin",method = RequestMethod.GET)
    public HttpResult login(HttpServletResponse response,
                            SysUser user) {
        if (StringUtils.isEmpty(user.getUsername())||StringUtils.isEmpty(user.getPassword())){
            return HttpResult.failResponse(Code.USER_LOGIN_PARAMS_FAIL.getCode(),Code.USER_LOGIN_PARAMS_FAIL.getMsg());
        }
        try {
            userService.check(user.getUsername(),user.getPassword());
            response.sendRedirect("/initPage");
            return HttpResult.successResponse(userService.findByUserName(user.getUsername()));
        }catch (SysException e) {
            return HttpResult.failResponse(Code.USER_LOGIN_ERROR.getCode(),Code.USER_LOGIN_ERROR.getMsg());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
