package com.sean.vo.resp;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class RolePageRespVO <T>{

	@ApiModelProperty("总记录数")
	private Long totalRows;
	
	@ApiModelProperty("总页数")
	private Integer totalPages;
	
	@ApiModelProperty("当前第几页")
	private Integer pageNum;
	
	@ApiModelProperty("每页记录数")
	private Integer pageSize;
	
	@ApiModelProperty("当前页记录数")
	private Integer curPageSize;
	
	@ApiModelProperty("数据列表")
	private List<T> list;

	public Long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Long totalRows) {
		this.totalRows = totalRows;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
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

	public Integer getCurPageSize() {
		return curPageSize;
	}

	public void setCurPageSize(Integer curPageSize) {
		this.curPageSize = curPageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
}
