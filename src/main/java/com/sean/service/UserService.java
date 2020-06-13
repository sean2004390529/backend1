package com.sean.service;


import com.github.pagehelper.PageInfo;
import com.sean.base.entity.SysUser;
import com.sean.vo.req.LoginReqVO;
import com.sean.vo.req.UserPageReqVO;
import com.sean.vo.resp.LoginRespVO;

/**
 * @ClassName: UserService
 */
public interface UserService {

    LoginRespVO login(LoginReqVO vo);

  PageInfo<SysUser> pageInfo(UserPageReqVO vo);
//    PageVO<SysUser> pageInfo(UserPageReqVO vo);
    
    
}
