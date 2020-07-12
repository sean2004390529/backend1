package com.sean.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sean.base.entity.StockStaff;
import com.sean.base.mapper.StockStaffMapper;
import com.sean.exception.BusinessException;
import com.sean.exception.code.BaseResponseCode;
import com.sean.service.StockStaffService;
import com.sean.utils.PageUtil;
import com.sean.vo.req.StockStaffAddReqVO;
import com.sean.vo.req.StockStaffPageReqVO;
import com.sean.vo.req.StockStaffUpdateReqVO;
import com.sean.vo.resp.PageVO;

@Service
public class StockStaffServiceImpl implements StockStaffService {

	@Autowired
	private StockStaffMapper stockStaffMapper;
	
	// 查询所有员工
	@Override
	public PageVO<StockStaff> selectAll(StockStaffPageReqVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<StockStaff> allStafflist = stockStaffMapper.selectAll(vo);
		return PageUtil.getPageVO(allStafflist);
	}

	@Override
	public void addStaff(StockStaffAddReqVO vo) {
		StockStaff stockStaff = new StockStaff();
		BeanUtils.copyProperties(vo, stockStaff);
		stockStaff.setCreateTime(new Date());
		int ret = stockStaffMapper.insertSelective(stockStaff);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
	}

	@Override
	public void updateStaff(StockStaffUpdateReqVO vo) {
		StockStaff stockStaff = new StockStaff();
		BeanUtils.copyProperties(vo, stockStaff);
		stockStaff.setUpdateTime(new Date());
		
		int ret = stockStaffMapper.updateByPrimaryKeySelective(stockStaff);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
		}
	}

	@Override
	public void batchDeleteStaff(List<String> list) {
		int i = stockStaffMapper.batchDeleteUser(list);
		if(i==0) {
			throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
		}
	}

	@Override
	public List<StockStaff> selectAllNoPage() {
		return stockStaffMapper.selectAllNoPage();
	}

}
