package com.sean.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sean.base.entity.StockBorrow;
import com.sean.vo.req.StockBorrowPageReqVO;

public interface StockBorrowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockBorrow record);

    int insertSelective(StockBorrow record);

    StockBorrow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StockBorrow record);

    int updateByPrimaryKey(StockBorrow record);
    
    // 查询所有借出记录
    List<StockBorrow> selectAll(StockBorrowPageReqVO vo);
    
    // 批量删除借出记录(list需要删除借出记录的id列表)
    int batchDeleteBorrow(@Param("list") List<String> list);
    
    // 查询所有未归还记录
    List<StockBorrow> selectUnreturn();
}