package com.sean.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sean.base.entity.SysPermission;
import com.sean.base.mapper.SysPermissionMapper;
import com.sean.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	
	@Override
	public List<SysPermission> selectAll() {
		return sysPermissionMapper.selectAll();
	}

}
