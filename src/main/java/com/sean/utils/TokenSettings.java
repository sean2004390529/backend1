package com.sean.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@ConfigurationProperties(prefix = "jwt")
public class TokenSettings {
	
    private String secretKey;
    private Duration accessTokenExpireTime;
    private Duration refreshTokenExpireTime;
    private Duration refreshTokenExpireAppTime;
    private String issuer;
    
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public Duration getAccessTokenExpireTime() {
		return accessTokenExpireTime;
	}
	public void setAccessTokenExpireTime(Duration accessTokenExpireTime) {
		this.accessTokenExpireTime = accessTokenExpireTime;
	}
	public Duration getRefreshTokenExpireTime() {
		return refreshTokenExpireTime;
	}
	public void setRefreshTokenExpireTime(Duration refreshTokenExpireTime) {
		this.refreshTokenExpireTime = refreshTokenExpireTime;
	}
	public Duration getRefreshTokenExpireAppTime() {
		return refreshTokenExpireAppTime;
	}
	public void setRefreshTokenExpireAppTime(Duration refreshTokenExpireAppTime) {
		this.refreshTokenExpireAppTime = refreshTokenExpireAppTime;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
    
    
}
