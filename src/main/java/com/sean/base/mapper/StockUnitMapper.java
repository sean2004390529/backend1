package com.sean.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sean.base.entity.StockUnit;
import com.sean.vo.req.StockUnitPageReqVO;

public interface StockUnitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockUnit record);

    int insertSelective(StockUnit record);

    StockUnit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StockUnit record);

    int updateByPrimaryKey(StockUnit record);
    
    // 查询所有单位(带条件-分页)
    List<StockUnit> selectAll(StockUnitPageReqVO vo);
    
    // 查询所有单位
    List<StockUnit> selectAllNoPage();
    
    // 批量删除单位(list需要删除单位的id列表)
    int batchDeleteUnit(@Param("list") List<String> list);
    
}