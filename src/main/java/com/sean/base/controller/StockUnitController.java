package com.sean.base.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sean.base.entity.StockUnit;
import com.sean.service.StockUnitService;
import com.sean.utils.DataResult;
import com.sean.vo.req.StockUnitAddReqVO;
import com.sean.vo.req.StockUnitPageReqVO;
import com.sean.vo.req.StockUnitUpdateReqVO;
import com.sean.vo.resp.PageVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/stock/common")
@Api(tags="单位模块相关接口", description = "单位模块相关接口")
public class StockUnitController {

	@Autowired
	private StockUnitService stockUnitService;
	
	@PostMapping("/units")
    @ApiModelProperty("分页查询单位接口")
	public DataResult<PageVO<StockUnit>> pageInfo(@RequestBody StockUnitPageReqVO vo){
		DataResult result = DataResult.success();
		result.setData(stockUnitService.selectAll(vo));
		return result;
	}
	
	@GetMapping("/units/nopage")
	@ApiModelProperty("返回所有单位")
	public DataResult<StockUnit> selectAllNoPage(){
		DataResult result = DataResult.success();
		result.setData(stockUnitService.selectAllNoPage());
		return result;
	}
	
	
	@PostMapping("/unit")
	@ApiModelProperty("新增单位")
	public DataResult addUnit(@RequestBody @Valid StockUnitAddReqVO vo) {
		DataResult result = DataResult.success();
		stockUnitService.addStockUnit(vo);
		return result;
	}
	
	@PutMapping("/unit")
	@ApiModelProperty("更新单位")
	public DataResult updateUnit(@RequestBody @Valid StockUnitUpdateReqVO vo) {
		DataResult result = DataResult.success();
		stockUnitService.updateStockUnit(vo);
		return result;
	}
	
	@DeleteMapping("/unit")
	@ApiModelProperty("[批量]删除单位")
	public DataResult deleteUnit(@RequestBody @ApiParam("单位记录id集合") List<String> list) {
		stockUnitService.batchDeleteUnit(list);
		DataResult result = DataResult.success();
		return result;
	}
	
}
