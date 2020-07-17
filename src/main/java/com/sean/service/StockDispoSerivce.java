package com.sean.service;

import java.util.List;

import com.sean.base.entity.StockDispo;
import com.sean.vo.req.StockDispoAddReqVO;
import com.sean.vo.req.StockDispoPageReqVO;
import com.sean.vo.req.StockDispoUpdateReqVO;
import com.sean.vo.resp.PageVO;

public interface StockDispoSerivce {

	// 查询所有一次性用品
	PageVO<StockDispo> selectAll(StockDispoPageReqVO vo);
	
	// 查询在库一次性用品（不分页）
	List<StockDispo> selectStockDispo();
	
	// 增加一次性用品
	void addStockDispo(StockDispoAddReqVO vo);
    
    // 更新一次性用品
    void updateStockDispo(StockDispoUpdateReqVO vo);
    
	// 批量删除一次性用品(list需要删使用品id列表)
	void batchDeleteDispo(List<String> list);
}
