package com.skynet.orm.base;

public enum TableColumnType {
	
	STRING(12), CHAR(1), BLOB(2004), CLOB(2005), DOUBLE(2), OTHER(-9999);
	
	private int columnType;
	
	
	private TableColumnType(int columnType) {
		this.columnType = columnType;
	}
	public int getColumnType() {
		return columnType;
	}

	public static TableColumnType transformType(int columnType) {
		switch (columnType) {
		case 12:
			return STRING;
		case 1:
			return CHAR;
		case 2:
			return DOUBLE;
		case 2004:
			return BLOB;
		case 2005:
			return CLOB;
		default:
			return OTHER;
		}
	}
	
	
	
	
	
	

}
