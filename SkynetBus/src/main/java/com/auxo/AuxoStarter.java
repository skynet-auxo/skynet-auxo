package com.skynet;

import com.skynet.handler.LoggerHandler;

public class Starter {
	
	public static boolean start() {
		try {
			if (!LoggerHandler.init()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			LoggerHandler.systemError("Server start Error", e);
			return false;
		}
		
	}
	
	
	
	
	

}
