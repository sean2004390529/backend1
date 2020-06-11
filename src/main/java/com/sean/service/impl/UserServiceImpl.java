package com.sean.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sean.base.entity.SysUser;
import com.sean.base.mapper.SysUserMapper;
import com.sean.constants.Constant;
import com.sean.exception.BusinessException;
import com.sean.exception.code.BaseResponseCode;
import com.sean.service.UserService;
import com.sean.utils.JwtTokenUtil;
import com.sean.utils.PasswordUtils;
import com.sean.vo.req.LoginReqVO;
import com.sean.vo.resp.LoginRespVO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	public LoginRespVO login(LoginReqVO vo) {
		//查询数据库
		SysUser sysUser = sysUserMapper.selectByUsername(vo.getUsername());
		// 用户不存在
		if(sysUser==null) {
			throw new BusinessException(BaseResponseCode.ACCOUNT_ERROR);
		}
		// 用户被锁定
		if(sysUser.getStatus()==2) {
			throw new BusinessException(BaseResponseCode.ACCOUNT_LOCK);
		}
		// 判断密码是否正确
		if(!PasswordUtils.matches(sysUser.getSalt(), vo.getPassword(), sysUser.getPassword())) {
			throw new BusinessException(BaseResponseCode.ACCOUNT_PASSWORD_ERROR);
		}
		
		//以上都通过，则签发accessToken
		Map<String, Object> claims = new HashMap<>();
		claims.put(Constant.JWT_USER_NAME, sysUser.getUsername());
		claims.put(Constant.JWT_ROLES_KEY, getRolesByUserId(sysUser.getId()));
		claims.put(Constant.JWT_PERMISSIONS_KEY, getPermissionsByUserId(sysUser.getId()));
		String accessToken = JwtTokenUtil.getAccessToken(sysUser.getId(), claims);
		System.out.println("accessToken Create: ");
		System.out.println(claims);
		
		// 签发刷新token
		Map<String, Object> refreshTokenClaims = new HashMap<>();
		refreshTokenClaims.put(Constant.JWT_USER_NAME, sysUser.getUsername());
		String refreshToken = null;
		if(vo.getType().equals("1")) {
			refreshToken = JwtTokenUtil.getRefreshToken(sysUser.getId(), refreshTokenClaims);
		}else {
			refreshToken = JwtTokenUtil.getRefreshAppToken(sysUser.getId(), refreshTokenClaims);
		}
		System.out.println("refreshToken Create: ");
		System.out.println(refreshToken);
		
		// 响应VO
		LoginRespVO loginRespVO = new LoginRespVO();
		loginRespVO.setUserId(sysUser.getId());
		loginRespVO.setAccessToken(accessToken);
		loginRespVO.setRefreshToken(refreshToken);
		
		return loginRespVO;
	}

	// mock假数据
    private List<String> getRolesByUserId(String userId){

        List<String> roles=new ArrayList<>();
        if("9a26f5f1-cbd2-473d-82db-1d6dcf4598f8".equals(userId)){
            roles.add("admin");
        }else {
            roles.add("editor");
        }
        return roles;
    }
    
    // mock假数据
    private List<String> getPermissionsByUserId(String userId){
        List<String> permissions=new ArrayList<>();
        if("9a26f5f1-cbd2-473d-82db-1d6dcf4598f8".equals(userId)){
            permissions.add("sys:user:list");
            permissions.add("sys:user:add");
            permissions.add("sys:user:update");
            permissions.add("sys:user:detail");
        }else {
            permissions.add("sys:user:detail");
        }
        return permissions;
    }
}
