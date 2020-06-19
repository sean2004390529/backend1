package com.sean.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sean.base.entity.Todo;
import com.sean.base.mapper.SysRoleMapper;
import com.sean.base.mapper.TodoMapper;
import com.sean.exception.BusinessException;
import com.sean.exception.code.BaseResponseCode;
import com.sean.service.TodoService;
import com.sean.utils.PageUtil;
import com.sean.vo.req.TodoAddReqVO;
import com.sean.vo.req.TodoPageReqVO;
import com.sean.vo.req.TodoUpdateReqVO;
import com.sean.vo.resp.PageVO;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoMapper todoMapper;
	
	// 查询Todo -- 分页
	@Override
	public PageVO<Todo> selectAll(TodoPageReqVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<Todo> all = todoMapper.selectAll(vo);
		return PageUtil.getPageVO(all);
	}

	
	// 新增Ttodo
	@Override
	public Todo addTodo(TodoAddReqVO vo) {
		Todo todo = new Todo();
		BeanUtils.copyProperties(vo, todo);
		todo.setId(UUID.randomUUID().toString());
		todo.setCreateTime(new Date());
		int i = todoMapper.insertSelective(todo);
		if(i!=1) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
		return todo;
	}

	// 更新Todo
	@Override
	public void updateTodo(TodoUpdateReqVO vo) {
		Todo todo = todoMapper.selectByPrimaryKey(vo.getId());
		if(null==todo) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
		BeanUtils.copyProperties(vo, todo);
		todo.setUpdateTime(new Date());
		int ret = todoMapper.updateByPrimaryKeySelective(todo);
		if(ret!=1) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
	}


	@Override
	public void batchDeleteTodo(List<String> list) {
		int i = todoMapper.batchDeleteTodo(list);
		if(i==0) {
			throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
		}
	}

}
