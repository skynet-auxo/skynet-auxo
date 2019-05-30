/** 
 * Project Name:SkynetEye
 * File Name:DeptService.java 
 * Package Name:com.skynet.system.service 
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
package com.skynet.system.service;

import java.util.List;
import java.util.Map;

import com.skynet.common.bean.Tree;
import com.skynet.system.bean.Esecdptdef;

public interface DeptService {
	
	public Esecdptdef get(Long deptId);
	
	public List<Esecdptdef> list(Map<String, Object> map);
	
	public int count(Map<String, Object> map);
	
	public int create(Esecdptdef sysDept);
	
	public int update(Esecdptdef sysDept);
	
	public int delete(Long deptId);
	
	public int batchDelete(Long[] deptIds);

	public Tree<Esecdptdef> getTree();
	
	public boolean checkDeptHasUser(Long deptId);
}
