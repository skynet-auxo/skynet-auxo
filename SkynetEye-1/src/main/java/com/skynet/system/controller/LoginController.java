/** 
 * Project Name:SkynetEye
 * File Name:LoginController.java 
 * Package Name:com.skynet.system.controller 
 * History
 * Seq   Date        Developer     email                   
 *  ---------------------------------------------------------------------------
 *  1    2018年8月21日    zeroLi       343077359@qq.com
 *
 *
 * Fcuntion Description :
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, SkynetEye All Rights Reserved. 
 * 
 */ 
package com.skynet.system.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skynet.common.bean.Esysfildef;
import com.skynet.common.bean.Tree;
import com.skynet.common.controller.AbstractBaseController;
import com.skynet.common.service.FileService;
import com.skynet.common.utils.MD5Utils;
import com.skynet.common.utils.Result;
import com.skynet.system.bean.Esecusrdef;
import com.skynet.system.bean.Esysmeudef;
import com.skynet.system.service.UserService;

@Controller
public class LoginController extends AbstractBaseController{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

//	@Autowired
//	MenuService menuService;
	@Autowired
	UserService userService;
	
	@Autowired
	FileService fileService;
	
	@RequestMapping({ "/", "" })
	String welcome(Model model) {

		return "redirect:/blog";
	}

//	@Log("请求访问主页")
//	@RequestMapping({ "/index" })
//	String index(Model model) {
//		List<Tree<Esysmeudef>> menus = menuService.listMenuTree(getUserId());
//		model.addAttribute("menus", menus);
//		model.addAttribute("name", getUser().getUserDesc());
//		Esysfildef fileDef = fileService.get(getUser().getPicId());
//		if(fileDef!=null&&fileDef.getUrl()!=null){
//			if(fileService.isExist(fileDef.getUrl())){
//				model.addAttribute("picUrl",fileDef.getUrl());
//			}else {
//				model.addAttribute("picUrl","/img/photo_s.jpg");
//			}
//		}else {
//			model.addAttribute("picUrl","/img/photo_s.jpg");
//		}
//		model.addAttribute("username", getUser().getUserName());
//		return "index_v1";
//	}

	@RequestMapping("/login")
	String login() {
		return "login";
	}

//	@Log("登录")
	@PostMapping("/login")
	@ResponseBody
	Result ajaxLogin(String username, String password) {
//		Esecusrdef user = userService.get(Long.valueOf(1));
//		System.out.println(user);
		password = MD5Utils.encrypt(username, password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return Result.success();
		} catch (AuthenticationException e) {
			return Result.error("用户或密码错误");
		}
	}

	@RequestMapping("/logout")
	String logout() {
//		ShiroUtils.logout();
		return "redirect:/login";
	}

	@RequestMapping("/main")
	String main() {
		return "main";
	}
}
