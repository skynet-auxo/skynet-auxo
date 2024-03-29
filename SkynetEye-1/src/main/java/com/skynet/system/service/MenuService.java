/** 
 * Project Name:SkynetEye
 * File Name:MenuService.java 
 * Package Name:com.skynet.system.service 
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
package com.skynet.system.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.skynet.common.bean.Tree;
import com.skynet.system.bean.Esysmeudef;

@Service
public interface MenuService {
	/**
	 * Get the tree menu
	 * @param id
	 * @return
	 */
	public Tree<Esysmeudef> getSysMenuTree(Long id);

	public List<Tree<Esysmeudef>> listMenuTree(Long id);

	public Tree<Esysmeudef> getTree();

	public Tree<Esysmeudef> getTree(Long id);

	/**
	 * Get the list of menu
	 * @param params
	 * @return
	 */
	public List<Esysmeudef> list(Map<String, Object> params);

	/**
	 * Create a new menu
	 * @param menu
	 * @return
	 */
	public int create(Esysmeudef menu);

	/**
	 * Update a menu
	 * @param menu
	 * @return
	 */
	public int update(Esysmeudef menu);
	
	/**
	 * Delete a menu
	 * @param id
	 * @return
	 */
	public int delete(Long id);

	/**
	 * Get a menu information
	 * @param id
	 * @return
	 */
	public Esysmeudef get(Long id);

	/**
	 * Get permission information for a user
	 * @param userId
	 * @return
	 */
	public Set<String> listPerms(Long userId);
}
