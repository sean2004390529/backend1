package com.sean.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sean.base.entity.StockStaff;
import com.sean.vo.req.StockStaffPageReqVO;

public interface StockStaffMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockStaff record);

    int insertSelective(StockStaff record);

    StockStaff selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StockStaff record);

    int updateByPrimaryKey(StockStaff record);
    
    // 查询所有员工（可带查询条件）
    List<StockStaff> selectAll(StockStaffPageReqVO vo );
    
    // 查询所有员工（全部员工，只查询id，staffname列）
    List<StockStaff> selectAllNoPage();
    
    // 批量删除员工(list需要删除员工的id列表)
    int batchDeleteUser(@Param("list") List<String> list);
    
    
    
}