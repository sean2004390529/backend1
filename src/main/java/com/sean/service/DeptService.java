package com.sean.service;

import java.util.List;

import com.sean.base.entity.SysDept;
import com.sean.vo.req.DeptAddReqVO;
import com.sean.vo.req.DeptUpdateReqVO;

public interface DeptService {

	// 获取部门树
	List<SysDept> getDept();
	
	// 查询所有部门
	List<SysDept> selectAll();
	
	// 新增部门
	SysDept addDept(DeptAddReqVO vo);
	
	// 更新部门
	void updateDept(DeptUpdateReqVO vo);
	
}
