package com.sean.base.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sean.base.entity.Todo;
import com.sean.service.TodoService;
import com.sean.utils.DataResult;
import com.sean.vo.req.TodoAddReqVO;
import com.sean.vo.req.TodoPageReqVO;
import com.sean.vo.req.TodoUpdateReqVO;
import com.sean.vo.resp.PageVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
@Api(tags="todo模块相关接口")
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@PostMapping("/todo/list")
	@ApiModelProperty("分页查询todo接口")
	public DataResult<PageVO<Todo>> pageInfo(@RequestBody TodoPageReqVO vo){
		DataResult result = DataResult.success();
		result.setData(todoService.selectAll(vo));
		return result;
	}
	
	@PostMapping("/todo")
	@ApiModelProperty("新增todo")
	public DataResult<Todo> addTodo(@RequestBody @Valid TodoAddReqVO vo){
		DataResult result = DataResult.success();
		result.setData(todoService.addTodo(vo));
		return result;
	}
	
	@PutMapping("/todo")
	@ApiModelProperty("更新todo")
	public DataResult updateTodo(@RequestBody @Valid TodoUpdateReqVO vo) {
		DataResult result = DataResult.success();
		todoService.updateTodo(vo);
		return result;
	}
	
	@DeleteMapping("/todo")
	@ApiModelProperty("[批量]删除角色")
	public DataResult deleteRole(@RequestBody @ApiParam("Todo Id集合") List<String> list) {
		System.out.println(list);
		todoService.batchDeleteTodo(list);
		return DataResult.success();
	}
}
