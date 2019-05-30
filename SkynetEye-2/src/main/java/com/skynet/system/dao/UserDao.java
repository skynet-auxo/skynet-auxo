/** 
 * Project Name:SkynetEye
 * File Name:UserDao.java 
 * Package Name:com.skynet.system.dao 
 * History
 * Seq   Date        Developer     email                   
 *  ---------------------------------------------------------------------------
 *  1    2018年8月23日    zeroLi       343077359@qq.com
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

import com.skynet.system.bean.Esecusrdef;

@Mapper
public interface UserDao {
	
	public List<Esecusrdef> findAll();
	
	public Esecusrdef getUser(Long userId);
	
	public List<Esecusrdef> userList(Map<String,Object> map);
	
	public int count(Map<String,Object> map);
	
	public int create(Esecusrdef user);
	
	public int update(Esecusrdef user);
	
	public int delete(Long userId);
	
	public int batchDelete(Long[] userIds);
	
	public Long[] listAllDept();
}
