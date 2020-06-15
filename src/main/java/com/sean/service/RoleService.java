package com.sean.service;

import com.sean.base.entity.SysRole;
import com.sean.vo.req.AddRoleReqVO;
import com.sean.vo.req.RolePageReqVO;
import com.sean.vo.req.RoleUpdateReqVO;
import com.sean.vo.resp.PageVO;

public interface RoleService {

	// 查询所有角色
//	PageInfo<SysRole> selectAll(PageReqVO vo);
	PageVO<SysRole> selectAll(RolePageReqVO vo);
	
	// 新增角色
	SysRole addRole(AddRoleReqVO vo);
	
	// 更新角色
	void updateRole(RoleUpdateReqVO vo);
}
