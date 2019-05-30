/** 
 * Project Name:SkynetEye
 * File Name:AbstractBaseController.java 
 * Package Name:com.skynet.common.controller 
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
package com.skynet.common.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;

import com.skynet.system.bean.Esecusrdef;

@Controller
public abstract class AbstractBaseController {
	public Esecusrdef getUser() {
		Esecusrdef esecusrdef = (Esecusrdef) SecurityUtils.getSubject().getPrincipal();
		return esecusrdef;
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUserName();
	}
}