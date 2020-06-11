package com.sean.shiro;

import com.sean.constants.Constant;
import com.sean.exception.BusinessException;
import com.sean.exception.code.BaseResponseCode;
import com.sean.service.RedisService;
import com.sean.utils.JwtTokenUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;
import java.util.prefs.BackingStoreException;


public class CustomHashedCredentialsMatcher extends HashedCredentialsMatcher {
    @Autowired
    private RedisService redisService;
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        CustomUsernamePasswordToken customUsernamePasswordToken= (CustomUsernamePasswordToken) token;
        String accessToken= (String) customUsernamePasswordToken.getPrincipal();
        String userId= JwtTokenUtil.getUserId(accessToken);
        if(userId!=null) {
        	// 判断用户是否被锁定
            if(redisService.hasKey(Constant.ACCOUNT_LOCK_KEY+userId)){
                throw new BusinessException(BaseResponseCode.ACCOUNT_LOCK);
            }
            // 判断用户是否被删除
            if(redisService.hasKey(Constant.DELETED_USER_KEY+userId)){
                throw new BusinessException(BaseResponseCode.ACCOUNT_HAS_DELETED_ERROR);
            }
            // 判断token 是否主动登出
            if(redisService.hasKey(Constant.JWT_REFRESH_TOKEN_BLACKLIST+accessToken)){
                throw new BusinessException(BaseResponseCode.TOKEN_ERROR);
            }
            // 判断token是否通过校验
            if(!JwtTokenUtil.validateToken(accessToken)){
                throw new BusinessException(BaseResponseCode.TOKEN_PAST_DUE);
            }
            
            /**
             * 判断这个登录用户是否要主动去刷新
             * 如果 key=Constant.JWT_REFRESH_KEY+userId大于accessToken说明是在 accessToken不是重新生成的
             * 这样就要判断它是否刷新过了/或者是否是新生成的token
             */
            if(redisService.hasKey(Constant.JWT_REFRESH_KEY+userId)&&redisService.getExpire(Constant.JWT_REFRESH_KEY+userId, TimeUnit.MILLISECONDS)>JwtTokenUtil.getRemainingTime(accessToken)){
                // 是否存在刷新的标识
                if(!redisService.hasKey(Constant.JWT_REFRESH_IDENTIFICATION+accessToken)){
                    throw new BusinessException(BaseResponseCode.TOKEN_PAST_DUE);
                }
            }
            return true;
            
        }else
        	return false;
    }
}
