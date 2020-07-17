package com.sean.vo.req;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class StockUnitAddReqVO {

	@ApiModelProperty("单位")
	@NotBlank(message = "单位不能为空")
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

}
