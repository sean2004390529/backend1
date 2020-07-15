package com.sean.vo.req;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class StockDispoAddReqVO {

	@ApiModelProperty("物品名称")
	@NotBlank(message = "物品名称不能为空")
	private String goodsname;
	
	@ApiModelProperty("物品数量")
	@NotNull(message = "物品数量不能为空")
	private Integer number;

	@ApiModelProperty("购买日期")
	private Date createTime;
	
	@ApiModelProperty("可否复用")
    private Integer reuse;
	
	@ApiModelProperty("使用人ID")
    private Integer personId;
	

	@ApiModelProperty("单位")
	private String unit;
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	
	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getReuse() {
		return reuse;
	}

	public void setReuse(Integer reuse) {
		this.reuse = reuse;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	
}
