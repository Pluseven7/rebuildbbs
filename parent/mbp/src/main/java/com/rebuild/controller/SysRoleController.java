package com.rebuild.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rebuild.model.SysRole;
import com.rebuild.service.ISysRoleService;
import com.rebuild.utils.Code;
import com.rebuild.utils.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hjq
 * @since 2021-06-02
 */
@Api(tags = "权限")
@RestController
@RequestMapping("/sys-role")
public class SysRoleController {

    @Resource
    private ISysRoleService service;

    @ApiOperation(value = "测试")
    @GetMapping("/test")
    @ResponseBody
    public List<SysRole> getOne(){
        List ls = new ArrayList<SysRole>();
        ls.add(service.getOne(
                new QueryWrapper<SysRole>()
                        .eq("id",1)));
        return ls;
    }

    @ApiOperation(value = "获取权限列表")
    @ApiImplicitParams ({
        @ApiImplicitParam(name = "pageno",paramType = "Integer",required = true),
        @ApiImplicitParam(name = "pagesize",paramType = "Integer",required = true)
    })
    @PostMapping("/QueryUserRole")
    @ResponseBody
    public HttpResult<IPage> getAll(Integer pageno,Integer pagesize){
        IPage result = service.page(new Page(pageno,pagesize),new QueryWrapper<SysRole>()
        .isNotNull("id")
        .orderBy(false,false,"id")
        );
        return HttpResult.successResponse(Code.SUCCESS.getCode(),result);
    }
}
