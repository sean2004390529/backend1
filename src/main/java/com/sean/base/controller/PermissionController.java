package com.sean.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sean.base.entity.SysPermission;
import com.sean.service.PermissionService;
import com.sean.utils.DataResult;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
@Api(tags="权限模块相关接口")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;
	
	public DataResult<List<SysPermission>> getAllPermission(){
		DataResult result = DataResult.success();
		result.setData(permissionService.selectAll());
		return result;
	}
	
}
