package com.sean.vo.req;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class UserUpdateReqVO {

	@ApiModelProperty("用户ID")
	@NotBlank(message = "ID不能为空")
	private String id;
	
	@ApiModelProperty("用户名")
	@NotBlank(message = "用户名不能为空")
	private String username;
	
	@ApiModelProperty("email")
	private String email;
	
	@ApiModelProperty("电话号码")
	private String phone;
	
	@ApiModelProperty("状态(1:启用,0:禁用)")
	private Integer status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "UserUpdateReqVO [id=" + id + ", username=" + username + ", email=" + email + ", phone=" + phone
				+ ", status=" + status + "]";
	}

	
}
