/** 
 * Project Name: AuxoBus
 * File Name: AuxoUtil.java 
 * Package Name: com.auxo.util
 * History
 * Seq   Date        Developer      Description                        
 *  ---------------------------------------------------------------------------
 *  1    2019年02月27日    zeroLi        Create
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, zeroLi of AuXo All Rights Reserved. 
 * 
 */
package com.auxo.util;

public class AuxoUtil {
	
	public static String trim(String str) {
		return (str != null) ? str.trim() : null;
	}
	
	public static boolean isEmpty(String str) {
		if(str == null || "".equals(str)) {
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	

}
