package com.sean.utils;

import org.springframework.stereotype.Component;

@Component
public class InitializerUtil {
	
    private TokenSettings tokenSettings;
    
    public InitializerUtil(TokenSettings tokenSettings){
        JwtTokenUtil.setTokenSettings(tokenSettings);
    }
}