package com.sean.vo.req;

import io.swagger.annotations.ApiModelProperty;

public class StockUnitPageReqVO {

	@ApiModelProperty("当前第几页")
	private Integer pageNum = 1;
	
	@ApiModelProperty("当前页数据条目数")
	private Integer pageSize = 20;
	
	@ApiModelProperty("单位")
	private String value;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
