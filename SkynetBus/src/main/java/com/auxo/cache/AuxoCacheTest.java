/** 
 * Project Name: AuxoBus
 * File Name:AuxoCacheTest.java 
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

import java.io.IOException;

public class AuxoCacheTest {

	public static void main(String[] args) {
		AuxoCacheConfig cacheConfig = null ;
		try {
			//D:/project/workspace/skynet/SkynetBus/src/main/resources
			cacheConfig = AuxoCacheConfig.initFromConfig("/application.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AuxoCacheBuilder auxoCacheBuilder = new AuxoCacheBuilder(cacheConfig);
		
		
		AuxoCache cache = auxoCacheBuilder.builderCache();
		cache.put("", "");
		

	}

}
