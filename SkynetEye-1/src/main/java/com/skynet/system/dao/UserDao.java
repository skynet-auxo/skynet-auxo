/** 
 * Project Name:SkynetEye
 * File Name:UserDao.java 
 * Package Name:com.skynet.system.dao 
 * History
 * Seq   Date        Developer      Description                        
 *  ---------------------------------------------------------------------------
 *  1    2018年8月20日    zeroLi        Create
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, SkynetEye All Rights Reserved. 
 * 
 */ 
package com.skynet.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.skynet.system.bean.Esecusrdef;

//@Mapper
@Repository
public interface UserDao {
	
	public Esecusrdef get(Long userId);
	
	public List<Esecusrdef> list(Map<String,Object> map);
	
	public int count(Map<String,Object> map);
	
	public int create(Esecusrdef user);
	
	public int update(Esecusrdef user);
	
	public int delete(Long userId);
	
	public int batchDelete(Long[] userIds);
	
	public Long[] listAllDept();
	
//	public Esecusrdef findByName(String userName);
}
