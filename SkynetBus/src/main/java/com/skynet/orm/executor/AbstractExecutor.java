package com.skynet.orm.executor;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.skynet.constant.Constant;
import com.skynet.handler.AssemSqlHandler;
import com.skynet.orm.base.BaseTable;
import com.skynet.orm.base.TableColumnType;
import com.skynet.orm.base.TableDefine;
import com.skynet.orm.exception.ServiceException;
import com.skynet.orm.jdbc.JdbcConnection;
import com.skynet.orm.service.AbstractService;
import com.skynet.orm.util.DataUtil;

public abstract class AbstractExecutor implements Executor {

	private JdbcConnection jdbcConn;
	private AbstractService mesService;
	private long startTime = 0L;
	private long endTime = 0L;
	
	@Override
	public <E extends BaseTable> int insert(E e, String exceptionCode) throws ServiceException {
		return 0;
	}

	@Override
	public <E extends BaseTable> int update(E e, String exceptionCode) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <E extends BaseTable> int upsert(E e, String exceptionCode) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public <E extends BaseTable> int delete(E e, String exceptionCode) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public <E extends BaseTable> int deleteByKey(E e, String exceptionCode) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <E extends BaseTable> E select(E e, String exceptionCode) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <E extends BaseTable> List<E> selectList(E e, String exceptionCode) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	public AbstractExecutor(JdbcConnection jdbcConn) {
		this.jdbcConn = jdbcConn;
	}

	public AbstractExecutor(JdbcConnection jdbcConn, AbstractService mesService) {
		super();
		this.jdbcConn = jdbcConn;
		this.mesService = mesService;
	}

	public JdbcConnection getJdbcConn() {
		return jdbcConn;
	}

	public void setJdbcConn(JdbcConnection jdbcConn) {
		this.jdbcConn = jdbcConn;
	}
	
	public AbstractService getMesService() {
		return mesService;
	}

	public void setMesService(AbstractService mesService) {
		this.mesService = mesService;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime() {
		this.startTime = DataUtil.getCurrentTime();
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime() {
		this.endTime = DataUtil.getCurrentTime();
	}
	
	public double getDurTime() {
		return (double)(endTime - startTime) / 1000.0D;
	}

	protected <E extends BaseTable> void getTableDefines(E e) {
		String selectListSql = AssemSqlHandler.build(e, Constant.DB_PROCESS_TYPE_OTHERS);
		Statement stmt = null;
		ResultSet resultSet = null;
		List<TableDefine> tableDefines = new ArrayList<TableDefine>();
		List<TableDefine> pkDefines = new ArrayList<TableDefine>();
		Map<String, TableDefine> tableDefineMap = e.getTableDefinesMap();
		try {
			Connection connection = getJdbcConn().getConnection();
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(selectListSql);
			ResultSetMetaData rsmd = resultSet.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				String columnName = rsmd.getColumnName(i);
				String columnTypeName = rsmd.getColumnTypeName(i);
				int columnType = rsmd.getColumnType(i);
				int columnDisplaySize = rsmd.getColumnDisplaySize(i);
				TableDefine tableDefine = new TableDefine();
				tableDefine.setColumnName(columnName);
				tableDefine.setColumnTypeName(columnTypeName);
				tableDefine.setColumnType(TableColumnType.transformType(columnType));
				tableDefine.setSize(columnDisplaySize);
				tableDefines.add(tableDefine);
				tableDefineMap.put(columnName, tableDefine);
			}
			
			DatabaseMetaData dbMeta = connection.getMetaData();
			resultSet = dbMeta.getPrimaryKeys(null, null, e.getTableName().toUpperCase());
			while (resultSet.next()) {
				String columnNamePK = resultSet.getObject(4).toString();
//				int keySeq = (int) resultSet.getObject(5);
				TableDefine pkDefine = new TableDefine();
				pkDefine.setColumnName(columnNamePK);
				pkDefines.add(pkDefine);
			}
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			release(stmt, resultSet);
		}
		e.setTableDefines(tableDefines);
		e.setPkDefines(pkDefines);
	}
	
	protected void release(Statement stmt, ResultSet resultSet) {
		try {
			if (Objects.nonNull(stmt)) {
				stmt.close();
			}
			
			if(Objects.nonNull(resultSet)) {
				resultSet.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
