package com.skynet.orm.base;

public class TableDefine {
	private String columnName;
	private String columnTypeName;
	private TableColumnType columnType;
	private int size;
	
	public String getColumnName() {
		return columnName;
	}
	
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	public String getColumnTypeName() {
		return columnTypeName;
	}
	
	public void setColumnTypeName(String columnTypeName) {
		this.columnTypeName = columnTypeName;
	}
	
	public TableColumnType getColumnType() {
		return columnType;
	}
	
	public void setColumnType(TableColumnType columnType) {
		this.columnType = columnType;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "TableDefine [columnName=" + columnName + ", columnTypeName=" + columnTypeName + ", columnType="
				+ columnType + ", size=" + size + "]";
	}
	
}
