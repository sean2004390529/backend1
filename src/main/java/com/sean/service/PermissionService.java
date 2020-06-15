package com.sean.service;

import java.util.List;

import com.sean.base.entity.SysPermission;

public interface PermissionService {

	List<SysPermission> selectAll();
}
