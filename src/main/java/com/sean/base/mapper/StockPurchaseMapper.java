package com.sean.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sean.base.entity.StockPurchase;
import com.sean.vo.req.StockPurchasePageReqVO;

public interface StockPurchaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockPurchase record);

    int insertSelective(StockPurchase record);

    StockPurchase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StockPurchase record);

    int updateByPrimaryKey(StockPurchase record);
    
    // 查询所有购买记录（可带查询条件）
    List<StockPurchase> selectAll(StockPurchasePageReqVO vo);
    
    // 批量删除购买记录(list需要删除购买记录的id列表)
    int batchDeletePurchase(@Param("list") List<String> list);
}