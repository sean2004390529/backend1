package com.sean.vo.req;

import io.swagger.annotations.ApiModelProperty;

public class RolePageReqVO {

	@ApiModelProperty("第几页")
	private Integer pageNum = 1;

	@ApiModelProperty("当前页的数量")
	private Integer pageSize = 10;
	
	@ApiModelProperty("角色名字")
	private String name;
	
	@ApiModelProperty("角色描述")
	private String description;
	
	@ApiModelProperty("状态(1:启用, 2:禁用)")
	private Integer Status;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return Status;
	}

	public void setStatus(Integer status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "RolePageReqVO [pageNum=" + pageNum + ", pageSize=" + pageSize + ", name=" + name + ", description="
				+ description + ", Status=" + Status + ", getPageNum()=" + getPageNum() + ", getPageSize()="
				+ getPageSize() + ", getName()=" + getName() + ", getDescription()=" + getDescription()
				+ ", getStatus()=" + getStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
}
