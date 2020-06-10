package com.sean.exception;

import com.sean.exception.code.BaseResponseCode;

/**
 * @ClassName: BusinessException
 */
public class BusinessException extends RuntimeException{

	// 提示码
    private final int code;

    // 提示
    public final String defaultMessage;

    public BusinessException(int code, String defaultMessage) {
        super(defaultMessage);
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

    public BusinessException(BaseResponseCode baseResponseCode){
        this(baseResponseCode.getCode(), baseResponseCode.getMsg());
    }
    public int getCode() {
        return code;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
