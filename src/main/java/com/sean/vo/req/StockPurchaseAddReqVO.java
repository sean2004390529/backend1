package com.sean.vo.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class StockPurchaseAddReqVO {

	@ApiModelProperty("物品名称")
	@NotBlank(message = "物品名称不能为空")
	private String goodsname;
	
	@ApiModelProperty("物品数量")
	@NotNull(message = "物品数量不能为空")
	private Integer number;
	
	@ApiModelProperty("总金额物品数量")
	private Double amount;
	
	@ApiModelProperty("购买目的")
	private String purpose;
	
	@ApiModelProperty("是否可复用(1可复用；0一次性使用)")
    private Integer reuse;
	
	@ApiModelProperty("单位")
	private String unit;
	
	@ApiModelProperty("是否保存到用品列表")
	private Boolean save;
	
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Integer getReuse() {
		return reuse;
	}

	public void setReuse(Integer reuse) {
		this.reuse = reuse;
	}

	public Boolean getSave() {
		return save;
	}

	public void setSave(Boolean save) {
		this.save = save;
	}

	@Override
	public String toString() {
		return "StockPurchaseAddReqVO [goodsname=" + goodsname + ", number=" + number + ", amount=" + amount
				+ ", purpose=" + purpose + ", reuse=" + reuse + ", unit=" + unit + ", save=" + save + "]";
	}
	
	
	
}
