package com.sean.base.mapper;

import java.util.List;

import com.sean.base.entity.SysRole;
import com.sean.base.entity.SysUserRole;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
    
    // 通过用户ID，查询所有结果集
    List<SysUserRole> getRoleIdsByUserId(String userId);
    
    // 通过用户ID，删除roles
    int batchRemoveRoleByUserId(String userId);
    
    // 通过用户ID，添加roles
    int batchInsertRoleByUserId(List<SysUserRole> list);
}