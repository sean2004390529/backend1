package com.sean.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sean.base.entity.SysRole;
import com.sean.base.mapper.SysRoleMapper;
import com.sean.exception.BusinessException;
import com.sean.exception.code.BaseResponseCode;
import com.sean.service.RoleService;
import com.sean.utils.PageUtil;
import com.sean.vo.req.AddRoleReqVO;
import com.sean.vo.req.RolePageReqVO;
import com.sean.vo.req.RoleUpdateReqVO;
import com.sean.vo.resp.PageVO;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	// 查询所有角色
//	@Override
//	public PageInfo<SysRole> selectAll(PageReqVO vo) {
//		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
//		List<SysRole> allRole = sysRoleMapper.selectAll();
//		PageInfo<SysRole> pageInfo = new PageInfo<>(allRole);
//		return pageInfo;
//	}
	
	@Override
	public PageVO<SysRole> selectAll(RolePageReqVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<SysRole> allRole = sysRoleMapper.selectAll(vo);
		return PageUtil.getPageVO(allRole);
	}
//	@Override
//	public PageVO<SysUser> pageInfo(UserPageReqVO vo) {
//		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
//		List<SysUser> allUser = sysUserMapper.selectAll();
//		return PageUtil.getPageVO(allUser);
//	}


	// 新增角色
	@Override
	public SysRole addRole(AddRoleReqVO vo) {
		SysRole sysRole = new SysRole();
		try {
			BeanUtils.copyProperties(sysRole, vo);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sysRole.setId(UUID.randomUUID().toString());
		sysRole.setCreateTime(new Date());
		int i = sysRoleMapper.insertSelective(sysRole);
		if(i!=1) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
		return sysRole;
	}
	
	// 更新角色
	@Override
	public void updateRole(RoleUpdateReqVO vo) {
		SysRole sysRole = sysRoleMapper.selectByPrimaryKey(vo.getId());
		if(null==sysRole) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
		try {
			BeanUtils.copyProperties(sysRole, vo);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sysRole.setUpdateTime(new Date());
		int ret = sysRoleMapper.updateByPrimaryKeySelective(sysRole);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
	}


	
}
