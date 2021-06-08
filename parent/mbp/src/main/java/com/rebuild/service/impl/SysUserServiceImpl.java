package com.rebuild.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rebuild.model.SysUser;
import com.rebuild.mapper.SysUserMapper;
import com.rebuild.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rebuild.utils.Code;
import com.rebuild.utils.SysException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hjq
 * @since 2021-06-03
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findByUserName(String username) {
        SysUser user = sysUserMapper.selectOne(
                new QueryWrapper<SysUser>()
                        .eq("username",username)
        );
        return user;
    }

    @Override
    public boolean check(String username, String password) {
        SysUser user = sysUserMapper.selectOne(
                new QueryWrapper<SysUser>()
                        .eq("username",username)
                        .eq("password",password)
        );
        if(user==null){
            throw new SysException(Code.USER_LOGIN_ERROR);
        }
        return true;
    }
}
