package com.sean.base.mapper;

import java.util.List;

import com.sean.base.entity.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    SysUser selectByUsername(String username);
    
    List<SysUser> selectAll();
}