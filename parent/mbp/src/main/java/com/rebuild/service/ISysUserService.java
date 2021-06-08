package com.rebuild.service;


import com.rebuild.model.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjq
 * @since 2021-06-03
 */
public interface ISysUserService extends IService<SysUser> {
    SysUser findByUserName(String username);

    boolean check(String username,String password);
}
