package com.sean.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sean.base.entity.StockBorrow;
import com.sean.base.mapper.StockBorrowMapper;
import com.sean.exception.BusinessException;
import com.sean.exception.code.BaseResponseCode;
import com.sean.service.StockBorrowService;
import com.sean.utils.PageUtil;
import com.sean.vo.req.StockBorrowAddReqVO;
import com.sean.vo.req.StockBorrowPageReqVO;
import com.sean.vo.req.StockBorrowUpdateReqVO;
import com.sean.vo.resp.PageVO;

@Service
public class StockBorrowServiceImpl implements StockBorrowService{

	@Autowired
	private StockBorrowMapper stockBorrowMapper;
	
	// 查询借出记录
	@Override
	public PageVO<StockBorrow> selectAll(StockBorrowPageReqVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<StockBorrow> all = stockBorrowMapper.selectAll(vo);
		return PageUtil.getPageVO(all);
	}

	// 增加借出记录
	@Override
	public void addStockBorrow(StockBorrowAddReqVO vo) {
		StockBorrow stockBorrow = new StockBorrow();
		BeanUtils.copyProperties(vo, stockBorrow);
		stockBorrow.setCreateTime(new Date());
		int ret = stockBorrowMapper.insertSelective(stockBorrow);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
	}

	// 更新借出记录
	@Override
	public void updateStockBorrow(StockBorrowUpdateReqVO vo) {
		StockBorrow stockBorrow = new StockBorrow();
		BeanUtils.copyProperties(vo, stockBorrow);
		stockBorrow.setUpdateTime(new Date());
		int ret = stockBorrowMapper.updateByPrimaryKeySelective(stockBorrow);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
		}

	}

	// [批量]删除借出记录
	@Override
	public void batchDeleteBorrow(List<String> list) {
		int i = stockBorrowMapper.batchDeleteBorrow(list);
		if(i==0) {
			throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
		}
	}

	@Override
	public List<StockBorrow> selectUnreturn() {
		return stockBorrowMapper.selectUnreturn();
	}

	
}
