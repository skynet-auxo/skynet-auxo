package com.skynet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = {"com.skynet.config.*"})
public class Config {
	public static Config Instance;

	@Autowired
	@Value("${SYSTEM_HOME_PATH}")
	public String SYSTEM_HOME_PATH;
	@Autowired
	@Value("${LOG_SQL_FLAG}")
	public boolean LOG_SQL_FLAG = false;
	@Autowired
	@Value("${LOG_SYSTEM_FLAG}")
	public boolean LOG_SYSTEM_FLAG = true;

}
