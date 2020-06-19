package com.sean.vo.req;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class TodoUpdateReqVO {

	@ApiModelProperty("Todo ID")
	@NotBlank(message = "id不能为空")
	private String id;
	
	@ApiModelProperty("Todo内容")
	@NotBlank(message = "Todo内容不能为空")
    private String description;

	@ApiModelProperty("结果")
    private String result;

	@ApiModelProperty("状态(1:启用,0:禁用)")
    private Integer status;

	@ApiModelProperty("紧急度(2:优先处理,1:紧急,0:一般禁用)")
    private Integer urgent;
    
	@ApiModelProperty("公开(1:公开,0:非公开)")
    private Integer isPublic;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
    
}
