package com.skynet.orm.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

public class PathUtil {
	
	public static String getPath(Class<?> cls) {
		URL url = cls.getProtectionDomain().getCodeSource().getLocation();
		String filePath = null;
		try {
			filePath = URLDecoder.decode(url.getPath(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (filePath == null) {
			filePath = "";
		} else {
			if (filePath.endsWith(".jar")) {
				filePath = filePath.substring(0, filePath.lastIndexOf(47) + 1);
			}
			
			File file = new File(filePath);
			filePath = file.getAbsolutePath();
		}
		return filePath;
		
	}
	
	public static String getFilePath(String basePath, String filePath) {
		//to do something
		return basePath + filePath;
		
	}

}
