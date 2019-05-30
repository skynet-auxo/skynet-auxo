/** 
 * Project Name:SkynetEye
 * File Name:SkynetConfig.java 
 * Package Name:com.skynet.common.config 
 * History
 * Seq   Date        Developer     email                   
 *  ---------------------------------------------------------------------------
 *  1    2018年8月21日    zeroLi       343077359@qq.com
 *
 *
 * Fcuntion Description : 使用java bean的方式读取自定义配置文件 skynet.properties
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, SkynetEye All Rights Reserved. 
 * 
 */ 
package com.skynet.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="skynet")
@PropertySource("classpath:skynet.properties") //制定配置文件
//@Configuration
//@ComponentScan(basePackages={"cn.com.temsis.*"}) 
public class SkynetConfig {
	
	public static SkynetConfig Instance;
	
	/**
	 * Upload path
	 */
//	@Value("${SKYNET_UPLOAD_PATH}")
	private String uploadPath;

	/**
	 * @return the uploadPath
	 */
	public String getUploadPath() {
		return uploadPath;
	}

	/**
	 * @param uploadPath the uploadPath to set
	 */
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	
	

}
