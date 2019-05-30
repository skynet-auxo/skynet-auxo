package com.skynet.orm.executor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.skynet.constant.Constant;
import com.skynet.handler.AssemSqlHandler;
import com.skynet.handler.LoggerHandler;
import com.skynet.orm.base.BaseTable;
import com.skynet.orm.base.TableDefine;
import com.skynet.orm.exception.DbException;
import com.skynet.orm.exception.ServiceException;
import com.skynet.orm.jdbc.JdbcConnection;
import com.skynet.orm.service.AbstractService;
import com.skynet.orm.util.SystemPlatformUtil;

public class DefaultExecutorImpl extends AbstractExecutor {

	public DefaultExecutorImpl(JdbcConnection jdbcConn) {
		super(jdbcConn);
		// TODO Auto-generated constructor stub
	}
	
	public DefaultExecutorImpl(JdbcConnection jdbcConn, AbstractService mesService) {
		super(jdbcConn, mesService);
	}
	
	

	@Override
	public <T extends BaseTable> int insert(T t, String exceptionCode) throws ServiceException {
		setStartTime();
		getTableDefines(t);
		String insertSql = AssemSqlHandler.build(t, Constant.DB_PROCESS_TYPE_INSERT);
		System.out.println(insertSql);
		return executorIUD(t, insertSql, false, Constant.SERVICE_PROCESS_STEP_INSERT);
	}

	@Override
	public <T extends BaseTable> int update(T t, String exceptionCode) throws ServiceException {
		setStartTime();
		getTableDefines(t);
		String updateSql = AssemSqlHandler.build(t, Constant.DB_PROCESS_TYPE_UPDATE);
		System.out.println(updateSql);
		return executorIUD(t, updateSql, false, Constant.SERVICE_PROCESS_STEP_UPDATE);
	}
	
	@Override
	public <E extends BaseTable> int updateByKey(E e, String exceptionCode) throws ServiceException {
		setStartTime();
		getTableDefines(e);
		String updateSql = AssemSqlHandler.build(e, Constant.DB_PROCESS_TYPE_UPDATE_BY_KEY);
		System.out.println(updateSql);
		return executorIUD(e, updateSql, true, Constant.SERVICE_PROCESS_STEP_UPDATE);
	}

	@Override
	public <T extends BaseTable> int upsert(T t, String exceptionCode) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public <E extends BaseTable> int delete(E e, String exceptionCode) throws ServiceException {
		setStartTime();
		String deleteSql = AssemSqlHandler.build(e, Constant.DB_PROCESS_TYPE_DELETE);
		System.out.println(deleteSql);
		return executorIUD(e, deleteSql, false, Constant.SERVICE_PROCESS_STEP_DELETE);
	}
	
	@Override
	public <E extends BaseTable> int deleteByKey(E e, String exceptionCode) throws ServiceException {
		setStartTime();
		getTableDefines(e);
		String deleteSql = AssemSqlHandler.build(e, Constant.DB_PROCESS_TYPE_DELETE_BY_KEY);
		System.out.println(deleteSql);
		return executorIUD(e, deleteSql, true, Constant.SERVICE_PROCESS_STEP_DELETE);
	}

	@Override
	public <T extends BaseTable> T select(T t, String exceptionCode) throws ServiceException {
		setStartTime();
		List<T> list = selectList(t, exceptionCode);
		if(list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public <E extends BaseTable> E selectByKey(E e, String exceptionCode) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends BaseTable> List<T> selectList(T t, String exceptionCode) throws ServiceException {
		setStartTime();
		String selectListSql = AssemSqlHandler.build(t, Constant.DB_PROCESS_TYPE_QUERY);
		System.out.println(selectListSql);
		Map<String, Object> tableFilds = t.getTableFileMap();

		List<T> list = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = getJdbcConn().getConnection().prepareStatement(selectListSql);
			int i = 0;

			for (Map.Entry<String, Object> entry : tableFilds.entrySet()) {
				i++;
				stmt.setObject(i, entry.getValue());
			}

			resultSet = stmt.executeQuery();
			int rowCount = resultSet.getRow();
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

			while (resultSet.next()) {
				T newInstance = (T) t.getClass().newInstance();
				for (int j = 0; j < resultSetMetaData.getColumnCount(); j++) {
					String columnname = resultSetMetaData.getColumnLabel(j + 1);
					Object value = resultSet.getObject(j + 1);
					newInstance.setVaule(columnname, value);
				}
				list.add(newInstance);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			setEndTime();
			double durTime = getDurTime();
			LoggerHandler.logSql("", this.getMesService().getClass().getSimpleName(), selectListSql, "", durTime);
			release(stmt, resultSet);
		}

		return list;
	}
	
	private <T extends BaseTable> int executorIUD(T t, String sql, boolean byKeyFlag, char step) {
		List<TableDefine> tableDefines = t.getTableDefines();
		Map<String, Object> tableFilds = t.getTableFileMap();
		Map<String, TableDefine> tableDefineMap = t.getTableDefinesMap();
		PreparedStatement stmt = null;
		int result = 0;
		StringBuffer paras = new StringBuffer();
		
		try {
			stmt = getJdbcConn().getConnection().prepareStatement(sql);
			int i = 0;
			
			if(Constant.SERVICE_PROCESS_STEP_INSERT == step) {
				for (TableDefine tableDefine : tableDefines) {
					i++;
					int typeNum = tableDefine.getColumnType().getColumnType();
					stmt.setObject(i, tableFilds.get(tableDefine.getColumnName()));
				}
			} else if(Constant.SERVICE_PROCESS_STEP_UPDATE == step) {
				for (Map.Entry<String, Object> entry : tableFilds.entrySet()) {
					i++;
					int typeNum = tableDefineMap.get(entry.getKey()).getColumnType().getColumnType();
					stmt.setObject(i, entry.getValue());
				}
			}
			

			
			

//			for (Map.Entry<String, Object> entry : tableFilds.entrySet()) {
//				i++;
//				int typeNum = tableDefineMap.get(entry.getKey()).getColumnType().getColumnType();
//				if(typeNum == 2004 || typeNum == 2005) {
//					stmt.setObject(i, entry.getValue());
//				} else if(typeNum == 1) {
//					stmt.setString(i, String.valueOf(entry.getValue()));
//				} else {
//					stmt.setObject(i, entry.getValue(), typeNum);
//				}
//				
//			}
			
			if(Constant.SERVICE_PROCESS_STEP_INSERT != step) {
				if(byKeyFlag) {
					List<TableDefine> pkFilds = t.getPkDefines();
					for (TableDefine pkDefine : pkFilds) {
						String columnNameString = pkDefine.getColumnName();
						Object value =t.getValue(columnNameString);
						i++;
						stmt.setObject(i, value);
						paras.append(columnNameString).append(":").append(value).append(SystemPlatformUtil.newLine());
					}
				} else {
					Map<String, Object> whereFilds = t.getWhereTableFileMap();
					
					for (Map.Entry<String, Object> entry : whereFilds.entrySet()) {
						i++;
						Object value = entry.getValue();
						stmt.setObject(i, value, tableDefineMap.get(entry.getKey()).getColumnType().getColumnType());
						paras.append(entry.getKey()).append(":").append(value).append(SystemPlatformUtil.newLine());
					}
				}
			}
			
			result = stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			setEndTime();
			double durTime = getDurTime();
			LoggerHandler.logSql("", this.getMesService().getClass().getSimpleName(), sql, paras.toString(), durTime);
			release(stmt, null);
		}
		
		return result;
	}


}
