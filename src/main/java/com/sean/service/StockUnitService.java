package com.sean.service;

import java.util.List;

import com.sean.base.entity.StockUnit;
import com.sean.vo.req.StockUnitAddReqVO;
import com.sean.vo.req.StockUnitPageReqVO;
import com.sean.vo.req.StockUnitUpdateReqVO;
import com.sean.vo.resp.PageVO;

public interface StockUnitService {

	// 查询所有
	PageVO<StockUnit> selectAll(StockUnitPageReqVO vo);
	
	// 查询所有
	List<StockUnit> selectAllNoPage();
	
	// 增加
	void addStockUnit(StockUnitAddReqVO vo);
	
	// 更新
	void updateStockUnit(StockUnitUpdateReqVO vo);
	
	// 批量删除(list需要删除id列表)
	void batchDeleteUnit(List<String> list);

	
	
}
