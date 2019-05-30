/** 
 * Project Name:SkynetEye
 * File Name:DictService.java 
 * Package Name:com.skynet.system.service 
 * History
 * Seq   Date        Developer     email                   
 *  ---------------------------------------------------------------------------
 *  1    2018年8月24日    zeroLi       343077359@qq.com
 *
 *
 * Fcuntion Description :  Dictionary Table
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, SkynetEye All Rights Reserved. 
 * 
 */
package com.skynet.common.service;

import java.util.List;
import java.util.Map;

import com.skynet.common.bean.Egcmdicdef;
import com.skynet.system.bean.Esecusrdef;

public interface DictService {
	
	public Egcmdicdef get(Long id);

	public List<Egcmdicdef> list(Map<String, Object> map);

	public int count(Map<String, Object> map);

	public int create(Egcmdicdef dict);

	public int update(Egcmdicdef dict);

	public int delete(Long id);

	public int batchDelete(Long[] ids);

	public List<Egcmdicdef> listType();

	public String getName(String type, String value);

	/**
	 * 获取爱好列表
	 * 
	 * @return
	 * @param userDO
	 */
	public List<Egcmdicdef> getHobbyList(Esecusrdef user);

	/**
	 * 获取性别列表
	 * 
	 * @return
	 */
	public List<Egcmdicdef> getSexList();

	/**
	 * Get the data by type
	 * @param type
	 * @return
	 */
	public List<Egcmdicdef> listByType(String type);
}
