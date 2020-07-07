package com.sean.base.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sean.base.entity.SysDept;
import com.sean.service.DeptService;
import com.sean.utils.DataResult;
import com.sean.vo.req.DeptAddReqVO;
import com.sean.vo.req.DeptUpdateReqVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@RestController
@RequestMapping("/api/v1")
@Api(tags="Dept模块相关接口", description = "Dept模块相关接口")
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	@PostMapping("/dept/list")
	@ApiModelProperty("查询部门树状列表")
	public DataResult<List<SysDept>> selectAll(){
		DataResult result = DataResult.success();
		result.setData(deptService.getDept());
		return result;
	}
	
	@GetMapping("/depts")
	@ApiModelProperty("查询所有部门数据接口(扁平式部门列表)")
	public DataResult<List<SysDept>> getAll(){
		DataResult result = DataResult.success();
		result.setData(deptService.selectAll());
		return result;
	}
	
	@GetMapping("/depts/sub/{deptId}")
	@ApiModelProperty("查询子部门数据")
	public DataResult<List<SysDept>> subDepts(@PathVariable(value = "deptId",required = false)String deptId){
		DataResult result = DataResult.success();
		result.setData(deptService.subDepts(deptId));
		return result;
	}
	
	@PostMapping("/dept")
	@ApiModelProperty("新增部门")
	private DataResult<SysDept> addDept(@RequestBody @Valid DeptAddReqVO vo){
		DataResult result = DataResult.success();
		result.setData(deptService.addDept(vo));
		return result;
	}
	
	@PutMapping("/dept")
	@ApiModelProperty("修改部门信息")
	public DataResult updateDept(@RequestBody @Valid DeptUpdateReqVO vo) {
		DataResult result = DataResult.success();
		deptService.updateDept(vo);
		return result;
	}
	
	@DeleteMapping("/dept/{deptId}")
	@ApiModelProperty("删除部门角色")
	public DataResult deleteDept(@PathVariable("deptId") String deptId) {
		System.out.println(deptId);
		deptService.deleteDept(deptId);
		return DataResult.success();
	}
	
}
