package com.skynet.common.controller;

import org.springframework.stereotype.Controller;

import com.skynet.common.utils.ShiroUtils;
import com.skynet.system.domain.UserDO;
import com.skynet.system.domain.UserToken;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}