package com.sean.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sean.base.entity.SysDept;
import com.sean.base.mapper.SysDeptMapper;
import com.sean.exception.BusinessException;
import com.sean.exception.code.BaseResponseCode;
import com.sean.service.DeptService;
import com.sean.vo.req.DeptAddReqVO;
import com.sean.vo.req.DeptUpdateReqVO;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private SysDeptMapper sysDeptMapper;

	@Override
	public List<SysDept> getDept() {
		List<SysDept> list = sysDeptMapper.findAllRecursion();
		return list;
	}

	
	@Override
	public List<SysDept> selectAll() {
		return sysDeptMapper.selectAll();
	}
	
	@Override
	public List<SysDept> subDepts(String deptId) {
		List<SysDept> allDeptsList = sysDeptMapper.selectAll();
		if(!StringUtils.isEmpty(deptId) && !allDeptsList.isEmpty()) {
			SysDept dept = sysDeptMapper.selectByPrimaryKey(deptId);
			allDeptsList.remove(dept);
			
			// 查找子部门
			List<SysDept> subDeptlist = sysDeptMapper.findDeptByPid(deptId);
			if(!subDeptlist.isEmpty()) {
				for(SysDept sonDept : subDeptlist) {
					allDeptsList.remove(sonDept);
					
					// 查找孙部门
					List<SysDept> grandSonDeptlist = sysDeptMapper.findDeptByPid(sonDept.getId());
					if(!grandSonDeptlist.isEmpty()) {
						for(SysDept grandsonDept : grandSonDeptlist) {
							allDeptsList.remove(grandsonDept);
						}
					}
				}
			}
			
		}
		return allDeptsList;
	}	
	

	@Override
	public SysDept addDept(DeptAddReqVO vo) {
		SysDept sysDept = new SysDept();
		BeanUtils.copyProperties(vo, sysDept);
		sysDept.setId(UUID.randomUUID().toString());
		sysDept.setCreateTime(new Date());
		int i = sysDeptMapper.insertSelective(sysDept);
		if(i!=1){
			throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
		}
		return sysDept;
	}

	@Override
	public void updateDept(DeptUpdateReqVO vo) {
		SysDept sysDept = sysDeptMapper.selectByPrimaryKey(vo.getId());
		if(null==sysDept) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
		BeanUtils.copyProperties(vo, sysDept);
		sysDept.setUpdateTime(new Date());
		int ret = sysDeptMapper.updateByPrimaryKeySelective(sysDept);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
	}


	@Override
	public void deleteDept(String deptId) {
		SysDept dept = sysDeptMapper.selectByPrimaryKey(deptId);
		if(dept==null) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
		// 如果有子部门，则不允许删除
		List<SysDept> subDeptlist = sysDeptMapper.findDeptByPid(deptId);
		if(!subDeptlist.isEmpty()) {
			throw new BusinessException(BaseResponseCode.HAS_SUBDEPT_NOT_PERMIT_TO_DELETE);
		}
		// 后续需要补充存在关联用户的处理方法
		
		dept.setUpdateTime(new Date());
		int ret = sysDeptMapper.deleteDept(deptId);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
	}
	

}
