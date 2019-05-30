/** 
 * Project Name:SkynetEye
 * File Name:UserRoleDao.java 
 * Package Name:com.skynet.system.dao 
 * History
 * Seq   Date        Developer      Description : User and Role Matching               
 *  ---------------------------------------------------------------------------
 *  1    2018年8月21日    zeroLi        Create
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, SkynetEye All Rights Reserved. 
 * 
 */ 
package com.skynet.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.skynet.system.bean.Esecuserol;

@Mapper
public interface UserRoleDao {
	
	public Esecuserol get(Long id);

	public List<Esecuserol> list(Map<String, Object> map);

	public int count(Map<String, Object> map);

	public int create(Esecuserol userRole);

	public int update(Esecuserol userRole);

	public int delete(Long id);

	public int batchDelete(Long[] ids);

	public List<Long> listRoleId(Long userId);

	public int deleteByUserId(Long userId);

	public int deleteByRoleId(Long roleId);

	public int batchCreate(List<Esecuserol> list);

	public int batchDeleteByUserId(Long[] ids);

}
