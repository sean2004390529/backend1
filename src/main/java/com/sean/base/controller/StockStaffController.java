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

import com.sean.base.entity.StockStaff;
import com.sean.service.StockStaffService;
import com.sean.utils.DataResult;
import com.sean.vo.req.StockStaffAddReqVO;
import com.sean.vo.req.StockStaffPageReqVO;
import com.sean.vo.req.StockStaffUpdateReqVO;
import com.sean.vo.resp.PageVO;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/stock")
public class StockStaffController {

	@Autowired
	private StockStaffService stockStaffService;
	
	@PostMapping("/staff/list")
    @ApiModelProperty("分页查询员工接口")
	public DataResult<PageVO<StockStaff>> pageInfo(@RequestBody StockStaffPageReqVO vo){
		DataResult result = DataResult.success();
		result.setData(stockStaffService.selectAll(vo));
		return result;
	}
	
	@GetMapping("/staff/nopage")
    @ApiModelProperty("查询员工id,staffname")
	public DataResult<StockStaff> selectAllNoPage(){
		DataResult result = DataResult.success();
		result.setData(stockStaffService.selectAllNoPage());
		return result;
	}
	
    @PostMapping("/staff")
    @ApiModelProperty("新增员工")
    public DataResult addStaff(@RequestBody @Valid StockStaffAddReqVO vo) {
    	DataResult result = DataResult.success();
    	stockStaffService.addStaff(vo);
    	return result;
    }
    
    @PutMapping("/staff")
    @ApiModelProperty("修改员工信息")
    public DataResult updateStaff(@RequestBody @Valid StockStaffUpdateReqVO vo) {
    	System.out.println(vo);
    	DataResult result = DataResult.success();
    	stockStaffService.updateStaff(vo);
    	return result;
    }
    
    @DeleteMapping("/staff")
    @ApiModelProperty("[批量]删除员工")
    public DataResult deleteUser(@RequestBody @ApiParam("员工id集合") List<String> list, 
    		HttpServletRequest request) {
    	stockStaffService.batchDeleteStaff(list);
    	DataResult result = DataResult.success();
    	return result;
    }
}
