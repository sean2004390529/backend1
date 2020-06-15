package com.sean.vo.req;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class RoleUpdateReqVO {

	@ApiModelProperty("角色ID")
	@NotBlank(message = "ID不能为空")
	private String id;
	
	@ApiModelProperty("角色名")
	@NotBlank(message = "角色名不能为空")
	private String name;
	
	@ApiModelProperty("角色描述")
	private String description;
	
	@ApiModelProperty("状态(1:启用,0:禁用)")
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RoleUpdateReqVO [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status
				+ "]";
	}
	
	
	
}
