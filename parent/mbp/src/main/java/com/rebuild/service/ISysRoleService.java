package com.rebuild.service;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rebuild.model.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjq
 * @since 2021-06-02
 */
public interface ISysRoleService extends IService<SysRole> {

    Page<SysRole> selectpage(Page<SysRole> page, Wrapper qw);

    IPage<SysRole> findPage(Page<SysRole> page);
}
