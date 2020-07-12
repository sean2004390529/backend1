package com.sean.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sean.base.entity.StockReuse;
import com.sean.vo.req.StockReuseAddReqVO;
import com.sean.vo.req.StockReusePageReqVO;


public interface StockReuseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockReuse record);

    int insertSelective(StockReuse record);

    StockReuse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StockReuse record);

    int updateByPrimaryKey(StockReuse record);
    
    // 查询使用品（可带查询条件）
    List<StockReuse> selectAll(StockReusePageReqVO vo);
    
    // 增加使用品
    void addStockReuse(StockReuseAddReqVO vo);

    // 批量删除使用品(list需要删除使用品的id列表)
    int batchDeleteReuse(@Param("list") List<String> list);
}