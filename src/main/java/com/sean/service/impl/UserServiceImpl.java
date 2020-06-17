package com.sean.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sean.base.entity.SysRole;
import com.sean.base.entity.SysUser;
import com.sean.base.mapper.SysUserMapper;
import com.sean.base.mapper.SysUserRoleMapper;
import com.sean.constants.Constant;
import com.sean.exception.BusinessException;
import com.sean.exception.code.BaseResponseCode;
import com.sean.service.RedisService;
import com.sean.service.RoleService;
import com.sean.service.UserRoleService;
import com.sean.service.UserService;
import com.sean.utils.JwtTokenUtil;
import com.sean.utils.PageUtil;
import com.sean.utils.PasswordUtils;
import com.sean.utils.TokenSettings;
import com.sean.vo.req.LoginReqVO;
import com.sean.vo.req.UserAddReqVO;
import com.sean.vo.req.UserOwnRoleReqVO;
import com.sean.vo.req.UserPageReqVO;
import com.sean.vo.req.UserUpdateReqVO;
import com.sean.vo.resp.LoginRespVO;
import com.sean.vo.resp.PageVO;
import com.sean.vo.resp.UserOwnRoleRespVO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private RedisService redisService;
	
	@Autowired
	private TokenSettings tokenSettings;
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	// 用户与角色关联表
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	// 角色查询
	@Autowired
	private RoleService roleService;
	
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

//	@Override
//	public PageInfo<SysUser> pageInfo(UserPageReqVO vo) {
//		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
//		List<SysUser> allUser = sysUserMapper.selectAll();
//		PageInfo<SysUser> pageInfo =new PageInfo<>(allUser);
//		return pageInfo;
//	}
    
    // 查询所有用户
	@Override
	public PageVO<SysUser> selectAll(UserPageReqVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<SysUser> allUser = sysUserMapper.selectAll(vo);
		return PageUtil.getPageVO(allUser);
	}

	// 增加用户，密码加密存储
	@Override
	public void addUser(UserAddReqVO vo) {
		SysUser sysUser = new SysUser();
		BeanUtils.copyProperties(vo, sysUser);
		sysUser.setId(UUID.randomUUID().toString());
		sysUser.setCreateTime(new Date());
		
		// 加盐保存密码
		String salt = PasswordUtils.getSalt();
		String encryPwd = PasswordUtils.encode(vo.getPassword(), salt);
		sysUser.setSalt(salt);
		sysUser.setPassword(encryPwd);
		
		int ret = sysUserMapper.insertSelective(sysUser);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
	}

	// 更新用户信息，此方法不更新密码
	@Override
	public void updateUser(UserUpdateReqVO vo) {
		SysUser sysUser = new SysUser();
		BeanUtils.copyProperties(vo, sysUser);
		sysUser.setUpdateTime(new Date());
		
		int ret = sysUserMapper.updateByPrimaryKeySelective(sysUser);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
		}
		//如果禁用用户，则redis标记
		if(vo.getStatus()==0) {
			redisService.set(Constant.ACCOUNT_LOCK_KEY+vo.getId(), vo.getId());
		}
		//如果启用用户，则删除redis标记
		if(vo.getStatus()==1) {
			redisService.delete(Constant.ACCOUNT_LOCK_KEY+vo.getId());
		}
	}

	// 通过用户id，查询拥有角色
	@Override
	public UserOwnRoleRespVO getUserOwnRole(String userId) {
		// 创建Response对象
		UserOwnRoleRespVO respVO = new UserOwnRoleRespVO();
		// 查询用户拥有的角色id集合
		respVO.setSelectedRoles(userRoleService.getRoleIdsByUserId(userId));
		// 查询用户可以选择的全部角色列表
		respVO.setAllRoles(roleService.selectAllNoPage());
		return respVO;
	}

	// 通过用户ID，更新roles
	@Override
	public void setUserOwnRole(UserOwnRoleReqVO vo) {
		//更新roles
		userRoleService.addUserRoleInfo(vo);
		// 标记到redis，权限已经变更了，需要用户主动刷新，签发token
		redisService.set(
				Constant.JWT_REFRESH_KEY + vo.getUserId(), 
				vo.getUserId(), 
				tokenSettings.getAccessTokenExpireTime().toMillis(),
				TimeUnit.MILLISECONDS);
	}

	@Override
	public void batchDeleteUser(List<String> list) {
		// 创建一个虚拟user，并传入虚拟user的更新ID与更新日期到被删除User列表中的各User
//		SysUser sysUser = new SysUser();
//		sysUser.setUpdateId(operationId);
//		sysUser.setUpdateTime(new Date());
		int i = sysUserMapper.batchDeleteUser(list);
		if(i==0) {
			throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
		}
		
		// 删除与之关联的角色记录
		for(String userId : list) {
			sysUserRoleMapper.batchRemoveRoleByUserId(userId);
		}
		
		// redis标记用户已经被删除
		for(String userId : list) {
			redisService.set(
					Constant.DELETED_USER_KEY+userId, 
					userId,
					tokenSettings.getRefreshTokenExpireAppTime().toMillis(),
					TimeUnit.MICROSECONDS
					);
		}
	}
	
}
