package com.sean.vo.req;

import io.swagger.annotations.ApiModelProperty;

public class UserPageReqVO {

	@ApiModelProperty("当前第几页")
	private Integer pageNum = 1;
	
	@ApiModelProperty("当前页数据条目数")
	private Integer pageSize = 10;
	
	@ApiModelProperty("用户名")
	private String username;
	
	@ApiModelProperty("邮箱地址")
	private String email;
	
	@ApiModelProperty("电话号码")
	private String phone;
	
	@ApiModelProperty("状态(1:启用, 2:禁用)")
	private Integer Status;
	
	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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
		return Status;
	}

	public void setStatus(Integer status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "UserPageReqVO [pageNum=" + pageNum + ", pageSize=" + pageSize + ", username=" + username + ", email="
				+ email + ", phone=" + phone + ", Status=" + Status + "]";
	}
	
}
