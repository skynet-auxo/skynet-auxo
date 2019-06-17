/** 
 * Project Name: AuxoBus
 * File Name:AuxoEhCacheManager.java 
 * Package Name:com.auxo.cache.ehcache 
 * History
 * Seq   Date        Developer      Description                        
 *  ---------------------------------------------------------------------------
 *  1    2019年06月14日    zeroLi        Create
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, zeroLi of AuXo All Rights Reserved. 
 * 
 */
package com.auxo.cache.ehcache;

import java.net.URL;

import com.auxo.cache.AuxoCache;
import com.auxo.cache.AuxoCacheConfig;
import com.auxo.cache.AuxoCacheManager;
import com.auxo.util.AuxoConfig;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;

public class AuxoEhCacheManager implements AuxoCacheManager{
	
	private AuxoCacheConfig cacheConfig;

	CacheManager cacheManager;
//	= CacheManager.create("./src/main/resources/ehcache.xml");


	public AuxoEhCacheManager(AuxoCacheConfig cacheConfig) {
		this.cacheConfig = cacheConfig;
//		URL url = getClass().getResource("/ehcache.xml");
//		cacheManager = CacheManager.create(url);
		
		cacheManager = CacheManager.create(AuxoConfig.Instance.AUXO_CACHE_PATH);
		cacheManager.getCacheNames();
	}


	@Override
	public AuxoCache createAuxoCache() {
		cacheManager.getCache("");
		Ehcache ehcache = cacheManager.getEhcache("");
		AuxoEhcache auxoEhcache = new AuxoEhcache(ehcache);
		return auxoEhcache;
	}
	
	
	
	

	
	
	

}
