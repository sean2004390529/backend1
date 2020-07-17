package com.sean.base.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sean.base.entity.StockPurchase;
import com.sean.service.StockPurchaseService;
import com.sean.utils.DataResult;
import com.sean.vo.req.StockPurchaseAddReqVO;
import com.sean.vo.req.StockPurchasePageReqVO;
import com.sean.vo.req.StockPurchaseUpdateReqVO;
import com.sean.vo.resp.PageVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/stock")
@Api(tags="购买记录模块相关接口", description = "购买记录模块相关接口")
public class StockPurchaseController {

	@Autowired
	private StockPurchaseService stockPurchaseService;
	
	@PostMapping("/purchase/list")
    @ApiModelProperty("分页查询购买记录接口")
    public DataResult<PageVO<StockPurchase>> pageInfo(@RequestBody StockPurchasePageReqVO vo){
		DataResult result = DataResult.success();
		result.setData(stockPurchaseService.selectAll(vo));
		return result;
	}
	
	@PostMapping("/purchase")
	@ApiModelProperty("新增购买记录")
	public DataResult addPurchase(@RequestBody @Valid StockPurchaseAddReqVO vo) {
		DataResult result = DataResult.success();
		stockPurchaseService.addStockPurchase(vo);
		return result;
	}
	
	@PutMapping("/purchase")
    @ApiModelProperty("修改购买记录")
    public DataResult updatePurchase(@RequestBody @Valid StockPurchaseUpdateReqVO vo) {
		DataResult result = DataResult.success();
		stockPurchaseService.updateStockPurchase(vo);
		return result;
	}
	
    @DeleteMapping("/purchase")
    @ApiModelProperty("[批量]删除购买记录")
    public DataResult deleteUser(@RequestBody @ApiParam("购买记录id集合") List<String> list, 
    		HttpServletRequest request) {
    	// 获取当前操作人
    	// String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
    	// String userId = JwtTokenUtil.getUserId(accessToken);
    	
    	stockPurchaseService.batchDeletePurchase(list);
    	DataResult result = DataResult.success();
    	return result;
    }
    
//    @GetMapping("/unit")
//    @ApiModelProperty("获取单位列表")
//    public DataResult fetchUnit() {
//    	List<String> unitList = Arrays.asList("套","件","支");
//    	
//    	DataResult result = DataResult.success();
//    	result.setData(unitList);
//    	return result;
//    }
	
}
