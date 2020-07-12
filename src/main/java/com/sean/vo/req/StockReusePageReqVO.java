package com.sean.vo.req;

import io.swagger.annotations.ApiModelProperty;

public class StockReusePageReqVO {

	@ApiModelProperty("当前第几页")
	private Integer pageNum = 1;
	
	@ApiModelProperty("当前页数据条目数")
	private Integer pageSize = 10;
	
	@ApiModelProperty("物品名称")
	private String goodsname;
	
	@ApiModelProperty("购买目的")
	private String purpose;

	@ApiModelProperty("物品单位")
	private String unit;
	
	@ApiModelProperty("购买人ID")
	private String createId;
	
	@ApiModelProperty("可否复用")
	private Integer reuse;
	
	public Integer getReuse() {
		return reuse;
	}

	public void setReuse(Integer reuse) {
		this.reuse = reuse;
	}

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

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}
	
	
}
