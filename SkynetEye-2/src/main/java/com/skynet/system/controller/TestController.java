/** 
 * Project Name:SkynetEye
 * File Name:UserController.java 
 * Package Name:com.skynet.system.service 
 * History
 * Seq   Date        Developer     email                   
 *  ---------------------------------------------------------------------------
 *  1    2018年8月23日    zeroLi       343077359@qq.com
 *
 *
 * Fcuntion Description :
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, SkynetEye All Rights Reserved. 
 * 
 */ 
package com.skynet.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skynet.system.bean.Esecusrdef;
import com.skynet.system.service.UserService;

@Controller
public class TestController {
	@Resource
	UserService userService;
	
    @ResponseBody
    @RequestMapping("/aa")
    public List<Esecusrdef> aa(){
    	List<Esecusrdef> list = userService.findAll();
    	for (Esecusrdef esecusrdef : list) {
			System.out.println("user name = " + esecusrdef.getUserName());
		}
        return list;
    }
    
    @ResponseBody
    @RequestMapping("/getUser")
    public Esecusrdef getUser(){
    	Esecusrdef user = userService.getUser(Long.valueOf(36));
    	System.out.println("user name = " + user.getUserName());
        return user;
    }
    
    
    @ResponseBody
    @RequestMapping("/getUserList")
    public Esecusrdef userList(){
    	
    	Map<String, Object> map = new HashMap<>(16);
    	map.put("userName", "gdg");
    	Esecusrdef user = userService.userList(map).get(0);
    	System.out.println("user name = " + user.getUserName());
        return user;
    }
    
    @ResponseBody
    @RequestMapping("/getCount")
    public int getCount(){
    	
    	Map<String, Object> map = new HashMap<>(16);
    	map.put("userName", "gdg");
    	int count = userService.count(map);
    	System.out.println("user name = " + count);
        return count;
    }
    
    @ResponseBody
    @RequestMapping("/create")
    public int create(){
    	Esecusrdef esecusrdef = new Esecusrdef();
    	esecusrdef.setUserName("lxh");
    	esecusrdef.setUserDesc("李星魂");
    	int count = userService.create(esecusrdef);
    	System.out.println("user name = " + count);
        return count;
    }
    
    @ResponseBody
    @RequestMapping("/update")
    public int update(){
    	Esecusrdef esecusrdef = new Esecusrdef();
    	esecusrdef.setUserId(Long.valueOf(137));
    	esecusrdef.setUserName("lxh_test");
    	esecusrdef.setUserDesc("李星魂");
    	int count = userService.update(esecusrdef);
    	System.out.println("user name = " + count);
        return count;
    }
    
    @ResponseBody
    @RequestMapping("/delete")
    public int delete(){
    	int count = userService.delete(Long.valueOf(137));
    	System.out.println("user name = " + count);
        return count;
    }
    


}
