package com.sean.service;

import java.util.List;

import com.sean.base.entity.StockPurchase;
import com.sean.vo.req.StockPurchaseAddReqVO;
import com.sean.vo.req.StockPurchasePageReqVO;
import com.sean.vo.req.StockPurchaseUpdateReqVO;
import com.sean.vo.resp.PageVO;

public interface StockPurchaseService {

	// 查询所有购买记录
	PageVO<StockPurchase> selectAll(StockPurchasePageReqVO vo);
	
	// 增加查询记录
	void addStockPurchase(StockPurchaseAddReqVO vo);
	
	// 更新购买记录
	void updateStockPurchase(StockPurchaseUpdateReqVO vo);
	
	// 批量删除购买记录(list需要删购买记录id列表)
	void batchDeletePurchase(List<String> list);
}
