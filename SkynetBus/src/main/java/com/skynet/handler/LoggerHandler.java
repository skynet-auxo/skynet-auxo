package com.skynet.handler;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skynet.SkynetBusApplication;
import com.skynet.config.Config;
import com.skynet.constant.Constant;
import com.skynet.orm.util.DataUtil;
import com.skynet.orm.util.ExceptionUtil;
import com.skynet.orm.util.PathUtil;
import com.skynet.orm.util.SystemPlatformUtil;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;

public class LoggerHandler {
	
	private static Logger log;
	
	public static boolean init() throws Exception {
		String path = PathUtil.getPath(SkynetBusApplication.class);
		
		if (!"".equals(Config.Instance.SYSTEM_HOME_PATH.trim())) {
			path = Config.Instance.SYSTEM_HOME_PATH;
		}
		
		String configFilePath = PathUtil.getFilePath(path, "/config/logback.xml");
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
			String format = "[SQL INFO] : ReqiestId= %s "+ SystemPlatformUtil.newLine() +"ServiceName= %s "+ SystemPlatformUtil.newLine() +"Sql= %s"+ SystemPlatformUtil.newLine() +"Paras: [%s]"+ SystemPlatformUtil.newLine() +"TIME=%s ";
			log.info(String.format(format, requestID, serviceName, sql, paras, durTime));
		}
	}
	
	public static void serviceError(String threadName, String clientID, String serviceName, String msg) {
		log.error(String.format(SystemPlatformUtil.newLine(), threadName, DataUtil.getCurrentDateStr(Constant.DATA_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS), clientID, serviceName, msg));
	}
	
	public static void serviceInfo(String threadName, String clientID, String serviceName, String msg) {
		log.info(String.format(SystemPlatformUtil.newLine(), threadName, DataUtil.getCurrentDateStr(Constant.DATA_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS), clientID, serviceName, msg));
	}
	
	public static void serviceDebug(String threadName, String clientID, String serviceName, String msg) {
		log.debug(String.format(SystemPlatformUtil.newLine(), threadName, DataUtil.getCurrentDateStr(Constant.DATA_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS), clientID, serviceName, msg));
	}
	
	public static void systemError(String msg, Exception e) {
		if (Config.Instance.LOG_SYSTEM_FLAG) {
			log.error(String.format(SystemPlatformUtil.newLine(), DataUtil.getCurrentDateStr(Constant.DATA_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS), msg, ExceptionUtil.getCallStatck(e)));
		}
	}
	
	public static void systemError(String msg) {
		if (Config.Instance.LOG_SYSTEM_FLAG) {
			log.error(String.format("[SYSTEM] TIME=%s Type=[Eerror] Msg=[%s]", DataUtil.getCurrentDateStr(Constant.DATA_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS), msg));
		}
	}
	
	public static void systemInfo(String msg) {
		if (Config.Instance.LOG_SYSTEM_FLAG) {
			log.info(String.format("[SYSTEM] TIME=%s Type=[Info] Msg=[%s]", DataUtil.getCurrentDateStr(Constant.DATA_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS), msg));
		}
	}
	
	public static void systemDebug(String msg) {
		if (Config.Instance.LOG_SYSTEM_FLAG) {
			log.debug(String.format("[SYSTEM] TIME=%s Type=[Debug] Msg=[%s]", DataUtil.getCurrentDateStr(Constant.DATA_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS), msg));
		}
	}

}
