package com.sean.base.mapper;

import java.util.List;

import com.sean.base.entity.Todo;
import com.sean.vo.req.TodoPageReqVO;
import org.apache.ibatis.annotations.Param;

public interface TodoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Todo record);

    int insertSelective(Todo record);

    Todo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Todo record);

    int updateByPrimaryKey(Todo record);
    
    // 查询所有角色--分页
    List<Todo> selectAll(TodoPageReqVO vo);
    
    // 批量删除Todo(list需要删除Todo的id列表)
    int batchDeleteTodo(@Param("list") List<String> list);
}