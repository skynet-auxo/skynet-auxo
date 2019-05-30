/** 
 * Project Name:SkynetEye
 * File Name:RoleDao.java 
 * Package Name:com.skynet.system.dao 
 * History
 * Seq   Date        Developer     email                   
 *  ---------------------------------------------------------------------------
 *  1    2018年8月22日    zeroLi       343077359@qq.com
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

import com.skynet.system.bean.Esecroldef;

@Mapper
public interface RoleDao {
	
	public Esecroldef get(Long roleId);
	
	public List<Esecroldef> list(Map<String,Object> map);
	
	public int count(Map<String,Object> map);
	
	public int create(Esecroldef role);
	
	public int update(Esecroldef role);
	
	public int delete(Long roleId);
	
	public int batchDelete(Long[] roleIds);
}
