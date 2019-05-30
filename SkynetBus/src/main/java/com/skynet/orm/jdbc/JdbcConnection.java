package com.skynet.orm.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.skynet.orm.executor.Executor;
import com.skynet.orm.util.SpringUtil;

public class JdbcConnection {
	
	private Connection connection;
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public static JdbcConnection requirConn() {
		JdbcConnection jdbcConnection = new JdbcConnection();
		try {
			if(!jdbcConnection.openConn()) {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jdbcConnection;
		
	}
	public boolean openConn() throws SQLException {
		try {
			this.connection = getDataSource().getConnection();
			this.connection.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}
	
	public DataSource getDataSource() {
		return SpringUtil.getBean(DataSource.class);
	}
	
	public void close() throws SQLException {
		this.connection.close();
		this.connection = null;
	}
	
	public void rollback() throws SQLException {
		this.connection.rollback();
	}
	
	public void commit() throws SQLException {
		this.connection.commit();
	}
	

}
