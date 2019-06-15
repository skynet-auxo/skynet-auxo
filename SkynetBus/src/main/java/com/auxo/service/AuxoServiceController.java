package com.skynet.orm.service;

import com.skynet.orm.base.DataIn;
import com.skynet.orm.base.DataOut;
import com.skynet.orm.exception.ServiceException;

import tmesis.service.JsonBean;

public class ServiceController {
	public void run(String model, String serviceName) throws ServiceException {
		Service svc = new Service();
		DataIn dataIn = null;
		DataOut dataOut = null;
		//此处做前段输入数据的封装注入inData中
		boolean successFlag = svc.doService(dataIn, dataOut);
		
	}

}
