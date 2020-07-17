package com.sean.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sean.base.entity.StockDispo;
import com.sean.vo.req.StockDispoAddReqVO;
import com.sean.vo.req.StockDispoPageReqVO;

public interface StockDispoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockDispo record);

    int insertSelective(StockDispo record);

    StockDispo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StockDispo record);

    int updateByPrimaryKey(StockDispo record);
    
    // 查询一次性用品（可带查询条件）
    List<StockDispo> selectAll(StockDispoPageReqVO vo);
    
    // 查询在库一次性用品（不分页）
    List<StockDispo> selectStockDispo();
    
    // 增加一次性用品
    void addStockDispo(StockDispoAddReqVO vo);

    // 批量删除一次性用品(list需要删除使用品的id列表)
    int batchDeleteDispo(@Param("list") List<String> list);
}