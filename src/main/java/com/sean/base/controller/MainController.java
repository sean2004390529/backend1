package com.sean.base.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sean.exception.BusinessException;
import com.sean.exception.code.BaseResponseCode;
import com.sean.utils.DataResult;
import com.sean.vo.req.TestReqVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
@Api(value="测试登录接口", description = "测试登录接口")
public class MainController {

	
//	@PostMapping("/user/login")
//	@ApiOperation(value = "测试登录")
//	public String testLogin() {
//		return "登录成功";
//	}
	
//	@PostMapping("/user/login")
//	@ApiOperation(value = "测试登录")
//	public DataResult<String> testLogin() {
//		DataResult ret = DataResult.success();
//		ret.setData("登录成功");
////		int i=10/0;
//		throw new BusinessException(BaseResponseCode.DATA_ERROR);
////		return ret;
//	}
	
	@PostMapping("/user/login")
	@ApiOperation(value = "测试登录")
	public DataResult<String> testLogin(@RequestBody @Valid TestReqVO vo) {
		DataResult ret = DataResult.success();
		ret.setData("登录成功");
		return ret;
	}
}
