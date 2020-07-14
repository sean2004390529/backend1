package com.sean.vo.req;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class StockDispoUpdateReqVO {

	@ApiModelProperty("用户ID")
	@NotNull(message = "ID不能为空")
	private Integer id;
	
	@ApiModelProperty("物品名称")
	@NotBlank(message = "物品名称不能为空")
	private String goodsname;
	
	@ApiModelProperty("物品数量")
	@NotNull(message = "物品数量不能为空")
	private Integer number;

	@ApiModelProperty("购买日期")
	private Date createTime;
	
	@ApiModelProperty("是否可复用(1可复用；0一次性使用)")
    private Integer reuse;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}
