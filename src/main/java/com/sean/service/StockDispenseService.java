package com.sean.service;

import java.util.List;

import com.sean.base.entity.StockDispense;
import com.sean.vo.req.StockDispenseAddReqVO;
import com.sean.vo.req.StockDispensePageReqVO;
import com.sean.vo.req.StockDispenseUpdateReqVO;
import com.sean.vo.resp.PageVO;

public interface StockDispenseService {

	// 查询所有派发记录
	PageVO<StockDispense> selectAll(StockDispensePageReqVO vo);
	
	// 增加派发记录
	void addStockDispense(StockDispenseAddReqVO vo);
	
	// 更新派发记录
	void updateStockDispense(StockDispenseUpdateReqVO vo);
	
	// 批量删除派发记录（list需要删除派发记录id列表）
	void batchDeleteDispense(List<String> list);
	
}
