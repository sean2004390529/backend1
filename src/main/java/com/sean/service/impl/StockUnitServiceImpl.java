package com.sean.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sean.base.entity.StockUnit;
import com.sean.base.mapper.StockUnitMapper;
import com.sean.exception.BusinessException;
import com.sean.exception.code.BaseResponseCode;
import com.sean.service.StockUnitService;
import com.sean.utils.PageUtil;
import com.sean.vo.req.StockUnitAddReqVO;
import com.sean.vo.req.StockUnitPageReqVO;
import com.sean.vo.req.StockUnitUpdateReqVO;
import com.sean.vo.resp.PageVO;

@Service
public class StockUnitServiceImpl implements StockUnitService {

	@Autowired
	private StockUnitMapper stockUnitMapper;
	
	// 查询单位
	@Override
	public PageVO<StockUnit> selectAll(StockUnitPageReqVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<StockUnit> all = stockUnitMapper.selectAll(vo);
		return PageUtil.getPageVO(all);
	}

	// 增加
	@Override
	public void addStockUnit(StockUnitAddReqVO vo) {
		StockUnit stockUnit = new StockUnit();
		BeanUtils.copyProperties(vo, stockUnit);
		int ret = stockUnitMapper.insertSelective(stockUnit);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
	}

	// 更新
	@Override
	public void updateStockUnit(StockUnitUpdateReqVO vo) {
		StockUnit stockUnit = new StockUnit();
		BeanUtils.copyProperties(vo, stockUnit);
		int ret = stockUnitMapper.updateByPrimaryKeySelective(stockUnit);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
	}

	// 批量删除单位
	@Override
	public void batchDeleteUnit(List<String> list) {
		int i = stockUnitMapper.batchDeleteUnit(list);
		if(i==0) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
	}

	@Override
	public List<StockUnit> selectAllNoPage() {
		return stockUnitMapper.selectAllNoPage();
	}

	
	
}
