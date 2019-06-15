package com.skynet.orm.util;

import java.util.HashMap;

public class ClassMapper {
	private static HashMap<String, Class> classMap = new HashMap();
	
	public static Class getClass(String className) {
		try {
			Class c = (Class) classMap.get(className);
			if (c != null) {
				return c;
			} else {
				c = Class.forName(className);
				classMap.put(className, c);
				return c;
			}
		} catch (ClassNotFoundException var2) {
			return null;
		}
	}

}
