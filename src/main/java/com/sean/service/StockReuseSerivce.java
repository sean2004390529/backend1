package com.sean.service;

import java.util.List;

import com.sean.base.entity.StockReuse;
import com.sean.vo.req.StockReuseAddReqVO;
import com.sean.vo.req.StockReusePageReqVO;
import com.sean.vo.req.StockReuseUpdateReqVO;
import com.sean.vo.resp.PageVO;

public interface StockReuseSerivce {

	// 查询所有借用品
	PageVO<StockReuse> selectAll(StockReusePageReqVO vo);
	
	// 增加借用品
	void addStockReuse(StockReuseAddReqVO vo);
    
    // 更新使用品
    void updateStockReuse(StockReuseUpdateReqVO vo);
    
	// 批量删除使用品(list需要删使用品id列表)
	void batchDeleteReuse(List<String> list);
}
