/** 
 * Project Name: AuxoBus
 * File Name: AuxoConfig.java 
 * Package Name: com.auxo.util
 * History
 * Seq   Date        Developer      Description                        
 *  ---------------------------------------------------------------------------
 *  1    2019年02月27日    zeroLi        Create
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, zeroLi of AuXo All Rights Reserved. 
 * 
 */
package com.auxo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = {"com.skynet.config.*"})
public class AuxoConfig {
	public static AuxoConfig Instance;

	@Autowired
	@Value("${SYSTEM_HOME_PATH}")
	public String SYSTEM_HOME_PATH;
	
	@Autowired
	@Value("${LOG_SQL_FLAG}")
	public boolean LOG_SQL_FLAG = false;
	
	@Autowired
	@Value("${LOG_SYSTEM_FLAG}")
	public boolean LOG_SYSTEM_FLAG = true;
	
	@Autowired
	@Value("${AUXO_CACHE_PATH}")
	public String AUXO_CACHE_PATH ="";

}
