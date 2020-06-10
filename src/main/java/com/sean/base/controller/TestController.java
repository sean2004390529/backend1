package com.sean.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/swagger")
@Api(value="测试接口模块", description = "测试接口模块")
public class TestController {

	
	@GetMapping("/test")
	@ApiOperation(value = "测试接口")
	public String testSwagger() {
		return "测试成功";
	}
}
