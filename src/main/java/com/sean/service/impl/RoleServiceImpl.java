package com.sean.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sean.base.entity.SysRole;
import com.sean.base.mapper.SysRoleMapper;
import com.sean.exception.BusinessException;
import com.sean.exception.code.BaseResponseCode;
import com.sean.service.RoleService;
import com.sean.service.UserRoleService;
import com.sean.utils.PageUtil;
import com.sean.vo.req.RoleAddReqVO;
import com.sean.vo.req.RolePageReqVO;
import com.sean.vo.req.RoleUpdateReqVO;
import com.sean.vo.resp.PageVO;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private UserRoleService userRoleService;
	
	// 查询所有角色
//	@Override
//	public PageInfo<SysRole> selectAll(PageReqVO vo) {
//		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
//		List<SysRole> allRole = sysRoleMapper.selectAll();
//		PageInfo<SysRole> pageInfo = new PageInfo<>(allRole);
//		return pageInfo;
//	}
	
	// 查询所有角色--分页
	@Override
	public PageVO<SysRole> selectAll(RolePageReqVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<SysRole> allRole = sysRoleMapper.selectAll(vo);
		return PageUtil.getPageVO(allRole);
	}
	
	// 查询所有角色--不分页
	@Override
	public List<SysRole> selectAllNoPage() {
		return sysRoleMapper.selectAllNoPage();
	}
	
	
	// 新增角色
	@Override
	public SysRole addRole(RoleAddReqVO vo) {
		SysRole sysRole = new SysRole();
		BeanUtils.copyProperties(vo, sysRole);
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
		BeanUtils.copyProperties(vo, sysRole);
		sysRole.setUpdateTime(new Date());
		int ret = sysRoleMapper.updateByPrimaryKeySelective(sysRole);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
	}

	@Override
	public SysRole selectByPrimaryKey(String id) {
		return sysRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void batchDeleteRole(List<String> list) {
		int i = sysRoleMapper.batchDeleteRole(list);
		if(i==0) {
			throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
		}
	}

	@Override
	public List<String> getRoleNames(String userId) {
        List<SysRole> sysRoles = userRoleService.getRoleIdsByUserId(userId);
        if (null==sysRoles||sysRoles.isEmpty()){
            return null;
        }
        List<String> list=new ArrayList<>();
        for (SysRole sysRole:sysRoles){
            list.add(sysRole.getName());
        }
        return list;
	}
	
}
