package com.sean.vo.req;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class UserAddReqVO {

	@ApiModelProperty("用户名")
	@NotBlank(message = "用户名不能为空")
	private String username;
	
	@ApiModelProperty("密码")
	@NotBlank(message = "密码不能为空")
	private String password;
	
	@ApiModelProperty("电话号码")
	private String phone;
	
	@ApiModelProperty("状态：(1:启用，2:禁用)")
	private Integer status;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserAddReqVO [username=" + username + ", password=" + password + ", phone=" + phone + ", status="
				+ status + "]";
	}
	
	
}
