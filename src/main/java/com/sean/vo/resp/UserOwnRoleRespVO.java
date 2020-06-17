package com.sean.vo.resp;

import java.util.List;

import com.sean.base.entity.SysRole;

import io.swagger.annotations.ApiModelProperty;

public class UserOwnRoleRespVO {

	@ApiModelProperty("所有的角色列表")
	private List<SysRole> allRoles;
	
	@ApiModelProperty("拥有角色列表集合")
	private List<SysRole> selectedRoles;

	public List<SysRole> getAllRoles() {
		return allRoles;
	}

	public void setAllRoles(List<SysRole> allRoles) {
		this.allRoles = allRoles;
	}

	public List<SysRole> getSelectedRoles() {
		return selectedRoles;
	}

	public void setSelectedRoles(List<SysRole> selectedRoles) {
		this.selectedRoles = selectedRoles;
	}

	
}
