package com.skynet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration
@SpringBootApplication
//@EnableTransactionManagement // 开启事务管理
@EnableCaching //开启缓存
@EnableTransactionManagement
@ServletComponentScan
//@MapperScan("com.bootdo.*.dao")
public class SkeynetEyeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkeynetEyeApplication.class, args);
        System.out.println("ヾ(◍°∇°◍)ﾉﾞ    bootdo启动成功      ヾ(◍°∇°◍)ﾉﾞ\n" +
                
        		"           _______    __                          __               \n"+
        		"          /  _____|  |  |        \\\\            / /                   \n" +
        		"         /  /        |  |         \\\\          / /                  \n" +
        		"        /  /         |  |    ___   \\\\        / /                 \n" +
        		"       /  /          |  |   /  /    \\\\      / /                      \n" +
        		"       \\\\          |  |  /  /      \\\\    / /                    \n" +
        		"        \\\\         |  | /  /        \\\\  / /                          \n" +
        		"         \\\\        |  |/  /          \\\\/ /                      \n" +
        		"          \\\\       |  |\\\\           \\/ /                     \n" +
        		"           \\\\      |  | \\\\           / /                       \n" +
        		"            \\\\     |  |  \\\\         / /                        \n" +
        		"             )  )    |  |   \\\\       / /                        \n" +
        		"            /  /     |  |             / /                         \n"+
        		"           /  /      |  |            / /                         \n"+
        		"          /__/       |__|           /_/                           ");
	}

}
