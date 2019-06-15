package com.skynet.orm.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skynet.orm.base.RequestJsonData;
import com.skynet.orm.exception.ServiceException;
import com.skynet.orm.service.ServiceController;

@Controller
public class DispatchServiceController {
	
	private final ServiceController dispatchServiceController = new ServiceController();

	@RequestMapping(value = "/dispatchService")
	@ResponseBody
	public void dispatchService() throws ServiceException {
//		String requestString = requestData.toJSONString();
//		System.out.println(requestString);
		if(checkAccessSecurity()) {
			String model = "";
			String serviceName = "";
			dispatchServiceController.run(model, serviceName);
		}
		
	}
	
	@RequestMapping(value = "/test")
	@ResponseBody
	public String dispatchServiceTest() throws ServiceException {
		if(checkAccessSecurity()) {
//			String model = "";
//			String serviceName = "";
//			dispatchServiceController.run(model, serviceName);
			
		}
		return "test";
		
	}
	
	private boolean checkAccessSecurity() {
		//check access sercurity
		return true;
		
	}



}
