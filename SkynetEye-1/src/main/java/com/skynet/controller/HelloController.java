package com.skynet.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skynet.bean.City;
import com.skynet.mapper.CityMapper;
import com.skynet.system.bean.Esecusrdef;
import com.skynet.system.service.UserService;

@RestController
@RequestMapping("/demo")
@EnableAutoConfiguration
public class HelloController {
//	@Resource
//	private CityMapper cityMapper;
	@Autowired
	UserService userService;
	
	@RequestMapping("/test")
	String test1(){
		Esecusrdef user = userService.get(Long.valueOf(1));
		System.out.println(user);
		
		return "hello,test1()";
	}
	
	@RequestMapping("/findCity2")
	City findCity2(@RequestParam String id){
//		return cityMapper.findCityById(id);
		return null;
	}
}