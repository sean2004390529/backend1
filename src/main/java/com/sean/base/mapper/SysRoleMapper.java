package com.sean.base.mapper;

import java.util.List;

import com.sean.base.entity.SysRole;
import com.sean.vo.req.RolePageReqVO;

public interface SysRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> selectAll(RolePageReqVO vo);
}