package com.sean.vo.req;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class LoginReqVO {

	@ApiModelProperty(value = "用户名")
	@NotBlank(message = "用户名不能为空")
	private String username;
	
	@ApiModelProperty(value = "密码")
	@NotBlank(message = "密码不能为空")
	private String password;
	
	@ApiModelProperty(value = "登录类型：1：PC, 2: APP")
	private String type = "1";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
