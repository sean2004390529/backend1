package com.sean.service;


import com.sean.base.entity.SysUser;
import com.sean.vo.req.LoginReqVO;
import com.sean.vo.req.UserAddReqVO;
import com.sean.vo.req.UserPageReqVO;
import com.sean.vo.req.UserUpdateReqVO;
import com.sean.vo.resp.LoginRespVO;
import com.sean.vo.resp.PageVO;

/**
 * @ClassName: UserService
 */
public interface UserService {

	// 登录
    LoginRespVO login(LoginReqVO vo);

    // 查询所有用户
//  PageInfo<SysUser> pageInfo(UserPageReqVO vo);
    PageVO<SysUser> selectAll(UserPageReqVO vo);
    
    // 增加用户
    void addUser(UserAddReqVO vo);
    
    // 更新用户
    void updateUser(UserUpdateReqVO vo);
}
