package com.sean.vo.req;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class StockPurchaseUpdateReqVO {

	@ApiModelProperty("用户ID")
	@NotNull(message = "ID不能为空")
	private Integer id;
	
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

	@ApiModelProperty("购买日期")
	private Date createTime;
	
	@ApiModelProperty("是否可复用(1可复用；0一次性使用")
    private Integer reuse;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "StockPurchaseUpdateReqVO [id=" + id + ", goodsname=" + goodsname + ", number=" + number + ", amount="
				+ amount + ", purpose=" + purpose + ", createTime=" + createTime + ", reuse=" + reuse + "]";
	}

	
}
