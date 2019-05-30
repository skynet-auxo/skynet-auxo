package com.skynet.cache;

public abstract class CacheManager {
	
	private ICache iCache;

	public CacheManager(ICache iCache) {
		this.iCache = iCache;
	}
	
	
	

}
