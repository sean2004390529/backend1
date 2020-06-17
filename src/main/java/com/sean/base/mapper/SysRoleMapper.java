package com.sean.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sean.base.entity.SysRole;
import com.sean.vo.req.RolePageReqVO;

public interface SysRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    // 查询所有角色--分页
    List<SysRole> selectAll(RolePageReqVO vo);
    
    // 查询所有角色--不分页
    List<SysRole> selectAllNoPage();
    
    // 批量删除角色(list需要删除用户的id列表)
    int batchDeleteRole(@Param("list") List<String> list);
}