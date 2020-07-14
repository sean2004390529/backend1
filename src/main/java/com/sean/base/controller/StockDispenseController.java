package com.sean.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sean.base.entity.StockDispense;
import com.sean.service.StockDispenseService;
import com.sean.utils.DataResult;
import com.sean.vo.req.StockDispenseAddReqVO;
import com.sean.vo.req.StockDispensePageReqVO;
import com.sean.vo.req.StockDispenseUpdateReqVO;
import com.sean.vo.resp.PageVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/stock")
@Api(tags="派发记录模块相关接口", description = "派发记录模块相关接口")
public class StockDispenseController {

	@Autowired
	private StockDispenseService stockDispenseService;
	
	@PostMapping("/dispense/list")
    @ApiModelProperty("分页查询派发记录接口")
	public DataResult<PageVO<StockDispense>> pageInfo(@RequestBody StockDispensePageReqVO vo){
		DataResult result = DataResult.success();
		result.setData(stockDispenseService.selectAll(vo));
		return result;
	}
	
	@PostMapping("/dispense")
	@ApiModelProperty("新增派发记录")
	public DataResult addDispense(@RequestBody @Valid StockDispenseAddReqVO vo) {
		DataResult result = DataResult.success();
		stockDispenseService.addStockDispense(vo);
		return result;
	}
	
	@PutMapping("/dispense")
	@ApiModelProperty("更新派发记录")
	public DataResult updateDispense(@RequestBody @Valid StockDispenseUpdateReqVO vo) {
		DataResult result = DataResult.success();
		stockDispenseService.updateStockDispense(vo);
		return result;
	}
	
	@DeleteMapping("/dispense")
    @ApiModelProperty("[批量]删除派发记录")
	public DataResult deleteDispense(@RequestBody @ApiParam("派发记录id集合") List<String> list, 
    		HttpServletRequest request) {
    	// 获取当前操作人
    	// String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
    	// String userId = JwtTokenUtil.getUserId(accessToken);
	
		stockDispenseService.batchDeleteDispense(list);
    	DataResult result = DataResult.success();
    	return result;
	}
}
