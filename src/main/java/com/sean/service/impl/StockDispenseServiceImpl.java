package com.sean.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sean.base.entity.StockDispense;
import com.sean.base.mapper.StockDispenseMapper;
import com.sean.exception.BusinessException;
import com.sean.exception.code.BaseResponseCode;
import com.sean.service.StockDispenseService;
import com.sean.utils.PageUtil;
import com.sean.vo.req.StockDispenseAddReqVO;
import com.sean.vo.req.StockDispensePageReqVO;
import com.sean.vo.req.StockDispenseUpdateReqVO;
import com.sean.vo.resp.PageVO;

@Service
public class StockDispenseServiceImpl implements StockDispenseService{

	@Autowired
	private StockDispenseMapper stockDispenseMapper;
	
	// 查询所有派发记录
	@Override
	public PageVO<StockDispense> selectAll(StockDispensePageReqVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<StockDispense> all = stockDispenseMapper.selectAll(vo);
		return PageUtil.getPageVO(all);
	}

	// 增加派发记录
	@Override
	public void addStockDispense(StockDispenseAddReqVO vo) {
		StockDispense stockDispense = new StockDispense();
		BeanUtils.copyProperties(vo, stockDispense);
		stockDispense.setCreateTime(new Date());
		int ret = stockDispenseMapper.insertSelective(stockDispense);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
	}

	// 更新派发记录
	@Override
	public void updateStockDispense(StockDispenseUpdateReqVO vo) {
		StockDispense stockDispense = new StockDispense();
		BeanUtils.copyProperties(vo, stockDispense);
		stockDispense.setUpdateTime(new Date());
		int ret = stockDispenseMapper.updateByPrimaryKeySelective(stockDispense);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
		}
		
	}

	// [批量]删除派发记录
	@Override
	public void batchDeleteDispense(List<String> list) {
		int i = stockDispenseMapper.batchDeleteDispense(list);
		if(i==0) {
			throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
		}
	}


}
