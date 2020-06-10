package com.sean.vo.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;


public class TestReqVO {
	
	@NotEmpty(message = "数据不能为空")
	private List<String> list;
	
	@NotBlank(message = "用户名不能为空")
	@ApiModelProperty(value = "用户名")
	private String username;
	
	@NotNull(message = "年龄不能为空")
	@ApiModelProperty(value = "年龄")
	private Integer age;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
}
