/** 
 * Project Name:SkynetEye
 * File Name:MenuDao.java 
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

import com.skynet.system.bean.Esysmeudef;

@Mapper
public interface MenuDao {
	public Esysmeudef get(Long menuId);
	
	public List<Esysmeudef> list(Map<String,Object> map);
	
	public int count(Map<String,Object> map);
	
	public int create(Esysmeudef menu);
	
	public int update(Esysmeudef menu);
	
	public int delete(Long menuId);
	
	public int batchDelete(Long[] menuIds);
	
	public List<Esysmeudef> listMenuByUserId(Long id);
	
	public List<String> listUserPerms(Long id);
}
