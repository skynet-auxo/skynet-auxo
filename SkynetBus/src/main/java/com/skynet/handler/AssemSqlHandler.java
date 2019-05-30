package com.skynet.handler;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.skynet.constant.Constant;
import com.skynet.orm.base.BaseTable;
import com.skynet.orm.base.TableDefine;

public class AssemSqlHandler {

	public static <T extends BaseTable> String build(T t, String dbProcessType) {
		String executableSqlString = "";
		switch (dbProcessType) {
		case Constant.DB_PROCESS_TYPE_INSERT:
			executableSqlString = insertSqlBuild(t);
			break;

		case Constant.DB_PROCESS_TYPE_UPDATE:
			executableSqlString = updateSqlBuild(t, false);
			break;

		case Constant.DB_PROCESS_TYPE_UPDATE_BY_KEY:
			executableSqlString = updateSqlBuild(t, true);
			break;
			
		case Constant.DB_PROCESS_TYPE_DELETE:
			executableSqlString = deleteSqlBuild(t, false);
			break;

		case Constant.DB_PROCESS_TYPE_DELETE_BY_KEY:
			executableSqlString = deleteSqlBuild(t, true);
			break;
		
		case Constant.DB_PROCESS_TYPE_QUERY:
			executableSqlString = querySqlBuild(t);
			break;

		case Constant.DB_PROCESS_TYPE_QUERY_BY_KEY:
			executableSqlString = querySqlBuild(t);
			break;
			
		case Constant.DB_PROCESS_TYPE_OTHERS:
			executableSqlString = queryTableBuild(t.getTableName());
			break;
		}
		return executableSqlString;

	}
	
	private static <T extends BaseTable> String insertSqlBuild(T t) {
		List<TableDefine> tableDefines = t.getTableDefines();
		
		StringBuffer sqlBuffer = new StringBuffer();
		StringBuffer commaBuffer = new StringBuffer();
		boolean firstColumnFlag = true;
		sqlBuffer.append("INSERT INTO "+t.getTableName() + " (");
		
		for (TableDefine tableDefine : tableDefines) {
			if(firstColumnFlag) {
				sqlBuffer.append(tableDefine.getColumnName());
				commaBuffer.append(" (").append("? ");
				firstColumnFlag = false;
			} else {
				sqlBuffer.append(", ").append(tableDefine.getColumnName());
				commaBuffer.append(", ").append("? ");
			}
		}
		
		sqlBuffer.append(")").append(" VALUES ").append(commaBuffer).append(")");
		return sqlBuffer.toString();
		
	}
	
	private static <T extends BaseTable> String updateSqlBuild(T t, boolean byKeyFlag) {
		Map<String, Object> tableFiles= t.getTableFileMap();
		StringBuffer sqlBuffer = new StringBuffer();
		StringBuffer whereBuffer = new StringBuffer();
		boolean firstColumnFlag = true;
		sqlBuffer.append("UPDATE "+t.getTableName() + " SET ");
		whereBuffer.append(" WHERE ");
		
		for (Map.Entry<String, Object> entry : tableFiles.entrySet()) {
			if(firstColumnFlag) {
				sqlBuffer.append(entry.getKey() + " = ? ");
				firstColumnFlag = false;
			} else {
				sqlBuffer.append(", " + entry.getKey() + " = ? ");
			}
		}
		
		firstColumnFlag = true;
		
		//assem update sql by pk 
		if(byKeyFlag) {
			List<TableDefine> pkDefines = t.getPkDefines();
			for (TableDefine pkdef : pkDefines) {
				if(firstColumnFlag) {
					whereBuffer.append(pkdef.getColumnName() + " = ? ");
					firstColumnFlag = false;
				} else {
					whereBuffer.append("AND " + pkdef.getColumnName() + " = ?");
				}
			}
			
			sqlBuffer.append(whereBuffer);
			return sqlBuffer.toString();
		} 
		
		Map<String, Object> whereTableFiles= t.getWhereTableFileMap();
		sqlBuffer.append(whereConditionBuild(whereTableFiles));
		return sqlBuffer.toString();
	}
	
	private static <T extends BaseTable> String deleteSqlBuild(T t, boolean byKeyFlag) {
		Map<String, Object> tableFiles = t.getTableFileMap();
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("DELETE FROM "+t.getTableName());
		
		if(byKeyFlag) {
			boolean firstColumnFlag = true;
			
			List<TableDefine> pkDefines = t.getPkDefines();
			
			for (TableDefine pkdef : pkDefines) {
				if(firstColumnFlag) {
					sqlBuffer.append(" WHERE " + pkdef.getColumnName() + " = ? ");
					firstColumnFlag = false;
				} else {
					sqlBuffer.append("AND " + pkdef.getColumnName() + " = ?");
				}
			}
			
			return sqlBuffer.toString();
		}
		sqlBuffer.append(whereConditionBuild(tableFiles));
		return sqlBuffer.toString();
	}
	
	

	private static <T extends BaseTable> String querySqlBuild(T t) {
		Map<String, Object> tableFiles = t.getTableFileMap();
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("SELECT * FROM "+t.getTableName());
		sqlBuffer.append(whereConditionBuild(tableFiles));
		return sqlBuffer.toString();

	}
	
	private static String queryTableBuild(String tableName) {
		return new StringBuffer("SELECT * FROM ").append(tableName).append(" WHERE ROWNUM = 1").toString();
	}
	
	private static StringBuffer whereConditionBuild(Map<String, Object> tableFiles) {
		boolean andFlag = true;
		StringBuffer wherelBuffer = new StringBuffer();
		for (Map.Entry<String, Object> entry : tableFiles.entrySet()) {
			if(andFlag) {
				wherelBuffer.append(" WHERE ");
				wherelBuffer.append(entry.getKey() + "= ?");
				andFlag = false;
			} else {
				wherelBuffer.append(" AND " + entry.getKey() + "= ?");
			}
		}
		
		return wherelBuffer;
	}

}
