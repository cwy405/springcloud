package com.cfm.eureka.server.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;



/**
 * 
 * <p>
 * 标题：启动类
 * </p>
 * <p>
 * 描述： Eureka服务器的启动类
 * </p>
 * <p>
 * CreateDate:2019年11月26日
 * </p>
 * @author cwy
 * @history 创建文档；Mender:cwy；Date:2019年11月26日；
 */
@SpringBootApplication
@EnableEurekaServer
public class ServerStartApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ServerStartApplication.class, args);

	}
}
