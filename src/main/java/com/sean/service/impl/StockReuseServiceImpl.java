package com.sean.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sean.base.entity.StockReuse;
import com.sean.base.mapper.StockReuseMapper;
import com.sean.exception.BusinessException;
import com.sean.exception.code.BaseResponseCode;
import com.sean.service.StockReuseSerivce;
import com.sean.utils.PageUtil;
import com.sean.vo.req.StockReuseAddReqVO;
import com.sean.vo.req.StockReusePageReqVO;
import com.sean.vo.req.StockReuseUpdateReqVO;
import com.sean.vo.resp.PageVO;

@Service
public class StockReuseServiceImpl implements StockReuseSerivce{

	@Autowired
	private StockReuseMapper stockReuseMapper;
	
	@Override
	public PageVO<StockReuse> selectAll(StockReusePageReqVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<StockReuse> all = stockReuseMapper.selectAll(vo);
		return PageUtil.getPageVO(all);
	}

	@Override
	public void addStockReuse(StockReuseAddReqVO vo) {
		StockReuse stockReuse = new StockReuse();
		BeanUtils.copyProperties(vo, stockReuse);
		int ret = stockReuseMapper.insertSelective(stockReuse);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
	}

	@Override
	public void updateStockReuse(StockReuseUpdateReqVO vo) {
		StockReuse stockReuse = new StockReuse();
		BeanUtils.copyProperties(vo, stockReuse);
		stockReuse.setUpdateTime(new Date());
		
		int ret = stockReuseMapper.updateByPrimaryKeySelective(stockReuse);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
		}
	}

	@Override
	public void batchDeleteReuse(List<String> list) {
		int i = stockReuseMapper.batchDeleteReuse(list);
		if(i==0) {
			throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
		}
	}

	@Override
	public List<StockReuse> selectStockReuse() {
		return stockReuseMapper.selectStockReuse();
	}

	
}
