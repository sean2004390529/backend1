package com.sean.vo.req;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class StockStaffAddReqVO {

	@ApiModelProperty("员工名")
	@NotBlank(message = "员工名不能为空")
	private String staffname;
	
	@ApiModelProperty("电话号码")
	private String phone;
	
	@ApiModelProperty("email")
	private String email;
	
	@ApiModelProperty("部门ID")
	private String deptId;

	public String getStaffname() {
		return staffname;
	}

	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
}
