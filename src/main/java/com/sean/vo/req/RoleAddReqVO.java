package com.sean.vo.req;



import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class RoleAddReqVO {

	@ApiModelProperty("角色名称")
	@NotBlank(message = "角色名称不能为空")
	private String name;
	
	@ApiModelProperty("角色描述")
	private String description;
	
	@ApiModelProperty("状态：(1:启用，2:禁用)")
	private Integer status;

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
	
	
}
