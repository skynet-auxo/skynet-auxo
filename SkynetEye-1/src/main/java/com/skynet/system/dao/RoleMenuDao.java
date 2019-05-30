/** 
 * Project Name:SkynetEye
 * File Name:RoleMenuDao.java 
 * Package Name:com.skynet.system.dao 
 * History
 * Seq   Date        Developer     email                   
 *  ---------------------------------------------------------------------------
 *  1    2018年8月22日    zeroLi       343077359@qq.com
 *
 *
 * Fcuntion Description : Menu and Role Matching
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, SkynetEye All Rights Reserved. 
 * 
 */ 
package com.skynet.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.skynet.system.bean.Esecrolmeu;

@Mapper
public interface RoleMenuDao {
	public Esecrolmeu get(Long id);
	
	public List<Esecrolmeu> list(Map<String,Object> map);
	
	public int count(Map<String,Object> map);
	
	public int create(Esecrolmeu roleMenu);
	
	public int update(Esecrolmeu roleMenu);
	
	public int delete(Long id);
	
	public int batchRemove(Long[] ids);
	
	public List<Long> listMenuIdByRoleId(Long roleId);
	
	public int deleteByRoleId(Long roleId);

	public int deleteByMenuId(Long menuId);
	
	public int batchCreate(List<Esecrolmeu> list);
}
