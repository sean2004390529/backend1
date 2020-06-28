package com.sean.vo.req;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class DeptUpdateReqVO {

	@ApiModelProperty("部门ID")
	@NotBlank(message = "部门ID不能为空")
	private String id;
	
	@ApiModelProperty("部门名称")
	@NotBlank(message = "部门名称不能为空")
	private String name;
	
	@ApiModelProperty("父级ID，顶级部门为0")
	@NotBlank(message = "父级id不能为空")
	private String pid;
	
	@ApiModelProperty("部门经理名称")
	private String managerName;
	
	@ApiModelProperty("部门经理电话")
	private String phone;
	
	@ApiModelProperty("部门状态(1:正常；0:禁用)")
	private Integer status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
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
	
	
	
}
