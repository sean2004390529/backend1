package com.sean.vo.req;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class StockBorrowAddReqVO {

	@ApiModelProperty("物品名称")
	@NotBlank(message = "物品名称不能为空")
	private String goodsname;
	
	@ApiModelProperty("物品数量")
	private Integer number;
	
	@ApiModelProperty("借用目的")
	private String purpose;
	
	@ApiModelProperty("借用人")
	@NotNull(message = "借用人不能为空")
	private Integer personId;

	@ApiModelProperty("开始借用日期")
	private Date borrowDate;
	
	@ApiModelProperty("预计归还日期")
	private Date expectReturn;
	
	@ApiModelProperty("实际归还日期")
	private Date actualReturn;
	
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

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getExpectReturn() {
		return expectReturn;
	}

	public void setExpectReturn(Date expectReturn) {
		this.expectReturn = expectReturn;
	}

	public Date getActualReturn() {
		return actualReturn;
	}

	public void setActualReturn(Date actualReturn) {
		this.actualReturn = actualReturn;
	}
	
}
