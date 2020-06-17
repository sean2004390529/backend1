package com.sean.vo.req;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.sean.base.entity.SysRole;

import io.swagger.annotations.ApiModelProperty;

public class UserOwnRoleReqVO {

	@ApiModelProperty("用户ID")
	@NotBlank(message = "用户id不能为空")
	private String userId;
	
	@ApiModelProperty("已分配角色ID集合")
	private List<SysRole> selectedRoles;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<SysRole> getSelectedRoles() {
		return selectedRoles;
	}

	public void setSelectedRoles(List<SysRole> selectedRoles) {
		this.selectedRoles = selectedRoles;
	}

	@Override
	public String toString() {
		return "UserOwnRoleReqVO [userId=" + userId + ", selectedRoles=" + selectedRoles + "]";
	}
	
}
