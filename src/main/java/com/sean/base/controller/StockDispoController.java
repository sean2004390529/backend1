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

import com.sean.base.entity.StockDispo;
import com.sean.service.StockDispoSerivce;
import com.sean.utils.DataResult;
import com.sean.vo.req.StockDispoAddReqVO;
import com.sean.vo.req.StockDispoPageReqVO;
import com.sean.vo.req.StockDispoUpdateReqVO;
import com.sean.vo.resp.PageVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/stock")
@Api(tags="一次性用品模块相关接口", description = "一次性用品模块相关接口")
public class StockDispoController {

	@Autowired
	private StockDispoSerivce stockDispoSerivce;
	
	@PostMapping("/dispo/list")
    @ApiModelProperty("分页查询一次性用品接口")
    public DataResult<PageVO<StockDispo>> pageInfo(@RequestBody StockDispoPageReqVO vo){
		DataResult result = DataResult.success();
		result.setData(stockDispoSerivce.selectAll(vo));
		return result;
	}
	
	@PostMapping("/dispo")
	@ApiModelProperty("新增一次性用品")
	public DataResult addDispo(@RequestBody @Valid StockDispoAddReqVO vo) {
		DataResult result = DataResult.success();
		stockDispoSerivce.addStockDispo(vo);
		return result;
	}
	
	@PutMapping("/dispo")
    @ApiModelProperty("修改一次性用品")
    public DataResult updateDispo(@RequestBody @Valid StockDispoUpdateReqVO vo) {
		DataResult result = DataResult.success();
		stockDispoSerivce.updateStockDispo(vo);
		return result;
	}
	
    @DeleteMapping("/dispo")
    @ApiModelProperty("[批量]删除修改使用品")
    public DataResult deleteDispo(@RequestBody @ApiParam("使用品id集合") List<String> list, 
    		HttpServletRequest request) {
    	
    	// 获取当前操作人
    	// String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
    	// String userId = JwtTokenUtil.getUserId(accessToken);
    	
    	stockDispoSerivce.batchDeleteDispo(list);
    	DataResult result = DataResult.success();
    	return result;
    }
}
