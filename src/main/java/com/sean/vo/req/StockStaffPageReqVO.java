package com.sean.vo.req;

import io.swagger.annotations.ApiModelProperty;

public class StockStaffPageReqVO {

	@ApiModelProperty("当前第几页")
	private Integer pageNum = 1;
	
	@ApiModelProperty("当前页数据条目数")
	private Integer pageSize = 20;
	
	@ApiModelProperty("员工")
	private String staffname;
	
	@ApiModelProperty("邮箱地址")
	private String email;
	
	@ApiModelProperty("电话号码")
	private String phone;

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

	public String getStaffname() {
		return staffname;
	}

	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
	
	
}
