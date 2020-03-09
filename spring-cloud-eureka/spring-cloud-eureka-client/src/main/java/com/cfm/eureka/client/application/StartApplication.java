package com.cfm.eureka.client.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;



/**
 * 
* @Title:  StartApplication.java   
* @Package： com.cfm.eureka.client.application   
* @Description: TODO(Eureka客户端的启动类)   
*
* @version: v1.0.0
* @author: Chen WeiYu
* @date: 2019年12月4日 下午8:54:18
 */
@ComponentScan(basePackages= {"com.cfm.eureka.client.config",
		"com.cfm.eureka.client.test.web",
		"com.cfm.eureka.client.test.service"
		})
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.cfm.eureka.client.test.service"})
@EnableDiscoveryClient
public class StartApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);

	}
}
