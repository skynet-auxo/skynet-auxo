package com.skynet.orm.service;

import com.skynet.orm.base.DataIn;
import com.skynet.orm.base.DataOut;
import com.skynet.orm.exception.ServiceException;
import com.skynet.orm.executor.DefaultExecutorImpl;
import com.skynet.orm.executor.Executor;
import com.skynet.orm.jdbc.JdbcConnection;

import tmesis.db.TableHelper;
import tmesis.service.JsonBean;

public abstract class AbstractService {
	
	private JdbcConnection jdbcConn;
	protected Executor exectorHelper;
	
	public AbstractService() {
		
	}
	
	public AbstractService(JdbcConnection jdbcConn) {
		super();
		this.jdbcConn = jdbcConn;
	}

	public JdbcConnection getJdbcConn() {
		return jdbcConn;
	}

	public void setJdbcConn(JdbcConnection jdbcConn) {
		this.jdbcConn = jdbcConn;
	}
	
	public boolean process(DataIn inData, DataOut outData) throws ServiceException {
		try {
			this.exectorHelper = new DefaultExecutorImpl(getJdbcConn(), this);
			//do something befor
			this.isValid(inData, outData);
			this.doService(inData, outData);
			//do something after
		} catch (ServiceException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	public abstract void doService(DataIn inData, DataOut outData) throws ServiceException;

	public abstract void isValid(DataIn inData, DataOut outData);

}
