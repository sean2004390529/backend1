package com.sean.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.sean.base.entity.StockDispo;
import com.sean.base.entity.StockPurchase;
import com.sean.base.entity.StockReuse;
import com.sean.base.mapper.StockDispoMapper;
import com.sean.base.mapper.StockPurchaseMapper;
import com.sean.base.mapper.StockReuseMapper;
import com.sean.exception.BusinessException;
import com.sean.exception.code.BaseResponseCode;
import com.sean.service.StockPurchaseService;
import com.sean.utils.PageUtil;
import com.sean.vo.req.StockPurchaseAddReqVO;
import com.sean.vo.req.StockPurchasePageReqVO;
import com.sean.vo.req.StockPurchaseUpdateReqVO;
import com.sean.vo.resp.PageVO;

@Service
public class StockPurchaseServiceImpl implements StockPurchaseService {

	@Autowired
	private StockPurchaseMapper stockPurchaseMapper;
	
	@Autowired
	private StockReuseMapper stockReuseMapper;
	
	@Autowired
	private StockDispoMapper stockDispoMapper;
	
	// 查询购买记录
	@Override
	public PageVO<StockPurchase> selectAll(StockPurchasePageReqVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<StockPurchase> all = stockPurchaseMapper.selectAll(vo);
		return PageUtil.getPageVO(all);
	}

	// 增加购买记录
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addStockPurchase(StockPurchaseAddReqVO vo) {
		StockPurchase stockPurchase = new StockPurchase();
		BeanUtils.copyProperties(vo, stockPurchase);
		stockPurchase.setCreateTime(new Date());
		int ret = stockPurchaseMapper.insertSelective(stockPurchase);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
		
		// 关联增加用户列表
		if(vo.getSave()) {
			if(vo.getReuse()==1) {
				StockReuse stockReuse = new StockReuse();
				BeanUtils.copyProperties(vo, stockReuse);
				stockReuse.setCreateTime(new Date());
				stockReuse.setIsBorrow(0);
				int ret2 = stockReuseMapper.insertSelective(stockReuse);
				if(ret2!=1) {
					throw new BusinessException(BaseResponseCode.DATA_ERROR);
				}
			}else if(vo.getReuse()==0) {
				StockDispo stockDispo = new StockDispo();
				BeanUtils.copyProperties(vo, stockDispo);
				stockDispo.setCreateTime(new Date());
				int ret3 = stockDispoMapper.insertSelective(stockDispo);
				if(ret3!=1) {
					throw new BusinessException(BaseResponseCode.DATA_ERROR);
				}
			}
		}
	}

	@Override
	public void updateStockPurchase(StockPurchaseUpdateReqVO vo) {
		StockPurchase stockPurchase = new StockPurchase();
		BeanUtils.copyProperties(vo, stockPurchase);
		stockPurchase.setUpdateTime(new Date());
		
		int ret = stockPurchaseMapper.updateByPrimaryKeySelective(stockPurchase);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
		}
		
	}

	@Override
	public void batchDeletePurchase(List<String> list) {
		int i = stockPurchaseMapper.batchDeletePurchase(list);
		if(i==0) {
			throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
		}
		
	}


	
	
	
}
