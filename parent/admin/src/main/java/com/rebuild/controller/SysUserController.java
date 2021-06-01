package com.rebuild.controller;


import com.rebuild.model.SysUser;
import com.rebuild.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hjq
 * @since 2021-06-01
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController {
    @Autowired
    private ISysUserService userService;

    @GetMapping("/getUser")
    public SysUser getUser(){
        return userService.getById(1);
    }
}
