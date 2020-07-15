package com.sean.vo.req;

import io.swagger.annotations.ApiModelProperty;

public class StockBorrowPageReqVO {

	@ApiModelProperty("当前第几页")
	private Integer pageNum = 1;
	
	@ApiModelProperty("当前页数据条目数")
	private Integer pageSize = 20;
	
	@ApiModelProperty("物品名称")
	private String goodsname;
	
	@ApiModelProperty("使用人ID")
	private Integer personId;

	@ApiModelProperty("借用目的")
	private String purpose;
	
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

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	

	
}
