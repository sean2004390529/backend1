package com.sean.service;


import com.sean.vo.req.LoginReqVO;
import com.sean.vo.resp.LoginRespVO;
/**
 * @ClassName: UserService
 */
public interface UserService {

    public LoginRespVO login(LoginReqVO vo);

}
