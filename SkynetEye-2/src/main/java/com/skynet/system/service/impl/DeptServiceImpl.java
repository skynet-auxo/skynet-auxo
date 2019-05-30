/** 
 * Project Name:SkynetEye
 * File Name:DeptServiceImpl.java 
 * Package Name:com.skynet.system.service.impl 
 * History
 * Seq   Date        Developer     email                   
 *  ---------------------------------------------------------------------------
 *  1    2018年8月24日    zeroLi       343077359@qq.com
 *
 *
 * Fcuntion Description :
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, SkynetEye All Rights Reserved. 
 * 
 */ 
package com.skynet.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skynet.common.bean.Tree;
import com.skynet.common.utils.BuildTree;
import com.skynet.system.bean.Esecdptdef;
import com.skynet.system.dao.DeptDao;
import com.skynet.system.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao deptMapper;
	
	@Override
	public Esecdptdef get(Long deptId) {
		return deptMapper.get(deptId);
	}

	@Override
	public List<Esecdptdef> list(Map<String, Object> map) {
		return deptMapper.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return deptMapper.count(map);
	}

	@Override
	public int create(Esecdptdef sysDept) {
		return deptMapper.create(sysDept);
	}

	@Override
	public int update(Esecdptdef sysDept) {
		return deptMapper.update(sysDept);
	}

	@Override
	public int delete(Long deptId) {
		return deptMapper.delete(deptId);
	}

	@Override
	public int batchDelete(Long[] deptIds) {
		return deptMapper.batchDelete(deptIds);
	}

	@Override
	public Tree<Esecdptdef> getTree() {
		List<Tree<Esecdptdef>> trees = new ArrayList<Tree<Esecdptdef>>();
		List<Esecdptdef> sysDepts = deptMapper.list(new HashMap<String,Object>(16));
		for (Esecdptdef sysDept : sysDepts) {
			Tree<Esecdptdef> tree = new Tree<Esecdptdef>();
			tree.setId(sysDept.getDeptId().toString());
			tree.setParentId(sysDept.getParentId().toString());
			tree.setText(sysDept.getName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<Esecdptdef> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public boolean checkDeptHasUser(Long deptId) {
		//查询部门以及此部门的下级部门
		int result = deptMapper.getDeptUserNumber(deptId);
		return result==0?true:false;
	}

}
