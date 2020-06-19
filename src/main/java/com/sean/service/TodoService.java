package com.sean.service;

import java.util.List;

import com.sean.base.entity.Todo;
import com.sean.vo.req.TodoAddReqVO;
import com.sean.vo.req.TodoPageReqVO;
import com.sean.vo.req.TodoUpdateReqVO;
import com.sean.vo.resp.PageVO;

public interface TodoService {

	// 查询所有Todo--分页
	PageVO<Todo> selectAll(TodoPageReqVO vo);
	
	// 新增Todo
	Todo addTodo(TodoAddReqVO vo);
	
	// 更新Todo
	void updateTodo(TodoUpdateReqVO vo);
	
	// 批量删除角色(list需要删除用户的id列表)
	void batchDeleteTodo(List<String> list);
}
