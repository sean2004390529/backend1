package com.sean.base.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sean.base.entity.SysUser;
import com.sean.service.UserService;
import com.sean.utils.DataResult;
import com.sean.vo.req.LoginReqVO;
import com.sean.vo.req.UserAddReqVO;
import com.sean.vo.req.UserPageReqVO;
import com.sean.vo.req.UserUpdateReqVO;
import com.sean.vo.resp.LoginRespVO;
import com.sean.vo.resp.PageVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
@Api(tags="用户模块相关接口")
public class UserController {

    @Autowired
    private UserService userService;
	
    @PostMapping("/user/login")
    @ApiOperation(value = "用户登录接口")
    public DataResult<LoginRespVO> login(@RequestBody @Valid LoginReqVO vo){
        DataResult result=DataResult.success();
        result.setData(userService.login(vo));
        return result;
    }
	
    // mock假数据
    @GetMapping("/user/info")
    @ApiOperation(value = "用户信息查询接口")
    public DataResult<LoginRespVO> login(){
        DataResult result=DataResult.success();
        List<String> list = new ArrayList<String>();
        list.add("admin");
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", list);
        result.setData(claims);
        return result;
    }
    
//    @PostMapping("/user/list")
//    @ApiModelProperty("分页查询用户接口")
//    public DataResult<PageInfo<SysUser>> pageInfo(@RequestBody PageReqVO vo){
//    	DataResult result = DataResult.success();
//    	result.setData(userService.pageInfo(vo));
//    	return result;
//    }
    
    @PostMapping("/user/list")
    @ApiModelProperty("分页查询用户接口")
    public DataResult<PageVO<SysUser>> pageInfo(@RequestBody UserPageReqVO vo){
    	System.out.println(vo);
    	DataResult result = DataResult.success();
    	result.setData(userService.selectAll(vo));
    	return result;
    }
    
    @PostMapping("/user")
    @ApiModelProperty("新增用户")
    public DataResult addUser(@RequestBody @Valid UserAddReqVO vo) {
    	DataResult result = DataResult.success();
    	userService.addUser(vo);
    	return result;
    }
    
    @PutMapping("/user")
    @ApiModelProperty("修改用户信息")
    public DataResult updateUser(@RequestBody @Valid UserUpdateReqVO vo) {
    	System.out.println(vo);
    	DataResult result = DataResult.success();
    	userService.updateUser(vo);
    	return result;
    }
    
    
}
