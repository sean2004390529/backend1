package com.sean.utils;

import com.sean.exception.code.BaseResponseCode;
import com.sean.exception.code.ResponseCodeInterface;
import io.swagger.annotations.ApiModelProperty;

public class DataResult <T>{

    /**
     * 响应的状态码
     */
    @ApiModelProperty(value = "响应状态码")
    private int code;

    /**
     * 响应提示语
     */
    @ApiModelProperty(value = "响应提示语")
    private String msg;

    /**
     * 响应数据
     */
    @ApiModelProperty(value = "响应数据")
    private T data;
    
    public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	// 构造方法
    public DataResult(int code, T data) {
        this.code = code;
        this.data = data;
        this.msg=null;
    }

    public DataResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    
    public DataResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data=null;
    }


    /**
     * 静态方法
     */
    public static <T>DataResult getResult(int code,String msg,T data){
        return new <T>DataResult(code,msg,data);
    }

    public static <T>DataResult getResult(int code,String msg){
        return new <T>DataResult(code,msg);
    }

    
    // 构造方法 - 传入接口
    public DataResult(ResponseCodeInterface responseCodeInterface) {
        this.data = null;
        this.code = responseCodeInterface.getCode();
        this.msg = responseCodeInterface.getMsg();
    }

    public DataResult(ResponseCodeInterface responseCodeInterface, T data) {
        this.data = data;
        this.code = responseCodeInterface.getCode();
        this.msg = responseCodeInterface.getMsg();
    }
    
    // 静态方法 -- 传入接口实现
    public static <T>DataResult getResult(BaseResponseCode responseCode){
        return new <T>DataResult(responseCode);
    }

    public static <T>DataResult getResult(BaseResponseCode responseCode, T data){
        return new <T>DataResult(responseCode,data);
    }
    
    
    // 构造方法，通过BaseResponseCode中获取提示码 与 提示信息
    public DataResult() {
        this.code=BaseResponseCode.SUCCESS.getCode();
        this.msg=BaseResponseCode.SUCCESS.getMsg();
        this.data=null;
    }

    public DataResult(T data) {
        this.data = data;
        this.code=BaseResponseCode.SUCCESS.getCode();
        this.msg=BaseResponseCode.SUCCESS.getMsg();
    }
    
    
    // 静态方法
    public static <T>DataResult success(){
        return new <T>DataResult();
    }
    
    public static <T>DataResult success(T data){
        return new <T>DataResult(data);
    }


}
