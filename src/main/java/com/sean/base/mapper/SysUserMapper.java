package com.sean.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sean.base.entity.SysUser;
import com.sean.vo.req.UserPageReqVO;

public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    SysUser selectByUsername(String username);
    
    // 查询所有用户（可带查询条件）
    List<SysUser> selectAll(UserPageReqVO vo);
    
    // 批量删除用户(sysUser操作人id，list需要删除用户的id列表)
    int batchDeleteUser(@Param("list") List<String> list);
    
    // 根据用户ID，获取用户名字
    String selectByUserId(String userId);
}