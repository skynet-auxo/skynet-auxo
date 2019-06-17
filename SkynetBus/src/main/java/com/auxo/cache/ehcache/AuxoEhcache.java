/** 
 * Project Name: AuxoBus
 * File Name:AuxoEhcache.java 
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

import java.util.Collection;
import java.util.Map;

import com.auxo.cache.AuxoCache;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public class AuxoEhcache implements AuxoCache {
	
	private Ehcache ehcache;

	public AuxoEhcache(Ehcache ehcache) {
		this.ehcache = ehcache;
	}

	@Override
	public Object get(String key) {
		ehcache.get(key);
		return null;
	}

	@Override
	public Map<String, Object> get(Collection<String> keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(String key, Object value) {
		ehcache.put(ElementSwap.Put(key, value));

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
		

	}
	
	static class ElementSwap {
		private static Element Put(String key, Object value) {
			Element element = new Element(key, value);
			return element;
		}
	}
	
	
	

}
