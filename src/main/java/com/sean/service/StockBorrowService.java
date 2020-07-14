package com.sean.service;

import java.util.List;

import com.sean.base.entity.StockBorrow;
import com.sean.vo.req.StockBorrowAddReqVO;
import com.sean.vo.req.StockBorrowPageReqVO;
import com.sean.vo.req.StockBorrowUpdateReqVO;
import com.sean.vo.resp.PageVO;

public interface StockBorrowService {

	// 查询所有借出记录
	PageVO<StockBorrow> selectAll(StockBorrowPageReqVO vo);
	
	// 增加借出记录
	void addStockBorrow(StockBorrowAddReqVO vo);
	
	// 更新借出记录
	void updateStockBorrow(StockBorrowUpdateReqVO vo);
	
	// 批量删除借出记录(list需要删除借出记录id列表)
	void batchDeleteBorrow(List<String> list);
	
	// 查出所有未归还
	List<StockBorrow> selectUnreturn();
}
