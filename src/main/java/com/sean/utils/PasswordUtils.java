package com.sean.utils;

import java.util.UUID;

/**
* @ClassName:       PasswordUtils
*                   密码工具类
*/
public class PasswordUtils {

	/**
	 * 匹配密码
	 * @param salt 盐
	 * @param rawPass 明文 
	 * @param encPass 密文
	 */
	public static boolean matches(String salt, String rawPass, String encPass) {
		return new PasswordEncoder(salt).matches(encPass, rawPass);
	}
	
	/**
	 * 明文密码加盐
	 */
	public static String encode(String rawPass, String salt) {
		return new PasswordEncoder(salt).encode(rawPass);
	}

	/**
	 * 随机生成盐
	 */
	public static String getSalt() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
	}
}
