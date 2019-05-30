package com.skynet.orm.util;

import com.skynet.constant.Constant;

public class SystemPlatformUtil {
	public static final String OS_TYPE = systemType();
	public static final String SPLITER = getSpliter();
	
	
	
	private static String systemType() {
		String osName = System.getProperty("os.name");
		if (osName.startsWith("Windows")) {
			return Constant.OS_TYPE_WINDOWS;
		} else if(osName.startsWith("Linux")) {
			return Constant.OS_TYPE_LINUX;
		} else {
			return Constant.OS_TYPE_OTHER;
		}
	}
	
	public static String newLine() {
		return System.getProperty("line.separator");
	}
	
	private static String getSpliter() {
		return Constant.OS_TYPE_WINDOWS.equals(OS_TYPE) ? "\\" : "/";
	}
	
	


}
