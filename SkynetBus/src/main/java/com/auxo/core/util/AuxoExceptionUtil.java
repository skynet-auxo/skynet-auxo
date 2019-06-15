package com.skynet.orm.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import tmesis.util.Platform;

public class ExceptionUtil {
	
	public static String getCallStatck(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, true);
		e.printStackTrace(pw);
		String result = sw.getBuffer().toString();
		String[] resultList = result.split(Platform.newLine());
		StringBuilder sBuilder = new StringBuilder(2000);
		for(int i = 0; i < resultList.length; ++i) {
			if (resultList[i].indexOf("miracom") <= -1) {
				if (resultList[i].indexOf("H101Service.run") > -1) {
					break;
				}
				sBuilder.append(resultList[i]).append(SystemPlatformUtil.newLine());
			}
		}
		
		return sBuilder.toString();
	}

}
