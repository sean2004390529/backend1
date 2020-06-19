package com.sean.vo.req;

import io.swagger.annotations.ApiModelProperty;

public class TodoPageReqVO {

	@ApiModelProperty("第几页")
	private Integer pageNum = 1;

	@ApiModelProperty("当前页的数量")
	private Integer pageSize = 10;
	
	@ApiModelProperty("角色描述")
	private String description;
	
	@ApiModelProperty("结果")
    private String result;
	
	@ApiModelProperty("状态(1:启用, 2:禁用)")
	private Integer Status;

	@ApiModelProperty("紧急度(2:优先处理,1:紧急,0:一般禁用)")
    private Integer urgent;
    
	@ApiModelProperty("公开(1:公开,0:非公开)")
    private Integer isPublic;
	
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getUrgent() {
		return urgent;
	}

	public void setUrgent(Integer urgent) {
		this.urgent = urgent;
	}

	public Integer getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Integer isPublic) {
		this.isPublic = isPublic;
	}

	@Override
	public String toString() {
		return "TodoPageReqVO [pageNum=" + pageNum + ", pageSize=" + pageSize + ", description=" + description
				+ ", result=" + result + ", Status=" + Status + ", urgent=" + urgent + ", isPublic=" + isPublic
				+ ", getPageNum()=" + getPageNum() + ", getPageSize()=" + getPageSize() + ", getDescription()="
				+ getDescription() + ", getStatus()=" + getStatus() + ", getResult()=" + getResult() + ", getUrgent()="
				+ getUrgent() + ", getIsPublic()=" + getIsPublic() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
