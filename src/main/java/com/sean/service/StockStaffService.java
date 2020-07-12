package com.sean.service;

import java.util.List;

import com.sean.base.entity.StockStaff;
import com.sean.vo.req.StockStaffAddReqVO;
import com.sean.vo.req.StockStaffPageReqVO;
import com.sean.vo.req.StockStaffUpdateReqVO;
import com.sean.vo.resp.PageVO;

public interface StockStaffService {

	// 查询所有员工
	PageVO<StockStaff> selectAll(StockStaffPageReqVO vo);
	
	// 查询所有员工--不分页，只查id, staffname
	List<StockStaff> selectAllNoPage();
	
	// 增加员工
	void addStaff(StockStaffAddReqVO vo);
	
	// 更新员工
	void updateStaff(StockStaffUpdateReqVO vo);
	
    // 批量删除员工(list需要删除员工的id列表)
    void batchDeleteStaff(List<String> list);
    
}
