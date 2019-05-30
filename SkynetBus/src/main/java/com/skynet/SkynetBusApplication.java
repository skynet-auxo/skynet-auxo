package com.skynet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.skynet.config.Config;
import com.skynet.orm.util.SpringUtil;

@SpringBootApplication
public class SkynetBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkynetBusApplication.class, args);
		Config config = SpringUtil.getBean(Config.class);
		config.Instance = config;
		if (!Starter.start()) {
			System.exit(0);
		}
	}

}
