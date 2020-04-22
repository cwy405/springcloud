package com.cfm.eureka.provide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;



/**
 * 
* @Title:  ProvideClientApplication.java   
* @Package： com.cfm.application   
* @Description: TODO(Eureka服务提供方的启动类)   
*
* @version: v1.0.0
* @author: Chen WeiYu
* @date: 2019年12月4日 下午8:34:55
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ProvideClientApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProvideClientApplication.class, args);

	}
}
