package com.cfm.eureka.client.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cfm.eureka.client.application.StartApplication;


/**
 * 
* @Title:  ServletInitializer.java   
* @Package： com.cfm.eureka.client.config   
* @Description: TODO(将工程加入到tomcat中运行时的初始化类)   
*
* @version: v1.0.0
* @author: Chen WeiYu
* @date: 2019年12月5日 下午4:53:48
 */
@ComponentScan(basePackages="com.cfm.eureka.client.config")
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //指向使用内嵌tomcat的启动类的main方法执行的Application启动类
        return builder.sources(StartApplication.class);
    }
}