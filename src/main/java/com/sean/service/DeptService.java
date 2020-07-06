package com.sean.service;

import java.util.List;

import com.sean.base.entity.SysDept;
import com.sean.vo.req.DeptAddReqVO;
import com.sean.vo.req.DeptUpdateReqVO;

public interface DeptService {

	// 获取部门树（树状部门树）
	List<SysDept> getDept();
	
	// 查询所有部门(扁平式部门列表)
	List<SysDept> subDepts(String deptId);
	
	// 查询所有部门(扁平式部门列表)
	List<SysDept> selectAll();
	
	// 新增部门
	SysDept addDept(DeptAddReqVO vo);
	
	// 更新部门
	void updateDept(DeptUpdateReqVO vo);
	
	// 删除部门
	void deleteDept(String deptId);
	
}
