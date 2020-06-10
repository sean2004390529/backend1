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
    ACCOUNT_ERROR(4000003,"璇ヨ处鍙蜂笉瀛樺湪"),
    
    ACCOUNT_LOCK(4010001,"璇ヨ处鍙疯閿佸畾"),
    ACCOUNT_PASSWORD_ERROR(4000004,"鐢ㄦ埛鍚嶅瘑鐮佷笉鍖归厤"),
    TOKEN_ERROR(4010001,"鐢ㄦ埛鏈櫥褰曪紝璇烽噸鏂扮櫥褰�"),
    TOKEN_NOT_NULL(4010001,"token 涓嶈兘涓虹┖"),
    SHIRO_AUTHENTICATION_ERROR(4010001,"鐢ㄦ埛璁よ瘉寮傚父"),
    ACCOUNT_HAS_DELETED_ERROR(4010001,"璇ヨ处鍙峰凡琚垹闄わ紝璇疯仈绯荤郴缁熺鐞嗗憳"),
    TOKEN_PAST_DUE(4010002,"token 寮傚父,璇峰埛鏂皌oken"),
    NOT_PERMISSION(4030001,"娌℃湁鏉冮檺璁块棶璇ヨ祫婧�"),
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
