package com.sean.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		List<SysDept> list = sysDeptMapper.selectAll();
		return list;
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

	
//	@Override
//	public List<SysDept> selectAll() {
//		//为部门list添加父集部门名称
//		List<SysDept> all = sysDeptMapper.selectAll();
//		for(SysDept dept : all) {
//			SysDept primaryKey = sysDeptMapper.selectByPrimaryKey(dept.getPid());
//			if(primaryKey!=null) {
////				dept.setPidName(parentDept.getName());
//				dept.setSubDept(sysDeptMapper.getSubDept()););
//			}
//		}
//		return all;
//	}


}
