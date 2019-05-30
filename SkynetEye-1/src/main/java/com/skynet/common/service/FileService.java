/** 
 * Project Name:SkynetEye
 * File Name:FileService.java 
 * Package Name:com.skynet.common.service 
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
package com.skynet.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.skynet.common.bean.Esysfildef;

public interface FileService {
	/**
	 * Get the file
	 * @param id
	 * @return
	 */
	Esysfildef get(Long id);
	/**
	 * Get the list of file
	 * @param map
	 * @return
	 */
	List<Esysfildef> list(Map<String, Object> map);
	/**
	 * Get total the mumbers of file
	 * @param map
	 * @return
	 */
	int count(Map<String, Object> map);
	/**
	 * Create a new file 
	 * @param sysFile
	 * @return
	 */
	int create(Esysfildef sysFile);
	/**
	 * Update a file
	 * @param sysFile
	 * @return
	 */
	int update(Esysfildef sysFile);
	/**
	 * Delete a file
	 * @param id
	 * @return
	 */
	int delete(Long id);
	/**
	 * Batche delete files
	 * @param ids
	 * @return
	 */
	int batchDelete(Long[] ids);

	/**
	 * Check the file is exist
	 * @param url 
	 * @return
	 */
    Boolean isExist(String url);
}
