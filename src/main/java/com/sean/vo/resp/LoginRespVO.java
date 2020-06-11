package com.sean.vo.resp;

import io.swagger.annotations.ApiModelProperty;

public class LoginRespVO {

	@ApiModelProperty(value = "业务访问token")
	private String accessToken;
	
	@ApiModelProperty(value = "业务token刷新凭证")
	private String refreshToken;
	
	@ApiModelProperty(value = "用户ID")
	private String userId;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
