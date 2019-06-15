package com.skynet.orm.service;

import com.skynet.constant.Constant;
import com.skynet.orm.util.ClassMapper;

public class ServiceMapper {
	
	public static Class getServiceClass(String module, String service) {
		module = module.toUpperCase();
		String prefix = "";
		if(Constant.SERVICE_MODEL_WIPM.equals(module)) {
			prefix = Constant.SERVICE_PACKAGE_WIPM;
		}
		return ClassMapper.getClass((prefix + service));
	}

}
