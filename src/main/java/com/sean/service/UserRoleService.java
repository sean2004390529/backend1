package com.sean.service;

import java.util.List;

import com.sean.base.entity.SysRole;
import com.sean.vo.req.UserOwnRoleReqVO;

public interface UserRoleService {

	// 通过用户ID，查询roles
	List<SysRole> getRoleIdsByUserId(String userId);
	
	// 通过用户ID，更新roles
	void addUserRoleInfo(UserOwnRoleReqVO vo);
}
