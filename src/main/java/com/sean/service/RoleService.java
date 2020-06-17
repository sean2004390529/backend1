package com.sean.service;

import java.util.List;

import com.sean.base.entity.SysRole;
import com.sean.vo.req.RoleAddReqVO;
import com.sean.vo.req.RolePageReqVO;
import com.sean.vo.req.RoleUpdateReqVO;
import com.sean.vo.resp.PageVO;

public interface RoleService {

	// 查询所有角色--分页
//	PageInfo<SysRole> selectAll(PageReqVO vo);
	PageVO<SysRole> selectAll(RolePageReqVO vo);
	
	// 查询所有角色--不分页
	List<SysRole> selectAllNoPage();
	
	// 新增角色
	SysRole addRole(RoleAddReqVO vo);
	
	// 更新角色
	void updateRole(RoleUpdateReqVO vo);
	
	// 通过ID，查找角色
	SysRole selectByPrimaryKey(String id);
}
