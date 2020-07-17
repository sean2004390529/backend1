package com.sean.base.controller;

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

import com.sean.base.entity.StockReuse;
import com.sean.service.StockReuseSerivce;
import com.sean.utils.DataResult;
import com.sean.vo.req.StockReuseAddReqVO;
import com.sean.vo.req.StockReusePageReqVO;
import com.sean.vo.req.StockReuseUpdateReqVO;
import com.sean.vo.resp.PageVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/stock")
@Api(tags="使用品模块相关接口", description = "使用品模块相关接口")
public class StockReuseController {

	@Autowired
	private StockReuseSerivce stockReuseSerivce;
	
	@PostMapping("/reuse/list")
    @ApiModelProperty("分页查询使用品接口")
    public DataResult<PageVO<StockReuse>> pageInfo(@RequestBody StockReusePageReqVO vo){
		DataResult result = DataResult.success();
		result.setData(stockReuseSerivce.selectAll(vo));
		return result;
	}
	
	@GetMapping("/reuse/instock")
    @ApiModelProperty("查询在库可借用品")
    public DataResult<StockReuse> selectStockReuse(){
		DataResult result = DataResult.success();
		result.setData(stockReuseSerivce.selectStockReuse());
		return result;
	}
	
	@PostMapping("/reuse")
	@ApiModelProperty("新增使用品")
	public DataResult addReuse(@RequestBody @Valid StockReuseAddReqVO vo) {
		DataResult result = DataResult.success();
		stockReuseSerivce.addStockReuse(vo);
		return result;
	}
	
	@PutMapping("/reuse")
    @ApiModelProperty("修改使用品")
    public DataResult updateReuse(@RequestBody @Valid StockReuseUpdateReqVO vo) {
		DataResult result = DataResult.success();
		stockReuseSerivce.updateStockReuse(vo);
		return result;
	}
	
    @DeleteMapping("/reuse")
    @ApiModelProperty("[批量]删除修改使用品")
    public DataResult deleteUser(@RequestBody @ApiParam("使用品id集合") List<String> list, 
    		HttpServletRequest request) {
    	
    	// 获取当前操作人
    	// String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
    	// String userId = JwtTokenUtil.getUserId(accessToken);
    	
    	stockReuseSerivce.batchDeleteReuse(list);
    	DataResult result = DataResult.success();
    	return result;
    }
}
