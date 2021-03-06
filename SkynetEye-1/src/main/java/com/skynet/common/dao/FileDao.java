/** 
 * Project Name:SkynetEye
 * File Name:FileDao.java 
 * Package Name:com.skynet.common.dao 
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
package com.skynet.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.skynet.common.bean.Esysfildef;

@Mapper
public interface FileDao {
	
	public Esysfildef get(Long id);
	
	public List<Esysfildef> list(Map<String,Object> map);
	
	public int count(Map<String,Object> map);
	
	public int create(Esysfildef file);
	
	public int update(Esysfildef file);
	
	public int delete(Long id);
	
	public int batchDelete(Long[] ids);
}
