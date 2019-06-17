/** 
 * Project Name: AuxoBus
 * File Name:AuxoCacheBuildere.java 
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

public class AuxoCacheBuilder {
	private AuxoCacheConfig cacheConfig;

	public AuxoCacheBuilder(AuxoCacheConfig cacheConfig) {
		this.cacheConfig = cacheConfig;
	}

	public AuxoCache builderCache() {
		AuxoCache auxoCache = AuxoAbstractCacheManagerFactory.createCache(cacheConfig);
		return auxoCache;
		
		
	}
	
	
	
	
	

	
	

}
