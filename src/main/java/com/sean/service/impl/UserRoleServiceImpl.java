package com.sean.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sean.base.entity.SysRole;
import com.sean.base.entity.SysUserRole;
import com.sean.base.mapper.SysUserRoleMapper;
import com.sean.exception.BusinessException;
import com.sean.exception.code.BaseResponseCode;
import com.sean.service.RoleService;
import com.sean.service.UserRoleService;
import com.sean.vo.req.UserOwnRoleReqVO;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	@Autowired
	private RoleService roleSerivce;
	
	@Override
	public List<SysRole> getRoleIdsByUserId(String userId) {
		System.out.println("UserRoleServiceImpl---getRoleIdsByUserId");
		System.out.println(userId);
		List<SysUserRole> list = sysUserRoleMapper.getRoleIdsByUserId(userId);
		List<SysRole> rolelist = new ArrayList<>();
		for(SysUserRole item: list) {
			rolelist.add(roleSerivce.selectByPrimaryKey(item.getRoleId()));
		}
		return rolelist;
	}

	// 通过用户ID，更新roles
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addUserRoleInfo(UserOwnRoleReqVO vo) {
		// 先删除roles
		sysUserRoleMapper.batchRemoveRoleByUserId(vo.getUserId());
		System.out.println(vo);
		// 重新添加roles
		if(vo.getSelectedRoles()==null || vo.getSelectedRoles().isEmpty()) {
			return ;
		}
		// 组装SysUserRole对象，并写入数据库
		List<SysRole> rolesList = vo.getSelectedRoles();
		List<SysUserRole> list = new ArrayList<>();
		for(SysRole sysRole : rolesList) {
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setId(UUID.randomUUID().toString());
			sysUserRole.setCreateTime(new Date());
			sysUserRole.setUserId(vo.getUserId());
			sysUserRole.setRoleId(sysRole.getId());
			list.add(sysUserRole);
		}
		int ret = sysUserRoleMapper.batchInsertRoleByUserId(list);
		if(ret==0) {
			throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
		}
	}

}
