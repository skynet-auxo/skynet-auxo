/** 
 * Project Name: AuxoBus
 * File Name:AuxoCacheType.java 
 * Package Name:com.auxo.cache 
 * History
 * Seq   Date        Developer      Description                        
 *  ---------------------------------------------------------------------------
 *  1    2019年06月14日    zeroLi        Create
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, zeroLi of AuXo All Rights Reserved. 
 * 
 */
package com.auxo.cache;

import com.auxo.cache.ehcache.AuxoEhCacheManager;
import com.auxo.cache.redis.AuxoRedisManager;

public enum AuxoCacheType {
	EHCACHE("EHCACHE", new AuxoEhCacheManager(null)),
	
	REDIS("REDIS", new AuxoRedisManager(null));
	
	private String Type;
	
	private AuxoCacheManager auxoCacheManager;


	
	private AuxoCacheType(String type, AuxoCacheManager auxoCacheManager) {
		Type = type;
		this.auxoCacheManager = auxoCacheManager;
	}

	public String getType() {
		return Type;
	}

	public AuxoCacheManager getAuxoCacheManager() {
		return auxoCacheManager;
	}


	public void setType(String type) {
		Type = type;
	}



	public static AuxoCacheType setCacheType(String type) {
		switch (type) {
		case "EHCACHE":
			return EHCACHE;
		case "REDIS":
			return REDIS;
		default:
			return EHCACHE;
		}
	}
	
	

}













