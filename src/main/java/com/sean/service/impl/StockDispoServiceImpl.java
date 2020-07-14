package com.sean.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sean.base.entity.StockDispo;
import com.sean.base.mapper.StockDispoMapper;
import com.sean.exception.BusinessException;
import com.sean.exception.code.BaseResponseCode;
import com.sean.service.StockDispoSerivce;
import com.sean.utils.PageUtil;
import com.sean.vo.req.StockDispoAddReqVO;
import com.sean.vo.req.StockDispoPageReqVO;
import com.sean.vo.req.StockDispoUpdateReqVO;
import com.sean.vo.resp.PageVO;

@Service
public class StockDispoServiceImpl implements StockDispoSerivce{

	@Autowired
	private StockDispoMapper stockDispoMapper;
	
	@Override
	public PageVO<StockDispo> selectAll(StockDispoPageReqVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<StockDispo> all = stockDispoMapper.selectAll(vo);
		return PageUtil.getPageVO(all);
	}

	@Override
	public void addStockDispo(StockDispoAddReqVO vo) {
		StockDispo stockDispo = new StockDispo();
		BeanUtils.copyProperties(vo, stockDispo);
		int ret = stockDispoMapper.insertSelective(stockDispo);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
	}

	@Override
	public void updateStockDispo(StockDispoUpdateReqVO vo) {
		StockDispo stockDispo = new StockDispo();
		BeanUtils.copyProperties(vo, stockDispo);
		stockDispo.setUpdateTime(new Date());
		
		int ret = stockDispoMapper.updateByPrimaryKeySelective(stockDispo);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
		}
	}

	@Override
	public void batchDeleteDispo(List<String> list) {
		int i = stockDispoMapper.batchDeleteDispo(list);
		if(i==0) {
			throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
		}
	}

	
}
