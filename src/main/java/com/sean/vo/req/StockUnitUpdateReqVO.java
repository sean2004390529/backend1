package com.sean.vo.req;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class StockUnitUpdateReqVO {

	@ApiModelProperty("用户ID")
	@NotNull(message = "ID不能为空")
	private Integer id;
	
	@ApiModelProperty("单位")
	@NotBlank(message = "单位不能为空")
	private String value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

	

}
