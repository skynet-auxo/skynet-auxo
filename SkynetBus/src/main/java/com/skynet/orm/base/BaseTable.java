package com.skynet.orm.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseTable extends BaseObject implements Serializable{
	
	private String tableName = "";
	private Map<String, Object> tableFileMap = new HashMap<>();
	private Map<String, Object> whereTableFileMap = new HashMap<>();
	private Map<String, TableDefine> tableDefinesMap = new HashMap<>();
	private List<TableDefine> tableDefines = new ArrayList<>();
	private List<TableDefine> pkDefines = new ArrayList<>();

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public void setVaule(String key, Object value) {
		tableFileMap.put(key, value);
	}
	
	public void setWhereVaule(String key, Object value) {
		whereTableFileMap.put(key, value);
	}
	
	public Object getValue(String key) {
		tableFileMap.get(key);
		return tableFileMap.get(key);
	}

	public Map<String, Object> getTableFileMap() {
		return tableFileMap;
	}

	public List<TableDefine> getTableDefines() {
		return tableDefines;
	}

	public void setTableDefines(List<TableDefine> tableDefines) {
		this.tableDefines = tableDefines;
	}

	public List<TableDefine> getPkDefines() {
		return pkDefines;
	}

	public void setPkDefines(List<TableDefine> pkDefines) {
		this.pkDefines = pkDefines;
	}

	public Map<String, Object> getWhereTableFileMap() {
		return whereTableFileMap;
	}

	public Map<String, TableDefine> getTableDefinesMap() {
		return tableDefinesMap;
	}
}
