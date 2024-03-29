/** 
 * Project Name:SkynetEye
 * File Name:DeptDao.java 
 * Package Name:com.skynet.system.dao 
 * History
 * Seq   Date        Developer     email                   
 *  ---------------------------------------------------------------------------
 *  1    2018年8月21日    zeroLi       343077359@qq.com
 *
 *
 * Fcuntion Description :
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, SkynetEye All Rights Reserved. 
 * 
 */ 
package com.skynet.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.skynet.system.bean.Esecdptdef;

@Mapper
public interface DeptDao {
	
	public Esecdptdef get(Long deptId);
	
	public List<Esecdptdef> list(Map<String,Object> map);
	
	public int count(Map<String,Object> map);
	
	public int create(Esecdptdef dept);
	
	public int update(Esecdptdef dept);
	
	public int delete(Long deptId);
	
	public int batchDelete(Long[] deptIds);
	
	public Long[] listParentDept();
	
	public int getDeptUserNumber(Long deptId);
}
