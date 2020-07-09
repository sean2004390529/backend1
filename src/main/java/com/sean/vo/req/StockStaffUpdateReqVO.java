package com.sean.vo.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class StockStaffUpdateReqVO {

	@ApiModelProperty("用户ID")
	@NotNull(message = "ID不能为空")
	private Integer id;
	
	@ApiModelProperty("用户名")
	@NotBlank(message = "用户名不能为空")
	private String staffname;
	
	@ApiModelProperty("email")
	private String email;
	
	@ApiModelProperty("电话号码")
	private String phone;

	@ApiModelProperty("部门ID")
	private String deptId;
	
	public String getStaffname() {
		return staffname;
	}

	public void setStaffname(String staffname) {
		this.staffname = staffname;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "StockStaffUpdateReqVO [id=" + id + ", staffname=" + staffname + ", email=" + email + ", phone=" + phone
				+ ", deptId=" + deptId + "]";
	}
	
	
}
