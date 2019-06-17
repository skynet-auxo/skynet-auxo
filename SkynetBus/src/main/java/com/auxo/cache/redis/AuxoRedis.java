/** 
 * Project Name: AuxoBus
 * File Name:AuxoRedis.java 
 * Package Name:com.auxo.cache.redis
 * History
 * Seq   Date        Developer      Description                        
 *  ---------------------------------------------------------------------------
 *  1    2019年06月14日    zeroLi        Create
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, zeroLi of AuXo All Rights Reserved. 
 * 
 */
package com.auxo.cache.redis;

import java.util.Collection;
import java.util.Map;

import com.auxo.cache.AuxoCache;

public class AuxoRedis implements AuxoCache {

	@Override
	public Object get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> get(Collection<String> keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(String key, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void put(Map<String, Object> elements) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<String> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void evict(String... keys) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
