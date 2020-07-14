package com.sean.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sean.base.entity.StockDispense;
import com.sean.vo.req.StockDispensePageReqVO;

public interface StockDispenseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockDispense record);

    int insertSelective(StockDispense record);

    StockDispense selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StockDispense record);

    int updateByPrimaryKey(StockDispense record);
    
    // 查询所有派发记录
    List<StockDispense> selectAll(StockDispensePageReqVO vo);
    
    // 批量删除派发记录(list需要删除派发记录的id列表)
    int batchDeleteDispense(@Param("list") List<String> list);
    
}