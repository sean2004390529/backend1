package com.sean.utils;

import com.sean.constants.Constant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.xml.bind.DatatypeConverter;
import java.time.Duration;
import java.util.Date;
import java.util.Map;

public class JwtTokenUtil {

    private static String secretKey;
    private static Duration accessTokenExpireTime;
    private static Duration refreshTokenExpireTime;
    private static Duration refreshTokenExpireAppTime;
    private static String issuer;
    
    public static void setTokenSettings(TokenSettings tokenSettings){
        secretKey=tokenSettings.getSecretKey();
        accessTokenExpireTime=tokenSettings.getAccessTokenExpireTime();
        refreshTokenExpireTime=tokenSettings.getRefreshTokenExpireTime();
        refreshTokenExpireAppTime=tokenSettings.getRefreshTokenExpireAppTime();
        issuer=tokenSettings.getIssuer();
    }
    
    
    public static String getSecretKey() {
		return secretKey;
	}


	public static void setSecretKey(String secretKey) {
		JwtTokenUtil.secretKey = secretKey;
	}


	public static Duration getAccessTokenExpireTime() {
		return accessTokenExpireTime;
	}


	public static void setAccessTokenExpireTime(Duration accessTokenExpireTime) {
		JwtTokenUtil.accessTokenExpireTime = accessTokenExpireTime;
	}

	public static Duration getRefreshTokenExpireTime() {
		return refreshTokenExpireTime;
	}

	public static void setRefreshTokenExpireTime(Duration refreshTokenExpireTime) {
		JwtTokenUtil.refreshTokenExpireTime = refreshTokenExpireTime;
	}


	public static Duration getRefreshTokenExpireAppTime() {
		return refreshTokenExpireAppTime;
	}


	public static void setRefreshTokenExpireAppTime(Duration refreshTokenExpireAppTime) {
		JwtTokenUtil.refreshTokenExpireAppTime = refreshTokenExpireAppTime;
	}

	public static String getIssuer() {
		return issuer;
	}

	public static void setIssuer(String issuer) {
		JwtTokenUtil.issuer = issuer;
	}

	// AccessToken
    public static String getAccessToken(String subject, Map<String,Object> claims){

        return generateToken(issuer,subject,claims,accessTokenExpireTime.toMillis(),secretKey);
    }
    
    // generateToken
    public static String generateToken(String issuer, String subject, Map<String, Object> claims, long ttlMillis, String secret) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        byte[] signingKey = DatatypeConverter.parseBase64Binary(secret);

        JwtBuilder builder = Jwts.builder();
        if(null!=claims){
            builder.setClaims(claims);
        }
        if (!StringUtils.isEmpty(subject)) {
            builder.setSubject(subject);
        }
        if (!StringUtils.isEmpty(issuer)) {
            builder.setIssuer(issuer);
        }
        builder.setIssuedAt(now);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        builder.signWith(signatureAlgorithm, signingKey);
        return builder.compact();
    }
    
    // RefreshToken - PC 
    public static String getRefreshToken(String subject,Map<String,Object> claims){
        return generateToken(issuer,subject,claims,refreshTokenExpireTime.toMillis(),secretKey);
    }
    
    // RefreshToken - APP 
    public static String getRefreshAppToken(String subject,Map<String,Object> claims){
        return generateToken(issuer,subject,claims,refreshTokenExpireAppTime.toMillis(),secretKey);
    }
    
    
    
    // 从Token中获取用户信息
    public static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey)).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }
    
    // token中获取UserID
    public static String getUserId(String token){
        String userId=null;
        try {
            Claims claims = getClaimsFromToken(token);
            userId = claims.getSubject();
        } catch (Exception e) {
//            log.error("eror={}",e);
            System.out.println("getUserId Error" + e);
        }
        return userId;
    }
    
    // token中获取用户名
    public static String getUserName(String token){
        String username=null;
        try {
            Claims claims = getClaimsFromToken(token);
            username = (String) claims .get(Constant.JWT_USER_NAME);
        } catch (Exception e) {
//            log.error("eror={}",e);
        	System.out.println("getUserName Error" + e);
        }
        return username;
    }
    
    // 判断token是否过期
    public static Boolean isTokenExpired(String token) {

        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
//            log.error("error={}",e);
        	System.out.println("isTokenExpired Error" + e);
            return true;
        }
    }
    
    // 判断token是否有效
    public static Boolean validateToken(String token) {
        Claims claimsFromToken = getClaimsFromToken(token);
        return (null!=claimsFromToken && !isTokenExpired(token));
    }
    
    // 刷新token
    public static String refreshToken(String refreshToken,Map<String, Object> claims) {
        String refreshedToken;
        try {
            Claims parserclaims = getClaimsFromToken(refreshToken);
            if(null==claims){
                claims=parserclaims;
            }
            refreshedToken = generateToken(parserclaims.getIssuer(),parserclaims.getSubject(),claims,accessTokenExpireTime.toMillis(),secretKey);
        } catch (Exception e) {
            refreshedToken = null;
            System.out.println("refreshToken Error" + e);
        }
        return refreshedToken;
    }
    
    // 获取token有效期
    public static long getRemainingTime(String token){
        long result=0;
        try {
            long nowMillis = System.currentTimeMillis();
            result= getClaimsFromToken(token).getExpiration().getTime()-nowMillis;
        } catch (Exception e) {
//            log.error("error={}",e);
            System.out.println("getRemainingTime Error" + e);
        }
        return result;
    }
    
}
