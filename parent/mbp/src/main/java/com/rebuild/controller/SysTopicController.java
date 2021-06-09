package com.rebuild.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hjq
 * @since 2021-06-09
 */
@Api(tags = "帖子")
@RestController
@RequestMapping("/sys-topic")
public class SysTopicController {

//    //lb_id+bd_id+tp_id+id+mf_id=ct_id
//    @ApiOperation(value = "新增帖子")
//    @PostMapping("/createOne")
//    @ApiImplicitParam(name = "bdId",value = "所选子板块id",paramType = "Integer")
//    @ResponseBody
}
