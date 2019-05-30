/** 
 * Project Name:SkynetEye
 * File Name:DictDao.java 
 * Package Name:com.skynet.common.dao 
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
package com.skynet.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.skynet.common.bean.Egcmdicdef;

@Mapper
public interface DictDao {

	public Egcmdicdef get(Long id);

	public List<Egcmdicdef> list(Map<String, Object> map);

	public int count(Map<String, Object> map);

	public int create(Egcmdicdef dict);

	public int update(Egcmdicdef dict);

	public int delete(Long id);

	public int batchDelete(Long[] ids);

	public List<Egcmdicdef> listType();
}
