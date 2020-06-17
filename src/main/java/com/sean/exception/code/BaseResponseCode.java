package com.sean.exception.code;

public enum BaseResponseCode implements ResponseCodeInterface{
    /**
     * 响应状态码
     *code=0 操作成功
     *code=4010001（授权异常） 请求要求身份验证。 客户端需要跳转到登录页面重新登录
     *code=4010002 (凭证过期) 客户端请求刷新凭证接口
     *code=4030001 没有权限，禁止访问
     *code=400xxxx 系统主动抛出的业务异常 
     *code=5000001 系统异常
     */
	
    SUCCESS(0,"操作成功"),
    SYSTEM_ERROR(5000001,"系统异常"),
    
    DATA_ERROR(4000001,"传入的数据异常"),
    METHOD_IDENTITY_ERROR(4000002,"凭证过期"),
    ACCOUNT_ERROR(4000003,"登录账户不存在"),
    
    ACCOUNT_LOCK(4010001,"该账户被锁定"),
    ACCOUNT_PASSWORD_ERROR(4000004,"账户或密码错误"),
    TOKEN_ERROR(4010001,"用户未登录，请重新登录"),
    TOKEN_NOT_NULL(4010001,"认证token不能为空，请重新登录"),
    SHIRO_AUTHENTICATION_ERROR(4010001,"用户认证异常"),
    ACCOUNT_HAS_DELETED_ERROR(4010001,"该账户已被删除"),
    TOKEN_PAST_DUE(4010002,"token失效，请重新登录"),
    NOT_PERMISSION(4030001,"没有权限访问该资源"),
    
    OPERATION_ERROR(4000005,"操作失败"),
    ACCOUNT_LOCK_TIP(4010001,"该账户被锁定"),
    ;

    private int code;

    private String msg;

    BaseResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
