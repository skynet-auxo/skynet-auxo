package com.skynet.orm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	
	public static String getCurrentDateStr(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return sdf.format(new Date());
	}
	
	public static long getCurrentTime() {
		return System.currentTimeMillis();
	}

}
