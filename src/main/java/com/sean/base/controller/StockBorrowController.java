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

import com.sean.base.entity.StockBorrow;
import com.sean.service.StockBorrowService;
import com.sean.utils.DataResult;
import com.sean.vo.req.StockBorrowAddReqVO;
import com.sean.vo.req.StockBorrowPageReqVO;
import com.sean.vo.req.StockBorrowUpdateReqVO;
import com.sean.vo.resp.PageVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/stock")
@Api(tags="借用记录模块相关接口", description = "借用记录模块相关接口")
public class StockBorrowController {

	@Autowired
	private StockBorrowService stockBorrowService;
	
	@PostMapping("/borrow/list")
    @ApiModelProperty("分页查询借出记录接口")
	public DataResult<PageVO<StockBorrow>> pageInfo(@RequestBody StockBorrowPageReqVO vo){
		DataResult result = DataResult.success();
		result.setData(stockBorrowService.selectAll(vo));
		return result;
	}
	
	@PostMapping("/borrow")
	@ApiModelProperty("新增借出记录")
	public DataResult addBorrow(@RequestBody @Valid StockBorrowAddReqVO vo) {
		DataResult result = DataResult.success();
		stockBorrowService.addStockBorrow(vo);
		return result;
	}
	
	@PutMapping("/borrow")
	@ApiModelProperty("更新借出记录")
	public DataResult updateBorrow(@RequestBody @Valid StockBorrowUpdateReqVO vo) {
		DataResult result = DataResult.success();
		stockBorrowService.updateStockBorrow(vo);
		return result;
	}
	
	@DeleteMapping("/borrow")
    @ApiModelProperty("[批量]删除借出记录")
	public DataResult deleteBorrow(@RequestBody @ApiParam("借出记录id集合") List<String> list, 
    		HttpServletRequest request) {
    	// 获取当前操作人
    	// String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
    	// String userId = JwtTokenUtil.getUserId(accessToken);
		
		stockBorrowService.batchDeleteBorrow(list);
    	DataResult result = DataResult.success();
    	return result;
	}
	
	@GetMapping("/borrow/unreturn")
	@ApiModelProperty("查出所有未归还")
	public DataResult selectUnreturn() {
		DataResult result = DataResult.success();
		result.setData(stockBorrowService.selectUnreturn());
		return result;
	}
}
