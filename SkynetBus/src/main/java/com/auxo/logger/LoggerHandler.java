/** 
 * Project Name: AuxoBus
 * File Name:LoggerHandler.java 
 * Package Name:com.auxo.core.handler
 * History
 * Seq   Date        Developer      Description                        
 *  ---------------------------------------------------------------------------
 *  1    2019年02月28日    zeroLi        Create
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, zeroLi of AuXo All Rights Reserved. 
 * 
 */
package com.auxo.logger;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auxo.AuxoBusApplication;
import com.auxo.core.config.Config;
import com.auxo.core.constant.Constant;
import com.auxo.core.util.AuxoDateUtil;
import com.auxo.core.util.AuxoExceptionUtil;
import com.auxo.core.util.AuxoPathUtil;
import com.auxo.core.util.AuxoSystemPlatformUtil;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;

public class LoggerHandler {
	
	private static Logger log;
	
	public static boolean init() throws Exception {
		String path = AuxoPathUtil.getPath(AuxoBusApplication.class);
		
		if (!"".equals(Config.Instance.SYSTEM_HOME_PATH.trim())) {
			path = Config.Instance.SYSTEM_HOME_PATH;
		}
		
		String configFilePath = AuxoPathUtil.getFilePath(path, "/config/logback.xml");
		if (configFilePath == "") {
			throw new Exception("can not find configure file(/config/logback.xml)");
		} else {
			File logbackFile = new File(configFilePath);
			if (logbackFile.exists()) {
				LoggerContext loggerContext = (LoggerContext)LoggerFactory.getILoggerFactory();
				JoranConfigurator configurator = new JoranConfigurator();
				configurator.setContext(loggerContext);
				loggerContext.reset();
				configurator.doConfigure(logbackFile);
			}
			
			log = LoggerFactory.getLogger("MESSERVER");
			return true;
		}
		
	}
	
	public static void logSql(String requestID, String serviceName, String sql, String paras, double durTime) {
		if (Config.Instance.LOG_SQL_FLAG) {
			String format = "[SQL INFO] : ReqiestId= %s "+ AuxoSystemPlatformUtil.newLine() +"ServiceName= %s "+ AuxoSystemPlatformUtil.newLine() +"Sql= %s"+ AuxoSystemPlatformUtil.newLine() +"Paras: [%s]"+ AuxoSystemPlatformUtil.newLine() +"TIME=%s ";
			log.info(String.format(format, requestID, serviceName, sql, paras, durTime));
		}
	}
	
	public static void serviceError(String threadName, String clientID, String serviceName, String msg) {
		log.error(String.format(AuxoSystemPlatformUtil.newLine(), threadName, AuxoDateUtil.getCurrentDateStr(Constant.DATA_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS), clientID, serviceName, msg));
	}
	
	public static void serviceInfo(String threadName, String clientID, String serviceName, String msg) {
		log.info(String.format(AuxoSystemPlatformUtil.newLine(), threadName, AuxoDateUtil.getCurrentDateStr(Constant.DATA_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS), clientID, serviceName, msg));
	}
	
	public static void serviceDebug(String threadName, String clientID, String serviceName, String msg) {
		log.debug(String.format(AuxoSystemPlatformUtil.newLine(), threadName, AuxoDateUtil.getCurrentDateStr(Constant.DATA_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS), clientID, serviceName, msg));
	}
	
	public static void systemError(String msg, Exception e) {
		if (Config.Instance.LOG_SYSTEM_FLAG) {
			log.error(String.format(AuxoSystemPlatformUtil.newLine(), AuxoDateUtil.getCurrentDateStr(Constant.DATA_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS), msg, AuxoExceptionUtil.getCallStatck(e)));
		}
	}
	
	public static void systemError(String msg) {
		if (Config.Instance.LOG_SYSTEM_FLAG) {
			log.error(String.format("[SYSTEM] TIME=%s Type=[Eerror] Msg=[%s]", AuxoDateUtil.getCurrentDateStr(Constant.DATA_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS), msg));
		}
	}
	
	public static void systemInfo(String msg) {
		if (Config.Instance.LOG_SYSTEM_FLAG) {
			log.info(String.format("[SYSTEM] TIME=%s Type=[Info] Msg=[%s]", AuxoDateUtil.getCurrentDateStr(Constant.DATA_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS), msg));
		}
	}
	
	public static void systemDebug(String msg) {
		if (Config.Instance.LOG_SYSTEM_FLAG) {
			log.debug(String.format("[SYSTEM] TIME=%s Type=[Debug] Msg=[%s]", AuxoDateUtil.getCurrentDateStr(Constant.DATA_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS), msg));
		}
	}

}
