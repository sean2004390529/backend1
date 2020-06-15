package com.sean.base.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sean.base.entity.SysRole;
import com.sean.service.RoleService;
import com.sean.utils.DataResult;
import com.sean.vo.req.RoleAddReqVO;
import com.sean.vo.req.RolePageReqVO;
import com.sean.vo.req.RoleUpdateReqVO;
import com.sean.vo.resp.PageVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
@Api(tags="角色模块相关接口")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
//	@PostMapping("/role/list")
//	@ApiModelProperty("分页查询角色接口")
//	public DataResult<PageInfo<SysRole>> pageInfo(@RequestBody PageReqVO vo){
//		DataResult result = DataResult.success();
//		result.setData(roleService.selectAll(vo));
//		return result;
//	}
	
	@PostMapping("/role/list")
	@ApiModelProperty("分页查询用户接口")
	public DataResult<PageVO<SysRole>> pageInfo(@RequestBody RolePageReqVO vo){
	  	System.out.println(vo);
	  	DataResult result = DataResult.success();
	  	result.setData(roleService.selectAll(vo));
	  	return result;
	}
	
	@PostMapping("/role")
	@ApiModelProperty("新增角色")
	public DataResult<SysRole> addRole(@RequestBody @Valid RoleAddReqVO vo){
		DataResult result = DataResult.success();
		result.setData(roleService.addRole(vo));
		return result;
	}
	
	
    @PutMapping("/role")
    @ApiOperation(value = "修改角色")
    public DataResult updateRole(@RequestBody @Valid RoleUpdateReqVO vo){
        DataResult result=DataResult.success();
        roleService.updateRole(vo);
        return result;
    }
	
	
}
