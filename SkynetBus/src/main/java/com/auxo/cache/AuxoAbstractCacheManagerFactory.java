/** 
 * Project Name: AuxoBus
 * File Name:AuxoAbstractCacheManagerFactory.java 
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

public class AuxoAbstractCacheManagerFactory {

	public static AuxoCache createCache(AuxoCacheConfig cacheConfig) {
		
		AuxoCacheManager auxoCacheManager;
		switch (cacheConfig.getCacheType()) {
		case AuxoCacheConstant.AUXO_CACHE_TYPE_EHCACHE:
			auxoCacheManager = new AuxoEhCacheManager(cacheConfig);
			break;
			
		case AuxoCacheConstant.AUXO_CACHE_TYPE_REDIS:
			auxoCacheManager = new AuxoRedisManager(cacheConfig);
			break;
			
		default:
			auxoCacheManager = new AuxoEhCacheManager(cacheConfig);
			break;
		}
		
		AuxoCache auxoCache = auxoCacheManager.createAuxoCache();
		return auxoCache;
		
	}
	



}
