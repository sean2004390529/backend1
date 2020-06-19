package com.sean.vo.req;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class TodoAddReqVO {

	@ApiModelProperty("todo内容")
	@NotBlank(message = "Todo不能为空")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
