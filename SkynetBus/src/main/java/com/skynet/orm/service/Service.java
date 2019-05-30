package com.skynet.orm.service;

import java.util.Objects;

import com.skynet.orm.base.DataIn;
import com.skynet.orm.base.DataOut;
import com.skynet.orm.exception.ServiceException;
import com.skynet.orm.jdbc.JdbcConnection;

public class Service {
	
	private JdbcConnection jdbcConnection = null;

	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean doService(DataIn dataIn, DataOut dataOut) {
		AbstractService service = null;
		boolean commitFlag = true;
		boolean successFlag = true;
		String moduleName = "WIPM";
		String serviceName = "WipmFinishLot";
		
		try {
			Class<?> serviceClass = ServiceMapper.getServiceClass(moduleName, serviceName);
			System.out.println(serviceClass);
			if (serviceClass == null) {
				//to do something
			}
			
			try {
				service = (AbstractService) serviceClass.getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			jdbcConnection = JdbcConnection.requirConn();
			
			if(Objects.isNull(jdbcConnection)) {
				//to do something
				return false;
			}
			
			service.setJdbcConn(jdbcConnection);
			service.process(dataIn, dataOut);
		} catch (ServiceException e) {
			e.printStackTrace();
			commitFlag = false;
			successFlag = false;
		} finally {
			submitDbConnection(commitFlag);
		}
		return successFlag;
		
		
	}
	
	
	
	public void submitDbConnection(boolean commitFlag) {
		try {
			if(commitFlag) {
				jdbcConnection.commit();
			} else {
				jdbcConnection.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// logo
		}

	}
	

}
