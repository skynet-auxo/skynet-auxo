/** 
 * Project Name:SkynetEye
 * File Name:HelloThymeleaf.java 
 * Package Name:com.skynet.controller 
 * History
 * Seq   Date        Developer      Description                        
 *  ---------------------------------------------------------------------------
 *  1    2018年8月20日    zeroLi        Create
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, SkynetEye All Rights Reserved. 
 * 
 */ 
package com.skynet.controller;

import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/thymeleaf")
@EnableAutoConfiguration
public class HelloThymeleaf {
	
	@RequestMapping("/loginHtml")
	public String helloHtml(Map<String,Object> map){
//		map.put("hello","from TemplateController.helloHtml");
		return "login";
	}

}
