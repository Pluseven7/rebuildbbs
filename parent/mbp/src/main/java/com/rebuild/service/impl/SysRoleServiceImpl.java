package com.rebuild.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rebuild.model.SysRole;
import com.rebuild.mapper.SysRoleMapper;
import com.rebuild.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hjq
 * @since 2021-06-02
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    @Resource
    SysRoleMapper sysRoleMapper;

//    @Override
//    public Page<SysRole> selectpage(Page<SysRole> page, Wrapper qw) {
//        return sysRoleMapper.selectPage(page,qw);
//    }

    @Override
    public Page<SysRole> selectpage(Page<SysRole> page, Wrapper qw) {
        return null;
    }

    @Override
    public IPage<SysRole> findPage(Page<SysRole> page) {
        return sysRoleMapper.getPage(page);
    }


}
