/** 
 * Project Name: AuxoBus
 * File Name:AuxoCacheConfig.java 
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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.boot.autoconfigure.cache.CacheType;

import com.auxo.cache.exception.AuxoCacheException;
import com.auxo.util.AuxoUtil;

public class AuxoCacheConfig {
	
	private Properties properties = new Properties();
	private String cacheType;


	public final static AuxoCacheConfig initFromConfig(String configResourcePath) throws IOException {
		InputStream stream = getConfigStream(configResourcePath);
		return initFromConfig(stream);
		
	}
	
	
	public final static AuxoCacheConfig initFromConfig(File configFile) throws IOException {
		FileInputStream stream = new FileInputStream(configFile);
		return initFromConfig(stream);
	}
	
	public final static AuxoCacheConfig initFromConfig(InputStream stream) throws IOException {
		Properties properties = new Properties();
		properties.load(stream);
		return initFromConfig(properties);
	}
	
	
	private static InputStream getConfigStream(String configResourcePath) {
		InputStream configStream = AuxoCacheConfig.class.getResourceAsStream(configResourcePath);
        if (configStream == null) {
            configStream = AuxoCacheConfig.class.getClassLoader().getParent().getResourceAsStream(configResourcePath);
        }
        if (configStream == null) {
            throw new AuxoCacheException("Cannot find " + configResourcePath + " !!!");
        }
        return configStream;
	}
	
	

	public final static AuxoCacheConfig initFromConfig(Properties properties) {
		AuxoCacheConfig auxoCacheConfig = new AuxoCacheConfig();
		auxoCacheConfig.properties = properties;
		auxoCacheConfig.setCacheType(AuxoUtil.trim(auxoCacheConfig.properties.getProperty("auxo.cache.cachetype")));
//		auxoCacheConfig.cacheType = AuxoUtil.trim(auxoCacheConfig.properties.getProperty("auxo.cache.cachetype"));
		
		
		return auxoCacheConfig;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public String getCacheType() {
		return cacheType;
	}
	public void setCacheType(String cacheType) {
		this.cacheType = cacheType;
	}
	
	
	
	
	
	
	
	
	
	
	

}
