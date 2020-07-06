package com.sean.base.mapper;

import java.util.List;

import com.sean.base.entity.SysDept;

public interface SysDeptMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    SysDept selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);
    
    // 查找部门树
    List<SysDept> findAllRecursion();
    
    // 查询所有部门
    List<SysDept> selectAll();
    
    // 查看子部门
    List<SysDept> findDeptByPid(String id);
    
    // 删除部门
    int deleteDept(String id);
}